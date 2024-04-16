package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientPersonalInfo {

    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;

}
