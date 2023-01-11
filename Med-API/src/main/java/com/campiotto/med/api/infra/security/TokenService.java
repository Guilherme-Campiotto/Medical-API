package com.campiotto.med.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.campiotto.med.api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        String token;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withSubject(user.getLogin())
                    .withIssuer("API Medical")
                    .withExpiresAt(dateExpiry())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw  new RuntimeException("Error generating token JWT", exception);
        }

        return token;
    }

    private Instant dateExpiry() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
