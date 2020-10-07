package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Component
public class MeetGreetApiDelegateImpl implements MeetGreetApiDelegate{
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
        return null;
    }

    @Override
    public ResponseEntity<List<PairUpResponseDTO>> getRegisteredTimeslots(Integer studentId) {
        return null;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> getStudent(Integer studentId) {
        return null;
    }

    @Override
    public ResponseEntity<AnnouncementResponseDTO> makeAnnouncement(AnnouncementRequestDTO announcementRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> registerUser(StudentRequestDTO studentRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> userLogin(String username, String password) {
        return null;
    }
}
