package com.ownhealthcareuserService.repository;

import com.ownhealthcareuserService.dto.UserMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<UserMedicalHistory, Long> {
}
