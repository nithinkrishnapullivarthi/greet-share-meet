package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.dto.request.InterestRequestDTO;
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

        List<InterestRequestDTO> interestsDTO = studentRequestDTO.getInterests();
        List<StudentInterest> studentInterests = new ArrayList<StudentInterest>();

        for(InterestRequestDTO interestRequestDTO : interestsDTO ){
            StudentInterest studentInterest = new StudentInterest();
            studentInterest.setStudent_id(sId);
            studentInterest.setInterest_id(interestRepository.findByInterest(interestRequestDTO.getInterest()).getId());
            studentInterests.add(studentInterest);
        }

        studentInterestRepository.saveAll(studentInterests);

        return mapper.map(student, StudentResponseDTO.class);
    }
}
