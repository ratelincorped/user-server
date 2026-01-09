package com.ratel.user_server.jwt.controller;

import com.ratel.user_server.jwt.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public record AuthController(AuthService authService) {
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/register")
//    public UserCredential addNewUser(@RequestBody UserCredential user) {
//        return authService.addUser(user);
//    }
//
//    @PostMapping("/token")
//    public String getToken(@RequestBody UserCredential userCredential) {
//        return authService.generateToken(userCredential.getEmail());
//    }

    @GetMapping("/validate")
    public Boolean validateToken(@RequestParam("token") String token, @RequestBody UserDetails userDetails) {
        return authService.validateToken(token, userDetails);
    }

}
