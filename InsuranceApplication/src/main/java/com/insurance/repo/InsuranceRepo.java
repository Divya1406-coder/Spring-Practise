package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.User;

@Repository
public interface InsuranceRepo extends JpaRepository<User, String>{

}
