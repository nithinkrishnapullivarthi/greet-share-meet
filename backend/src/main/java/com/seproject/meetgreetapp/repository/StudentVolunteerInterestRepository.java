package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface StudentVolunteerInterestRepository extends JpaRepository<StudentVolunteerInterest, Integer> {
    public List<StudentVolunteerInterest> findByStudentId(Integer studentId);
    public List<StudentVolunteerInterest> findAllByStudentIdIn(Set<Integer> interestIds);
    public void deleteByStudentId(Integer studentId);
}

