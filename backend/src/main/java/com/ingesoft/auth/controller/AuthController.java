package com.ingesoft.auth.controller;

import com.ingesoft.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {

        String correo = body.get("correo");
        String password = body.get("password");

        if (correo == null || password == null) {
            return Map.of("success", false, "message", "Campos requeridos");
        }

        return authService.authenticate(correo, password);
    }
}