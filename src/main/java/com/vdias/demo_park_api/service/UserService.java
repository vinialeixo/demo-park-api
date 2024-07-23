package com.vdias.demo_park_api.service;

import org.springframework.stereotype.Service;

import com.vdias.demo_park_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//TODO:PESQUISAR SOBRE ESSA ANOTAÇÃO
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
}
