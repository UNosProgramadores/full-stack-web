package com.ingesoft.auth.repository;

import com.ingesoft.auth.domain.Ingesoft1User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Ingesoft1User, Long> {
    Optional<Ingesoft1User> findByCorreo(String correo);
}