package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.StudentInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterestRepository extends JpaRepository<StudentInterest, Integer> {
}

