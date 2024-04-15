package com.ownhealthcareuserService.controllers;

import java.io.IOException;

import com.ownhealthcareuserService.authentication.AuthenticationRequest;
import com.ownhealthcareuserService.authentication.AuthenticationResponse;
import com.ownhealthcareuserService.dto.Role;
import com.ownhealthcareuserService.model.User;
import com.ownhealthcareuserService.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/own-healthcare/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request, @RequestParam(name = "role", defaultValue = "USER") Role role) {
        return ResponseEntity.ok(service.register(request, role));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request	) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken( HttpServletRequest request,HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }
}
