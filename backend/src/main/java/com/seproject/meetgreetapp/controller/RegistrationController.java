package com.seproject.meetgreetapp.controller;


import com.seproject.meetgreetapp.dto.request.StudentRequestDTO;
import com.seproject.meetgreetapp.dto.response.StudentResponseDTO;
import com.seproject.meetgreetapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public StudentResponseDTO registerStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return registrationService.saveStudentDetails(studentRequestDTO);
    }
}
