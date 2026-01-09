package com.ratel.user_server.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthService(PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
    public AuthService(PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    /*public UserCredential addUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        return repository.save(credential);
    }*/

    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return jwtService.validateToken(token, userDetails);
    }

}
