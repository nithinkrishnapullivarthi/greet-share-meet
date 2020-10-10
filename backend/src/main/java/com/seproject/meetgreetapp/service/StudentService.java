package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.StudentResponseDTO;
import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import com.seproject.meetgreetapp.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    StudentInterestRepository studentInterestRepository;

    public List<StudentResponseDTO> getStudentDetailsWithMatchingInterests(Integer studentId) {

        List<StudentInterest> studentInterests = studentInterestRepository.findByStudentId(studentId);

        List<StudentInterest> matchingStudents = studentInterestRepository.
                findByInterestIdIn(studentInterests.stream().map(studentInterest -> studentInterest.getInterestId())
                        .collect(Collectors.toList()));

        Map<Integer,List<Integer>> studentToInterestMapping = this.getStudentIdToInterestsMapping(matchingStudents);
        Set<Integer> studentIds = studentToInterestMapping.keySet();
        studentIds.remove(studentId);

        List<Student> students = studentRepository.findAllById(studentIds);

        return mapToResponseDTOList(students,studentToInterestMapping);
    }

    private Map<Integer,List<Integer>> getStudentIdToInterestsMapping(List<StudentInterest> matchingStudents){
        HashMap<Integer,List<Integer>> studentToInterestMapping = new HashMap<>();
        for(StudentInterest student: matchingStudents){
            if(studentToInterestMapping.get(student.getStudentId())==null){
                List<Integer> interestIds = new ArrayList<>();
                interestIds.add(student.getInterestId());
                studentToInterestMapping.put(student.getStudentId(),interestIds);
            }
            else{
                studentToInterestMapping.get(student.getStudentId()).add(student.getInterestId());
            }
        }
        return studentToInterestMapping;
    }

    private List<StudentResponseDTO> mapToResponseDTOList(List<Student> students, Map<Integer, List<Integer>> studentToInterestMapping ){
        List<StudentResponseDTO> responseDTOList = new ArrayList<>();
        List<Interest> interests = interestRepository.findAll();
        for(Student student:students){
            StudentResponseDTO studentResponseDTO = mapper.map(student, StudentResponseDTO.class);
            List<Integer> sInterests = studentToInterestMapping.get(studentResponseDTO.getId());
            List<String> interestList = new ArrayList<>();
            for(Integer interestID: sInterests){
                for(Interest interest: interests){
                    if(interest.getId() == interestID)
                        interestList.add(interest.getInterest());
                }
            }
            studentResponseDTO.setInterests(interestList);
            responseDTOList.add(studentResponseDTO);
        }
        return responseDTOList;
    }
}
