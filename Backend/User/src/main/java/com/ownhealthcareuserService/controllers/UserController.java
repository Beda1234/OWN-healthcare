package com.ownhealthcareuserService.controllers;

import com.ownhealthcareuserService.dto.UserInfo;
import com.ownhealthcareuserService.model.User;
import com.ownhealthcareuserService.repository.UserRepository;
import com.ownhealthcareuserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/own-healthcare/auth")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/response")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("You are in secure place");
    }
    @GetMapping("/users")
    public List<UserInfo> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/userInfo")
    public ResponseEntity<List<User>> getUser(@RequestParam("email")String email){
        List<User> userData = userService.getUserInfo(email);
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }
}
