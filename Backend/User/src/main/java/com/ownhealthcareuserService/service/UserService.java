package com.ownhealthcareuserService.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.ownhealthcareuserService.dto.UserInfo;
import com.ownhealthcareuserService.dto.UserPersonalInfo;
import com.ownhealthcareuserService.model.PatientPersonalInfo;
import com.ownhealthcareuserService.model.User;
import com.ownhealthcareuserService.repository.UserPersonalInfoRepository;
import com.ownhealthcareuserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPersonalInfoRepository userPersonalInfoRepository;

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

    /*
     To add user personal information.
     */
    public UserPersonalInfo addUserPersonalInfo(PatientPersonalInfo patientPersonalInfo, String email){
        UserPersonalInfo userPersonalInfo = new UserPersonalInfo();

        Optional<UserInfo> userdata = userRepository.findByEmail(email);
        if(userdata.isPresent()) {
            UserInfo userInfo = userdata.get();
            userPersonalInfo.setFullName(userInfo.getFirstName() + " " + userInfo.getLastName());
            userPersonalInfo.setDateOfBirth(patientPersonalInfo.getDateOfBirth());
            userPersonalInfo.setAddress(patientPersonalInfo.getAddress());
            userPersonalInfo.setPhoneNumber(patientPersonalInfo.getPhoneNumber());
            return userPersonalInfoRepository.save(userPersonalInfo);
        }
         else {
            throw new IllegalArgumentException("UserInfo not found for email: " + email);
        }
    }
}
