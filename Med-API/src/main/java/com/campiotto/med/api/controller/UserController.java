package com.campiotto.med.api.controller;

import com.campiotto.med.api.domain.doctor.DoctorRepository;
import com.campiotto.med.api.domain.doctor.DoctorUpdate;
import com.campiotto.med.api.domain.user.User;
import com.campiotto.med.api.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/create")
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid User user, UriComponentsBuilder uriBuilder) {

        userRepository.save(user);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
