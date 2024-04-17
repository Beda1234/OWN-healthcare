package com.ownhealthcareuserService.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patientPersonalInfo")
public class UserPersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
}
