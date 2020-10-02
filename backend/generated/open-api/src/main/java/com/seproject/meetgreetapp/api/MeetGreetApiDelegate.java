package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.Error;
import com.seproject.meetgreetapp.InlineResponse200;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-01T20:18:34.565-05:00[America/Chicago]")

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
                    String exampleString = "{ \"studentId\" : 6, \"interest\" : \"interest\", \"endDate\" : \"endDate\", \"id\" : 0, \"startDate\" : \"startDate\" }";
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
    default ResponseEntity<AnnouncementResponseDTO> getAllAnnouncements(Integer studentId) {
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
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see MeetGreetApi#getRegisteredTimeslots
     */
    default ResponseEntity<List<PairUpResponseDTO>> getRegisteredTimeslots(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"studentId\" : 6, \"interest\" : \"interest\", \"endDate\" : \"endDate\", \"id\" : 0, \"startDate\" : \"startDate\" }";
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
    default ResponseEntity<StudentResponseDTO> getStudent(Integer studentId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\" }";
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
                    String exampleString = "{ \"is_volunteer\" : true, \"contact\" : \"contact\", \"name\" : \"name\", \"id\" : 0, \"department\" : \"department\", \"interests\" : [ \"interests\", \"interests\" ], \"email\" : \"email\" }";
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
    default ResponseEntity<InlineResponse200> userLogin(String username,
        String password) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
