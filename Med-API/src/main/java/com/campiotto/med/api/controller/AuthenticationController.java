package com.campiotto.med.api.controller;

import com.campiotto.med.api.domain.AuthenticationData;
import com.campiotto.med.api.domain.user.User;
import com.campiotto.med.api.infra.security.TokenDataJWT;
import com.campiotto.med.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity loginUser(@RequestBody @Valid AuthenticationData authenticationData) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authenticationData.login(), authenticationData.password());
        Authentication authentication = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDataJWT(tokenJWT));
    }

}
