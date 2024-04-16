package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientImmunizationRecord {

    private String vaccinationName;
    private String vaccinationType;
    private Date vaccinatedDate;
    private String schedule;
}
