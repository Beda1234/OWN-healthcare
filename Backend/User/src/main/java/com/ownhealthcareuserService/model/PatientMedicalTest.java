package com.ownhealthcareuserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicalTest {

    private String bloodTestReport;
    private String urineTestReport;
    private String biopsyResults;
}
