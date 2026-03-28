package com.ingesoft.auth.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ingesoft1_users")
public class Ingesoft1User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String secretPhrase;

    // getters y setters
    public Long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getSecretPhrase() {
        return secretPhrase;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setSecretPhrase(String secretPhrase) {
        this.secretPhrase = secretPhrase;
    }
}