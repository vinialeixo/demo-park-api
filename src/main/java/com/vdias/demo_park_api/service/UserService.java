package com.vdias.demo_park_api.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vdias.demo_park_api.entity.User;
import com.vdias.demo_park_api.exception.EntityNotFoundException;
import com.vdias.demo_park_api.exception.UsernameUniqueViolationException;
import com.vdias.demo_park_api.repository.UserRepository;
import com.vdias.demo_park_api.web.dto.UserPasswordDto;

import lombok.RequiredArgsConstructor;

//TODO:PESQUISAR SOBRE ESSA ANOTAÇÃO
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional

    public User save(User user) {
        try {
            return userRepository.save(user);
            
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("Usernmae {%s} is already cadastrer",user.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public User searchById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("User id=%s not found.", id)));
    }

    @Transactional
    public User editPassword(Long id, UserPasswordDto dto) {
        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            throw new RuntimeException("New password does not match");
        }

        User user = searchById(id);

        if (!user.getPassword().equals(dto.getCurrentPassword())) {
            throw new RuntimeException("Password does not match");
        }
        user.setPassword(dto.getNewPassword());
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
