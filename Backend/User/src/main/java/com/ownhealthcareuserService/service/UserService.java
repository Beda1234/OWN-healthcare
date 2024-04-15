package com.ownhealthcareuserService.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.ownhealthcareuserService.dto.UserInfo;
import com.ownhealthcareuserService.model.User;
import com.ownhealthcareuserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUserInfo(String email){
        Optional<UserInfo> userdata = userRepository.findByEmail(email);
        return userdata.stream().map(user ->{
            User userinfo = new User();
            userinfo.setFirstName(user.getFirstName());
            userinfo.setLastName(user.getLastName());
            userinfo.setEmail(user.getEmail());
            return userinfo;
        }).collect(Collectors.toList());
    }
}
