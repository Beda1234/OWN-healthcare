package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicationHistory {

    private String prescription;
    private String counter;
    private List<String> supplements;
    private String dosage;
    private String frequency;
    private List<String> allergies;
    private String intolerance;
}
