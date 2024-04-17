package com.ownhealthcareuserService.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patientMedicalHistory")
public class UserMedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String currentCondition;
    private boolean surgery;
    private String surgeryInfo;
    private List<String> allergies;
    private List<String> hereditaryDiseases;
}
