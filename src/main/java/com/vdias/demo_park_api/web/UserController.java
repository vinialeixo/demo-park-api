package com.vdias.demo_park_api.web;

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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User userResponse =  userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User userResponse =  userService.searchById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id,@RequestBody User user){
        User userResponse =  userService.editPassword(id,user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
