package com.ingesoft.auth.service;

import com.ingesoft.auth.domain.Ingesoft1User;
import com.ingesoft.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Object> authenticate(String correo, String password) {

        Optional<Ingesoft1User> userOpt = userRepository.findByCorreo(correo);

        HashMap<String, Object> res = new HashMap<>();

        if (userOpt.isEmpty()) {
            res.put("success", false);
            res.put("message", "Usuario no encontrado");
            return res;
        }

        Ingesoft1User user = userOpt.get();

        if (!hashPassword(password).equals(user.getPasswordHash())) {
            res.put("success", false);
            res.put("message", "Contraseña incorrecta");
            return res;
        }

        res.put("success", true);
        res.put("secretPhrase", user.getSecretPhrase());
        return res;
    }
}