/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.seproject.meetgreetapp.api;

import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.Error;
import com.seproject.meetgreetapp.LoginRequestDTO;
import com.seproject.meetgreetapp.PairUpMatchesResponseDTO;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-03T11:08:38.828-06:00[America/Chicago]")

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


    @ApiOperation(value = "Retrieves particular student information", nickname = "getStudent", notes = "To particular student details", response = StudentResponseDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = StudentResponseDTO.class),
        @ApiResponse(code = 404, message = "Unknown error occured", response = Error.class),
        @ApiResponse(code = 200, message = "Unknown Error") })
    @RequestMapping(value = "/meet-greet/students/{studentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<StudentResponseDTO> getStudent(@ApiParam(value = "",required=true) @PathVariable("studentId") Integer studentId) {
        return getDelegate().getStudent(studentId);
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
