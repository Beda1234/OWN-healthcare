package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientMedicalHistory {
    private String condition;
    private String surgery;
    private String allergies;
    private String hereditaryDiseases;
}
