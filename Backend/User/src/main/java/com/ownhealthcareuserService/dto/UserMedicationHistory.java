package com.ownhealthcareuserService.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patientMedicationHistory")
public class UserMedicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String prescription;
    private String counter;
    private List<String> supplements;
    private String dosage;
    private String frequency;
    private List<String> allergies;
    private String intolerance;
}
