package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.*;
import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.Error;
import com.seproject.meetgreetapp.LoginRequestDTO;
import com.seproject.meetgreetapp.PairUpMatchesResponseDTO;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
import com.seproject.meetgreetapp.StudentRequestDTO;
import com.seproject.meetgreetapp.StudentResponseDTO;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.repository.StudentRepository;
import com.seproject.meetgreetapp.service.AnnouncementService;
import com.seproject.meetgreetapp.service.PairUpService;
import com.seproject.meetgreetapp.service.RegistrationService;
import com.seproject.meetgreetapp.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Component
public class MeetGreetApiDelegateImpl implements MeetGreetApiDelegate {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    ModelMapper mapper;

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    PairUpService pairUpService;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<PairUpResponseDTO> createMatchmaking(PairUpRequestDTO pairUpRequestDTO) {
        return new ResponseEntity(pairUpService.requestAMatch(pairUpRequestDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AnnouncementResponseDTO>> getAllAnnouncements(Integer studentId) {
        return new ResponseEntity(announcementService.getAllAnnouncementForStudent(studentId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(Integer studentId) {
        List<StudentResponseDTO> studentResponseDTOList = studentService.getStudentDetailsWithMatchingInterests(studentId);
        return new ResponseEntity(studentResponseDTOList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PairUpMatchesResponseDTO>> getMatches(Integer studentId) {
        return new ResponseEntity(pairUpService.getAllMatchingPairups(studentId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentDetailResponseDTO> getStudent(Integer studentId) {
        return new ResponseEntity(studentService.getStudentDetails(studentId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentPersonalDetailResponseDTO> updateStudentDetails(Integer studentId,StudentPersonalDetailRequestDTO studentRequestDTO) {
        return new ResponseEntity(studentService.updateStudentDetails(studentId,studentRequestDTO),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentPersonalDetailResponseDTO> getStudentPersonalDetails(Integer studentId) {
        return new ResponseEntity(studentService.getStudentPersonalDetails(studentId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterestsResponseDTO> getStudentInterests(Integer studentId) {
        return new ResponseEntity(studentService.getStudentInterests(studentId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterestsResponseDTO> updateStudentInterests(Integer studentId,InterestsRequestDTO interestsRequestDTO) {
        return new ResponseEntity(studentService.updateStudentInterests(studentId,interestsRequestDTO),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AnnouncementResponseDTO> makeAnnouncement(AnnouncementRequestDTO announcementRequestDTO) {
        return new ResponseEntity(announcementService.createAnnouncement(announcementRequestDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudentResponseDTO> registerUser(StudentRequestDTO studentRequestDTO) {
        if(studentRepository.findByUsername(studentRequestDTO.getUsername()) != null){
            Error error = new Error();
            error.setMessage("USERNAME_EXISTS");
            return new ResponseEntity(error,HttpStatus.OK);
        }
        StudentResponseDTO studentResponseDTO = registrationService.saveStudentDetails(studentRequestDTO);
        return new ResponseEntity(studentResponseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudentResponseDTO> userLogin(LoginRequestDTO loginRequestDTO) {
        if(studentRepository.findByUsername(loginRequestDTO.getUsername()) == null){
            Error error = new Error();
            error.setMessage("USER_NOT_FOUND");
            return new ResponseEntity(error,HttpStatus.OK);
        }
        Student student = studentRepository.findByUsernameAndPassword(loginRequestDTO.getUsername(),loginRequestDTO.getPassword());
        if(student == null){
            Error error = new Error();
            error.setMessage("INVALID_CREDENTIALS");
            return new ResponseEntity(error,HttpStatus.OK);
        }
        StudentResponseDTO studentResponseDTO =  mapper.map(student, StudentResponseDTO.class);
        return new ResponseEntity(studentResponseDTO, HttpStatus.OK);
    }
}
