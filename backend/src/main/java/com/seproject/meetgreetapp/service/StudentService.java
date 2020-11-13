package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.*;
import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import com.seproject.meetgreetapp.repository.StudentRepository;
import com.seproject.meetgreetapp.repository.StudentVolunteerInterestRepository;
import io.swagger.models.auth.In;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            if(student.getIsVolunteer()){
                for(Integer interestID: sVolunteerInterests){
                    for(Interest interest: interests){
                        if(interest.getId() == interestID)
                            volunteerInterestList.add(interest.getInterest());
                    }
                }
                studentResponseDTO.setVolunteerInterests(volunteerInterestList);
            }
            studentResponseDTO.setInterests(interestList);
            responseDTOList.add(studentResponseDTO);
        }
        return responseDTOList;
    }

    public StudentDetailResponseDTO getStudentDetails(Integer studentId){

        List<StudentInterest> studentInterests = studentInterestRepository.findByStudentId(studentId);
        List<StudentVolunteerInterest> studentVolunteerInterests = studentVolunteerInterestRepository.findByStudentId(studentId);
        Optional<Student> studentDetails = studentRepository.findById(studentId);
        StudentDetailResponseDTO studentDetailResponseDTO = null;
        List<Interest> interests = interestRepository.findAll();


        List<com.seproject.meetgreetapp.Interest> studentInterestList = new ArrayList<>();

        //Populate the student interests
        for(StudentInterest studentInterest: studentInterests){
            for(Interest interest: interests){
                if(interest.getId() == studentInterest.getInterestId()){
                    studentInterestList.add(mapper.map(interest, com.seproject.meetgreetapp.Interest.class));
                }
            }
        }

        List<VolunteerInterest> studentVolunteerInterestList = new ArrayList<>();
        //Populate the student volunteer interests
        for(StudentVolunteerInterest studentVolunteerInterest: studentVolunteerInterests){
            for(Interest interest: interests){
                if(interest.getId() == studentVolunteerInterest.getInterestId()){
                    studentVolunteerInterestList.add(mapper.map(interest, VolunteerInterest.class));
                }
            }
        }

        if(studentDetails.isPresent()){
            studentDetailResponseDTO = mapper.map(studentDetails.get(), StudentDetailResponseDTO.class);
        }
        studentDetailResponseDTO.setInterests(studentInterestList);
        if(studentDetailResponseDTO.getIsVolunteer()){
            studentDetailResponseDTO.setVolunteerInterests(studentVolunteerInterestList);
        }
        return studentDetailResponseDTO;
    }

    public InterestsResponseDTO getStudentInterests(Integer studentId){
        Optional<Student> studentDetails = studentRepository.findById(studentId);
        List<StudentInterest> studentInterests = studentInterestRepository.findByStudentId(studentId);
        List<StudentVolunteerInterest> studentVolunteerInterests = studentVolunteerInterestRepository.findByStudentId(studentId);
        List<Interest> interests = interestRepository.findAll();



        List<com.seproject.meetgreetapp.Interest> studentInterestList = new ArrayList<>();

        //Populate the student interests
        for(StudentInterest studentInterest: studentInterests){
            for(Interest interest: interests){
                if(interest.getId() == studentInterest.getInterestId()){
                    studentInterestList.add(mapper.map(interest, com.seproject.meetgreetapp.Interest.class));
                }
            }
        }

        List<VolunteerInterest> studentVolunteerInterestList = new ArrayList<>();
        //Populate the student volunteer interests
        for(StudentVolunteerInterest studentVolunteerInterest: studentVolunteerInterests){
            for(Interest interest: interests){
                if(interest.getId() == studentVolunteerInterest.getInterestId()){
                    studentVolunteerInterestList.add(mapper.map(interest, VolunteerInterest.class));
                }
            }
        }

        InterestsResponseDTO interestsResponseDTO = new InterestsResponseDTO();

        if(studentDetails.isPresent()){
            interestsResponseDTO.setIsVolunteer(studentDetails.get().getIsVolunteer());
        }
        interestsResponseDTO.setInterests(studentInterestList);
        if(interestsResponseDTO.getIsVolunteer()){
            interestsResponseDTO.setVolunteerInterests(studentVolunteerInterestList);
        }
        return interestsResponseDTO;
    }

    public StudentResponseDTO updateStudentDetails(Integer studentId, StudentRequestDTO studentRequestDTO){
        Optional<Student> studentEntity = studentRepository.findById(studentId);
        Student student = null;
        if(studentEntity.isPresent()){
            student = studentEntity.get();
            student.setContact(studentRequestDTO.getContact());
            student.setDepartment(studentRequestDTO.getDepartment());
            student.setEmail(studentRequestDTO.getEmail());
            student.setName(studentRequestDTO.getName());
            studentRepository.save(student);
        }
        return mapper.map(student,StudentResponseDTO.class);
    }

    @Transactional
    public StudentResponseDTO updateStudentInterests(Integer studentId, StudentRequestDTO studentRequestDTO){
        studentInterestRepository.deleteByStudentId(studentId);
        studentVolunteerInterestRepository.deleteByStudentId(studentId);

        List<String> interests = studentRequestDTO.getInterests();
        List<StudentInterest> studentInterests = new ArrayList<>();

        for(String interest: interests){
            StudentInterest studentInterest = new StudentInterest();
            studentInterest.setStudentId(studentId);
            studentInterest.setInterestId(interestRepository.findByInterest(interest).getId());
            studentInterests.add(studentInterest);
        }
        studentInterestRepository.saveAll(studentInterests);
        
        if(studentRequestDTO.getIsVolunteer()){
            updateStudentVolunteerInterests(studentId, studentRequestDTO);
        }
        StudentResponseDTO studentResponseDTO =  mapper.map(studentRequestDTO, StudentResponseDTO.class);
        return studentResponseDTO;
    }

    private void updateStudentVolunteerInterests(Integer studentId, StudentRequestDTO studentRequestDTO) {
        List<String> volunteerInterests = studentRequestDTO.getVolunteerInterests();
        List<StudentVolunteerInterest> studentVolunteerInterests = new ArrayList<>();
        for(String interest: volunteerInterests){
            StudentVolunteerInterest studentVolunteerInterest = new StudentVolunteerInterest();
            studentVolunteerInterest.setStudentId(studentId);
            studentVolunteerInterest.setInterestId(interestRepository.findByInterest(interest).getId());
            studentVolunteerInterests.add(studentVolunteerInterest);
        }
        studentVolunteerInterestRepository.saveAll(studentVolunteerInterests);
    }
}
