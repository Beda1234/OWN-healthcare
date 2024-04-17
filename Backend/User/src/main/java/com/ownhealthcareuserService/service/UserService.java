package com.ownhealthcareuserService.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.ownhealthcareuserService.dto.UserInfo;
import com.ownhealthcareuserService.dto.UserMedicalHistory;
import com.ownhealthcareuserService.dto.UserMedicationHistory;
import com.ownhealthcareuserService.dto.UserPersonalInfo;
import com.ownhealthcareuserService.model.*;
import com.ownhealthcareuserService.repository.MedicalHistoryRepository;
import com.ownhealthcareuserService.repository.MedicationHistoryRepository;
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
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;
    @Autowired
    private MedicationHistoryRepository medicationHistoryRepository;

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
    public UserPersonalInfo addPatientPersonalInfo(PatientPersonalInfo patientPersonalInfo, String email){
        UserPersonalInfo userPersonalInfo = new UserPersonalInfo();

        Optional<UserInfo> userdata = userRepository.findByEmail(email);
        if(userdata.isPresent()) {
            UserInfo userInfo = userdata.get();
            userPersonalInfo.setFullName(userInfo.getFirstName() + " " + userInfo.getLastName());
            userPersonalInfo.setDateOfBirth(patientPersonalInfo.getDateOfBirth());
            userPersonalInfo.setGender(patientPersonalInfo.getGender());
            userPersonalInfo.setAddress(patientPersonalInfo.getAddress());
            userPersonalInfo.setPhoneNumber(patientPersonalInfo.getPhoneNumber());
            return userPersonalInfoRepository.save(userPersonalInfo);
        }
         else {
            throw new IllegalArgumentException("UserInfo not found for email: " + email);
        }
    }

    /*
    To add User Medical Hostory
    */
    public UserMedicalHistory addUserMedicalHistory(PatientMedicalHistory patientMedicalHistory){
        UserMedicalHistory userMedicalHistory = new UserMedicalHistory();

        userMedicalHistory.setCurrentCondition(patientMedicalHistory.getCondition());
        userMedicalHistory.setSurgery(patientMedicalHistory.isSurgery());
        userMedicalHistory.setSurgeryInfo(patientMedicalHistory.getSurgeryInfo());
        userMedicalHistory.setAllergies(patientMedicalHistory.getAllergies());
        userMedicalHistory.setHereditaryDiseases(patientMedicalHistory.getHereditaryDiseases());
        return medicalHistoryRepository.save(userMedicalHistory);
    }

    /*
     To add user medication history.
     */
    public UserMedicationHistory addUserMedicationHistory(PatientMedicationHistory patientMedicationHistory){
        UserMedicationHistory userMedicationHistory = new UserMedicationHistory();

        userMedicationHistory.setPrescription(patientMedicationHistory.getPrescription());
        userMedicationHistory.setCounter(patientMedicationHistory.getCounter());
        userMedicationHistory.setDosage(patientMedicationHistory.getDosage());
        userMedicationHistory.setSupplements(patientMedicationHistory.getSupplements());
        userMedicationHistory.setFrequency(patientMedicationHistory.getFrequency());
        userMedicationHistory.setAllergies(patientMedicationHistory.getAllergies());
        userMedicationHistory.setIntolerance(patientMedicationHistory.getIntolerance());
        return medicationHistoryRepository.save(userMedicationHistory);
    }

    /*
    To fetch patient all information.
   */
    public PatientAllInformation getPatientAllInformation(long id){
        UserPersonalInfo userPersonalInfo = userPersonalInfoRepository.findById(id).orElse(null);
        UserMedicalHistory userMedicalHistory = medicalHistoryRepository.findById(id).orElse(null);
        UserMedicationHistory userMedicationHistory = medicationHistoryRepository.findById(id).orElse(null);

        PatientAllInformation patientAllInformation = new PatientAllInformation();
        patientAllInformation.setUserPersonalInfo(userPersonalInfo);
        patientAllInformation.setUserMedicalHistory(userMedicalHistory);
        patientAllInformation.setUserMedicationHistory(userMedicationHistory);
        return patientAllInformation;
    }
}
