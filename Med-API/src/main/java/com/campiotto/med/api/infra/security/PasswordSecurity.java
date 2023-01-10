package com.campiotto.med.api.infra.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordSecurity implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {

        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
    }
}
