package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentVolunteerInterestRepository extends JpaRepository<StudentVolunteerInterest, Integer> {
    public List<StudentInterest> findByStudentId(Integer studentId);
    public List<StudentInterest> findByVolunteerInterestIdIn(List<Integer> interestIds);
}

