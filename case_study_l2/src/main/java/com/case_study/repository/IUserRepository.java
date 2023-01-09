package com.case_study.repository;


import com.case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// BƯớc 3: Tạo Repo
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
