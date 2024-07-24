package com.vdias.demo_park_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vdias.demo_park_api.entity.User;
import com.vdias.demo_park_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//TODO:PESQUISAR SOBRE ESSA ANOTAÇÃO
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User searchById(Long id) {
        return userRepository.findById(id).orElseThrow(
            () -> new RuntimeException("User not found")
        );
    }

    @Transactional
    public User editPassword(Long id, String password) {
        User user = searchById(id);
        user.setPassword(password);
        return user;
    }
}
