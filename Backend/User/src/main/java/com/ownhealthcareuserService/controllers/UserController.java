package com.ownhealthcareuserService.controllers;

import com.ownhealthcareuserService.dto.UserInfo;
import com.ownhealthcareuserService.dto.UserMedicalHistory;
import com.ownhealthcareuserService.dto.UserPersonalInfo;
import com.ownhealthcareuserService.model.PatientMedicalHistory;
import com.ownhealthcareuserService.model.PatientPersonalInfo;
import com.ownhealthcareuserService.model.User;
import com.ownhealthcareuserService.repository.UserRepository;
import com.ownhealthcareuserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*
        To add user personal information.
     */
    @PostMapping("/create")
    public ResponseEntity<UserPersonalInfo> addUserInformation(@RequestBody PatientPersonalInfo patientPersonalInfo, @RequestParam String email){
        UserPersonalInfo userPersonalInfo = userService.addUserPersonalInfo(patientPersonalInfo,email);
        return new ResponseEntity<>(userPersonalInfo,HttpStatus.CREATED);
    }

    /*
     To add User Medical History
     */
    @PostMapping("/createMedicalHistory")
    public ResponseEntity<UserMedicalHistory> createMedicalHistory(@RequestBody PatientMedicalHistory patientMedicalHistory){
        UserMedicalHistory userMedicalHistory = userService.addUserMedicalHistory(patientMedicalHistory);
        return new ResponseEntity<>(userMedicalHistory,HttpStatus.CREATED);
    }
}
