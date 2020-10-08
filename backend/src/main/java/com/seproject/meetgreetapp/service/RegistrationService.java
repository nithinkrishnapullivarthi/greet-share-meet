package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.Interest;
import com.seproject.meetgreetapp.StudentRequestDTO;
import com.seproject.meetgreetapp.StudentResponseDTO;
import com.seproject.meetgreetapp.VolunteerInterest;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import com.seproject.meetgreetapp.repository.StudentRepository;
import com.seproject.meetgreetapp.repository.StudentVolunteerInterestRepository;
import org.modelmapper.Conditions;
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
    StudentVolunteerInterestRepository studentVolunteerInterestRepository;

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    ModelMapper mapper;

    public StudentResponseDTO saveStudentDetails(StudentRequestDTO studentRequestDTO){

        Student mappedStudent = mapper.map(studentRequestDTO,Student.class);
        Student student = studentRepository.save(mappedStudent);

        Integer sId = student.getId();
        List<StudentInterest> studentInterests = new ArrayList<StudentInterest>();
        List<StudentVolunteerInterest> studentVolunteerInterests = new ArrayList<StudentVolunteerInterest>();

        for(Interest interest : studentRequestDTO.getInterests() ){
            StudentInterest studentInterest = new StudentInterest();
            studentInterest.setStudentId(sId);
            studentInterest.setInterestId(interestRepository.findByInterest(interest.getInterest()).getId());
            studentInterests.add(studentInterest);
        }

        for(VolunteerInterest interest : studentRequestDTO.getVolunteerInterest() ){
            StudentVolunteerInterest studentVolunteerInterest = new StudentVolunteerInterest();
            studentVolunteerInterest.setStudentId(sId);
            studentVolunteerInterest.setInterestId(interestRepository.findByInterest(interest.getInterest()).getId());
            studentVolunteerInterests.add(studentVolunteerInterest);
        }

        studentInterestRepository.saveAll(studentInterests);
        studentVolunteerInterestRepository.saveAll(studentVolunteerInterests);
        StudentResponseDTO studentResponseDTO =  mapper.map(studentRequestDTO, StudentResponseDTO.class);
        studentResponseDTO.setId(sId);
        return studentResponseDTO;
    }
}
