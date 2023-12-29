package com.etu.dbi.controller;

import com.etu.dbi.model.LoginRequest;
import com.etu.dbi.model.LoginResponse;
import com.etu.dbi.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        String token = jwtIssuer.issue(1L, request.getUsername(), List.of("USER"));
        return LoginResponse.builder()
                .accesToken(token)
                .build();
    }
}
