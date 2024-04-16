package com.ownhealthcareuserService.repository;

import com.ownhealthcareuserService.dto.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPersonalInfoRepository extends JpaRepository<UserPersonalInfo, Long> {

}
