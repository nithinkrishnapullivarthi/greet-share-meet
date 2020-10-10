package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.StudentResponseDTO;
import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import com.seproject.meetgreetapp.repository.StudentRepository;
import com.seproject.meetgreetapp.repository.StudentVolunteerInterestRepository;
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

    @Autowired
    StudentVolunteerInterestRepository studentVolunteerInterestRepository;

    public List<StudentResponseDTO> getStudentDetailsWithMatchingInterests(Integer studentId) {

        List<StudentInterest> studentInterests = studentInterestRepository.findByStudentId(studentId);

        List<StudentInterest> matchingStudents = studentInterestRepository.
                findByInterestIdIn(studentInterests.stream().map(studentInterest -> studentInterest.getInterestId())
                        .collect(Collectors.toList()));

        Map<Integer,List<Integer>> studentToInterestMapping = this.getStudentIdToInterestsMapping(matchingStudents);
        Set<Integer> studentIds = studentToInterestMapping.keySet();
        studentIds.remove(studentId);

        List<Student> students = studentRepository.findAllById(studentIds);

        Map<Integer,List<Integer>> studentToVolunteerInterestMapping = getStudentIdToVolunteerInterestsMapping(studentIds);
        return mapToResponseDTOList(students,studentToInterestMapping,studentToVolunteerInterestMapping);
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

    private Map<Integer,List<Integer>> getStudentIdToVolunteerInterestsMapping(Set<Integer> studentIds){
        HashMap<Integer,List<Integer>> studentToVolunteerInterestMapping = new HashMap<>();
        List<StudentVolunteerInterest> studentVolunteerInterests = studentVolunteerInterestRepository.findAllByStudentIdIn(studentIds);

        for(StudentVolunteerInterest studentVolunteerInterest: studentVolunteerInterests){
            if(studentToVolunteerInterestMapping.get(studentVolunteerInterest.getStudentId())==null){
                List<Integer> volunteerInterestIds = new ArrayList<>();
                volunteerInterestIds.add(studentVolunteerInterest.getInterestId());
                studentToVolunteerInterestMapping.put(studentVolunteerInterest.getStudentId(),volunteerInterestIds);
            }
            else{
                studentToVolunteerInterestMapping.get(studentVolunteerInterest.getStudentId()).add(studentVolunteerInterest.getInterestId());
            }
        }
        return studentToVolunteerInterestMapping;
    }

    private List<StudentResponseDTO> mapToResponseDTOList(List<Student> students, Map<Integer, List<Integer>> studentToInterestMapping,Map<Integer, List<Integer>> studentToVolunteerInterestMapping ){
        List<StudentResponseDTO> responseDTOList = new ArrayList<>();
        List<Interest> interests = interestRepository.findAll();
        for(Student student:students){

            StudentResponseDTO studentResponseDTO = mapper.map(student, StudentResponseDTO.class);
            List<Integer> sInterests = studentToInterestMapping.get(studentResponseDTO.getId());
            List<Integer> sVolunteerInterests = studentToVolunteerInterestMapping.get(studentResponseDTO.getId());
            List<String> interestList = new ArrayList<>();
            List<String> volunteerInterestList = new ArrayList<>();

            // Populating student interests
            for(Integer interestID: sInterests){
                for(Interest interest: interests){
                    if(interest.getId() == interestID)
                        interestList.add(interest.getInterest());
                }
            }
            // Populating student volunteer interests
            for(Integer interestID: sVolunteerInterests){
                for(Interest interest: interests){
                    if(interest.getId() == interestID)
                        volunteerInterestList.add(interest.getInterest());
                }
            }
            studentResponseDTO.setInterests(interestList);
            studentResponseDTO.setVolunteerInterest(volunteerInterestList);
            responseDTOList.add(studentResponseDTO);
        }
        return responseDTOList;
    }

}
