package com.case_study.repository.contract;

import com.case_study.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachRepository extends JpaRepository<AttachFacility, Integer> {
}
