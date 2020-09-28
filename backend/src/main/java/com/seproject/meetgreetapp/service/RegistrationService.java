package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.dto.LoginDTO;
import com.seproject.meetgreetapp.dto.request.StudentRequestDTO;
import com.seproject.meetgreetapp.dto.response.StudentResponseDTO;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import com.seproject.meetgreetapp.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentInterestRepository studentInterestRepository;

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    ModelMapper mapper;


    public StudentResponseDTO saveStudentDetails(StudentRequestDTO studentRequestDTO){

        Student mappedStudent = mapper.map(studentRequestDTO,Student.class);
        Student student = studentRepository.save(mappedStudent);

        Long sId = student.getId();

        List<String> interests = studentRequestDTO.getInterests();
        List<StudentInterest> studentInterests = new ArrayList<StudentInterest>();

        for(String interest : interests ){
            StudentInterest studentInterest = new StudentInterest();
            studentInterest.setStudentId(sId);
            studentInterest.setInterestId(interestRepository.findByInterest(interest).getId());
            studentInterests.add(studentInterest);
        }

        studentInterestRepository.saveAll(studentInterests);
        studentRequestDTO.setId(sId);
        StudentResponseDTO studentResponseDTO =  mapper.map(studentRequestDTO, StudentResponseDTO.class);
        return studentResponseDTO;
    }

    public LoginDTO getLoginDetails(LoginDTO loginDTO){
        Student student = studentRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if(student!=null)
            return mapper.map(student,LoginDTO.class);
        else
            return null;
    }
}
