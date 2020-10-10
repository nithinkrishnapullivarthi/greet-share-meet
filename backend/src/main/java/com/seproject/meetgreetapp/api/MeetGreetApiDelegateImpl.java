package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.*;
import com.seproject.meetgreetapp.Error;
import com.seproject.meetgreetapp.model.Student;
import com.seproject.meetgreetapp.repository.StudentRepository;
import com.seproject.meetgreetapp.service.RegistrationService;
import com.seproject.meetgreetapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Component
public class MeetGreetApiDelegateImpl implements MeetGreetApiDelegate{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<PairUpResponseDTO> createMatchmaking(PairUpRequestDTO pairUpRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<AnnouncementResponseDTO>> getAllAnnouncements(Integer studentId) {
        return null;
    }

    @Override
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(Integer studentId) {
        List<StudentResponseDTO> studentResponseDTOList = studentService.getStudentDetailsWithMatchingInterests(studentId);
        return new ResponseEntity(studentResponseDTOList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PairUpMatchesResponseDTO>> getMatches(Integer studentId) {
        return null;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> getStudent(Integer studentId) {
        return new ResponseEntity(studentService.getStudentDetails(studentId), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<AnnouncementResponseDTO> makeAnnouncement(AnnouncementRequestDTO announcementRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> registerUser(StudentRequestDTO studentRequestDTO) {

        if(studentRepository.findByUsername(studentRequestDTO.getUsername()) != null){
            Error error = new Error();
            error.setMessage("USERNAME_EXISTS");
            return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
        }
        StudentResponseDTO studentResponseDTO = registrationService.saveStudentDetails(studentRequestDTO);
        return new ResponseEntity(studentResponseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<InlineResponse200> userLogin(LoginRequestDTO loginRequestDTO) {
        if(studentRepository.findByUsername(loginRequestDTO.getUsername()) == null){
            Error error = new Error();
            error.setMessage("USER_NOT_FOUND");
            return new ResponseEntity(error,HttpStatus.NOT_FOUND);
        }

        Student student = studentRepository.findByUsernameAndPassword(loginRequestDTO.getUsername(),loginRequestDTO.getPassword());
        if(student == null){
            Error error = new Error();
            error.setMessage("INVALID_CREDENTIALS");
            return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(student.getId(), HttpStatus.OK);
    }
}
