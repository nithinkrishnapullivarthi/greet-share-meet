package com.seproject.meetgreetapp.repository;


import com.seproject.meetgreetapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findByUsername(String username);
    public Student findByUsernameAndPassword(String username, String password);
}

