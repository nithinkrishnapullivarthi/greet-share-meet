package com.seproject.meetgreetapp.controller;

import com.seproject.meetgreetapp.dto.response.StudentResponseDTO;
import com.seproject.meetgreetapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> getMatchingInterestStudentDetails(@RequestParam (name = "studentId") Long studentId){
        return studentService.getStudentDetailsWithMatchingInterests(studentId);
    }

}
