package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicationHistory {

    private String prescription;
    private String counter;
    private String supplements;
    private String dosage;
    private String frequency;
    private String allergies;
    private String intolerance;

}
