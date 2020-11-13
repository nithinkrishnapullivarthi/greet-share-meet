package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.Error;
import com.seproject.meetgreetapp.InterestsRequestDTO;
import com.seproject.meetgreetapp.InterestsResponseDTO;
import com.seproject.meetgreetapp.LoginRequestDTO;
import com.seproject.meetgreetapp.PairUpMatchesResponseDTO;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
import com.seproject.meetgreetapp.StudentDetailResponseDTO;
import com.seproject.meetgreetapp.StudentPersonalDetailRequestDTO;
import com.seproject.meetgreetapp.StudentPersonalDetailResponseDTO;
import com.seproject.meetgreetapp.StudentRequestDTO;
import com.seproject.meetgreetapp.StudentResponseDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link MeetGreetApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-13T15:25:12.604668-05:00[America/New_York]")

public interface MeetGreetApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see MeetGreetApi#createMatchmaking
     */
    default ResponseEntity<PairUpResponseDTO> createMatchmaking(PairUpRequestDTO pairUpRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"studentId\" : 0, \"startDateTime\" : \"startDateTime\", \"interest\" : \"interest\", \"endDateTime\" : \"endDateTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getAllAnnouncements
     */
    default ResponseEntity<List<AnnouncementResponseDTO>> getAllAnnouncements(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"interest\" : \"interest\", \"id\" : 0, \"announcement\" : \"announcement\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getAllStudents
     */
    default ResponseEntity<List<StudentResponseDTO>> getAllStudents(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\", \"volunteer_interests\" : [ \"volunteer_interests\", \"volunteer_interests\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getMatches
     */
    default ResponseEntity<List<PairUpMatchesResponseDTO>> getMatches(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"interest\" : \"interest\", \"contact\" : \"contact\", \"startDateAndTime\" : \"startDateAndTime\", \"name\" : \"name\", \"endDateAndTime\" : \"endDateAndTime\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getStudent
     */
    default ResponseEntity<StudentDetailResponseDTO> getStudent(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" } ], \"email\" : \"email\", \"volunteer_interests\" : [ { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getStudentInterests
     */
    default ResponseEntity<InterestsResponseDTO> getStudentInterests(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"interests\" : [ { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" } ], \"volunteer_interests\" : [ { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getStudentPersonalDetails
     */
    default ResponseEntity<StudentPersonalDetailResponseDTO> getStudentPersonalDetails(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#makeAnnouncement
     */
    default ResponseEntity<AnnouncementResponseDTO> makeAnnouncement(AnnouncementRequestDTO announcementRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"interest\" : \"interest\", \"id\" : 0, \"announcement\" : \"announcement\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#registerUser
     */
    default ResponseEntity<StudentResponseDTO> registerUser(StudentRequestDTO studentRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\", \"volunteer_interests\" : [ \"volunteer_interests\", \"volunteer_interests\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#updateStudentDetails
     */
    default ResponseEntity<StudentPersonalDetailResponseDTO> updateStudentDetails(Integer studentId,
        StudentPersonalDetailRequestDTO studentPersonalDetailRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#updateStudentInterests
     */
    default ResponseEntity<InterestsResponseDTO> updateStudentInterests(Integer studentId,
        InterestsRequestDTO interestsRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"interests\" : [ { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 6, \"category\" : \"category\" } ], \"volunteer_interests\" : [ { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" }, { \"interest\" : \"interest\", \"id\" : 1, \"category\" : \"category\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#userLogin
     */
    default ResponseEntity<StudentResponseDTO> userLogin(LoginRequestDTO loginRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\", \"volunteer_interests\" : [ \"volunteer_interests\", \"volunteer_interests\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
