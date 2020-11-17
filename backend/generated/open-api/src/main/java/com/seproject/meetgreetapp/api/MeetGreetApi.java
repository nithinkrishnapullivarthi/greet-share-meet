/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-14T13:58:03.650-06:00[America/Chicago]")

@Validated
@Api(value = "meet-greet", description = "the meet-greet API")
public interface MeetGreetApi {

    default MeetGreetApiDelegate getDelegate() {
        return new MeetGreetApiDelegate() {};
    }

    @ApiOperation(value = "To pair students", nickname = "createMatchmaking", notes = "To pair students", response = PairUpResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = PairUpResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/pairup",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<PairUpResponseDTO> createMatchmaking(@ApiParam(value = "match making" ,required=true )  @Valid @RequestBody PairUpRequestDTO pairUpRequestDTO) {
        return getDelegate().createMatchmaking(pairUpRequestDTO);
    }


    @ApiOperation(value = "To retrieve all annoucements", nickname = "getAllAnnouncements", notes = "To get List of announcements", response = AnnouncementResponseDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = AnnouncementResponseDTO.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/announcement",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<AnnouncementResponseDTO>> getAllAnnouncements(@ApiParam(value = "") @Valid @RequestParam(value = "studentId", required = false) Integer studentId) {
        return getDelegate().getAllAnnouncements(studentId);
    }


    @ApiOperation(value = "Retrieves all students with matching interest of particular student", nickname = "getAllStudents", notes = "To fetch all students with matching interest", response = StudentResponseDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentResponseDTO.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<StudentResponseDTO>> getAllStudents(@ApiParam(value = "") @Valid @RequestParam(value = "studentId", required = false) Integer studentId) {
        return getDelegate().getAllStudents(studentId);
    }


    @ApiOperation(value = "To get all registered time slots", nickname = "getMatches", notes = "To get all registered time slots", response = PairUpMatchesResponseDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = PairUpMatchesResponseDTO.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/pairup",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<PairUpMatchesResponseDTO>> getMatches(@ApiParam(value = "") @Valid @RequestParam(value = "studentId", required = false) Integer studentId) {
        return getDelegate().getMatches(studentId);
    }


    @ApiOperation(value = "Retrieves particular student information", nickname = "getStudent", notes = "To get articular student details", response = StudentDetailResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentDetailResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/{studentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<StudentDetailResponseDTO> getStudent(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId) {
        return getDelegate().getStudent(studentId);
    }


    @ApiOperation(value = "Retrieves particular student interests", nickname = "getStudentInterests", notes = "To get articular student interests", response = InterestsResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = InterestsResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/interests/{studentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<InterestsResponseDTO> getStudentInterests(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId) {
        return getDelegate().getStudentInterests(studentId);
    }


    @ApiOperation(value = "Retrieves particular student personal details only (interests are not retreived)", nickname = "getStudentPersonalDetails", notes = "To get particular student personal details", response = StudentPersonalDetailResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentPersonalDetailResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/personal-details/{studentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<StudentPersonalDetailResponseDTO> getStudentPersonalDetails(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId) {
        return getDelegate().getStudentPersonalDetails(studentId);
    }


    @ApiOperation(value = "To make announcements", nickname = "makeAnnouncement", notes = "To make announcements", response = AnnouncementResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = AnnouncementResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/announcement",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<AnnouncementResponseDTO> makeAnnouncement(@ApiParam(value = "To make announcements" ,required=true )  @Valid @RequestBody AnnouncementRequestDTO announcementRequestDTO) {
        return getDelegate().makeAnnouncement(announcementRequestDTO);
    }


    @ApiOperation(value = "To register student Information", nickname = "registerUser", notes = "To register student Information", response = StudentResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/registration",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<StudentResponseDTO> registerUser(@ApiParam(value = "Register student information" ,required=true )  @Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return getDelegate().registerUser(studentRequestDTO);
    }


    @ApiOperation(value = "", nickname = "updateStudentDetails", notes = "To update particular student personal details", response = StudentPersonalDetailResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentPersonalDetailResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/personal-details/{studentId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<StudentPersonalDetailResponseDTO> updateStudentDetails(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId,@ApiParam(value = "Update student information" ,required=true )  @Valid @RequestBody StudentPersonalDetailRequestDTO studentPersonalDetailRequestDTO) {
        return getDelegate().updateStudentDetails(studentId, studentPersonalDetailRequestDTO);
    }


    @ApiOperation(value = "", nickname = "updateStudentInterests", notes = "To update particular student interests", response = InterestsResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = InterestsResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/interests/{studentId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<InterestsResponseDTO> updateStudentInterests(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId,@ApiParam(value = "Update student interests" ,required=true )  @Valid @RequestBody InterestsRequestDTO interestsRequestDTO) {
        return getDelegate().updateStudentInterests(studentId, interestsRequestDTO);
    }


    @ApiOperation(value = "To authenticate the user", nickname = "userLogin", notes = "To particular student details", response = StudentResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/login",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<StudentResponseDTO> userLogin(@ApiParam(value = "To make announcements" ,required=true )  @Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return getDelegate().userLogin(loginRequestDTO);
    }

}
