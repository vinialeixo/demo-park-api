package com.vdias.demo_park_api.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vdias.demo_park_api.entity.User;
import com.vdias.demo_park_api.service.UserService;
import com.vdias.demo_park_api.web.dto.UserCreateDto;
import com.vdias.demo_park_api.web.dto.UserPasswordDto;
import com.vdias.demo_park_api.web.dto.UserResponseDto;
import com.vdias.demo_park_api.web.dto.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto createDto){
        User userResponse =  userService.save(UserMapper.toUser(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(userResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        User userResponse =  userService.searchById(id);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toDto(userResponse));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id,@RequestBody UserPasswordDto dto){
        User userResponse =  userService.editPassword(id,dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getAll(){
        List<User> users =  userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toListDto(users));
    }
}
