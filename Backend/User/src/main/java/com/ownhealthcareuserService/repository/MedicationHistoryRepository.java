package com.ownhealthcareuserService.repository;

import com.ownhealthcareuserService.dto.UserMedicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationHistoryRepository extends JpaRepository<UserMedicationHistory, Long> {

}
