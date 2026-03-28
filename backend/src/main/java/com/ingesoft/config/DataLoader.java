package com.ingesoft.config;

import com.ingesoft.auth.domain.Ingesoft1User;
import com.ingesoft.auth.repository.UserRepository;
import com.ingesoft.auth.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo, AuthService service) {
        return args -> {

            if (repo.findByCorreo("estudiante@universidad.edu.co").isEmpty()) {

                Ingesoft1User user = new Ingesoft1User();
                user.setCorreo("estudiante@universidad.edu.co");
                user.setPasswordHash(service.hashPassword("MiPassword123"));
                user.setSecretPhrase("¡Felicitaciones! Has completado el ejercicio Full-Stack 🚀");

                repo.save(user);
            }
        };
    }
}