package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientMedicalHistory {
    private String condition;
    private boolean surgery;
    private String surgeryInfo;
    private List<String> allergies;
    private List<String> hereditaryDiseases;
}
