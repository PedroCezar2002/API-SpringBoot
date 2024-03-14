package com.example.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    
    public interface createUser {
    }

    public interface updateUser {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;

    @Column(name="username", length = 100, nullable = false, unique=true)
    @NotNull(groups = createUser.class)
    @NotEmpty(groups = createUser.class)
    @Size(groups = createUser.class, min = 3, max = 100)
    private String username;

    @Column(name = "password",length = 40 ,nullable = false)
    @NotNull(groups = {createUser.class, updateUser.class})
    @NotEmpty(groups = {createUser.class, updateUser.class})
    @Size(groups = {createUser.class, updateUser.class}, min = 8, max = 40)
    private String password;

}
