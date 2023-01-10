package com.campiotto.med.api.controller;

import com.campiotto.med.api.domain.AuthenticationData;
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

    @PostMapping
    public ResponseEntity loginUser(@RequestBody @Valid AuthenticationData authenticationData) {
        var token = new UsernamePasswordAuthenticationToken(authenticationData.login(), authenticationData.password());
        Authentication authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().body(token);
    }

}
