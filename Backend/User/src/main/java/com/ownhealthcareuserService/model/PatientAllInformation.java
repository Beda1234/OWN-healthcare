package com.ownhealthcareuserService.model;

import com.ownhealthcareuserService.dto.UserMedicalHistory;
import com.ownhealthcareuserService.dto.UserMedicationHistory;
import com.ownhealthcareuserService.dto.UserPersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAllInformation {

    private UserPersonalInfo userPersonalInfo;
    private UserMedicalHistory userMedicalHistory;
    private UserMedicationHistory userMedicationHistory;
}
