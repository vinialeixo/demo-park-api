package com.vdias.demo_park_api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.vdias.demo_park_api.entity.enums.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "role", nullable = false, length = 25)

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_CLIENTE;

    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private String createrUser;
    private String modificadoPor;

}
