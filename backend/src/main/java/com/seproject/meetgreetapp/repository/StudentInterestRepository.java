package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.StudentInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentInterestRepository extends JpaRepository<StudentInterest, Integer> {
    public List<StudentInterest> findByStudentId(Integer studentId);
    public List<StudentInterest> findByInterestIdIn(List<Integer> interestIds);
}

