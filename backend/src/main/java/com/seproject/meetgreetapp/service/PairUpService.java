package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.PairUpMatchesResponseDTO;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
import com.seproject.meetgreetapp.model.*;
import com.seproject.meetgreetapp.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
public class PairUpService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    PairUpRepository pairUpRepository;

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentInterestRepository studentInterestRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    Date getParsedDate(String dateAndTime) throws  ParseException
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateAndTime);
    }

    public PairUpResponseDTO requestAMatch(PairUpRequestDTO pairUpRequestDTO) {
        String startTime = pairUpRequestDTO.getStartDateTime();
        String endTime = pairUpRequestDTO.getEndDateTime();
        try{
            Date startDateTIme =  getParsedDate(startTime);
            Date endDateTime = getParsedDate(endTime);
            //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            startTime = sdf.format(startDateTIme);
            endTime = sdf.format(endDateTime);
        }
        catch(ParseException e){
            System.out.println("Parse exception");
        }
        pairUpRequestDTO.setStartDateTime(startTime);
        pairUpRequestDTO.setEndDateTime(endTime);
        PairUp mappedPairUp = mapper.map(pairUpRequestDTO, PairUp.class);
        mappedPairUp.setId(null);
        PairUp pairUp = pairUpRepository.save(mappedPairUp);
        PairUpResponseDTO response = mapper.map(pairUp, PairUpResponseDTO.class);
        return response;
    }

    public List<PairUpMatchesResponseDTO> getAllMatchingPairups(Integer studentId)
    {
        List<StudentInterest> listOfStudentsInterests = studentInterestRepository.findByStudentId(studentId);
        List<Integer> interestIds = listOfStudentsInterests.stream().map(x-> x.getInterestId()).collect(Collectors.toList());
        List<Interest> interestDetails = interestRepository.findAllById(interestIds);

        List<PairUp>  allPairUpRecords = pairUpRepository.findAll();
        List<PairUp>  loggedInStudentPairUps = allPairUpRecords.stream().filter(x -> x.getStudentId().equals(studentId)).collect(Collectors.toList());
        List<String> studentInterests = interestDetails.stream().map(x -> x.getInterest()).collect(Collectors.toList());
        allPairUpRecords = allPairUpRecords.stream().filter(x -> studentInterests.contains(x.getInterest())).collect(Collectors.toList());

        allPairUpRecords = allPairUpRecords.stream().filter(x -> filterPairUpRecords(loggedInStudentPairUps, x, studentId)).collect(Collectors.toList());
        List<PairUpMatchesResponseDTO> matchedStudents = new ArrayList<PairUpMatchesResponseDTO>();
        matchedStudents.addAll(allPairUpRecords.stream().map(x -> mapStudentDetailsMatchedPairUpRecord(x)).collect(Collectors.toList()));

        return matchedStudents;
    }
    private boolean filterPairUpRecords(List<PairUp>  loggedInStudentPairUps, PairUp currentPairUp, Integer studentId) {
        if(currentPairUp.getStudentId().equals(studentId)) return false;

        PairUp loggedInUserInterest = getLoggedInUserWithMatchingInterest(loggedInStudentPairUps, currentPairUp.getInterest());
        if (loggedInUserInterest == null) return  false;
        try
        {
            Date startDate1 = getParsedDate(loggedInUserInterest.getStartDateTime());
            Date endDate1 = getParsedDate(loggedInUserInterest.getEndDateTime());
            Date startDate2 = getParsedDate(currentPairUp.getStartDateTime());
            Date endDate2 = getParsedDate(currentPairUp.getEndDateTime());
            return isOverlapping(startDate1, endDate1, startDate2, endDate2);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public  boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }
    private PairUp getLoggedInUserWithMatchingInterest(List<PairUp>  loggedInStudentPairUps, String interest){
        List<PairUp> listOfPairUp = loggedInStudentPairUps.stream().filter(x -> x.getInterest().equals(interest)).collect(Collectors.toList());
        if(listOfPairUp.size() >0)
            return listOfPairUp.get(0);

        return null;
    }
    private PairUpMatchesResponseDTO mapStudentDetailsMatchedPairUpRecord(PairUp pairUp){

        Optional<Student> student = studentRepository.findById(pairUp.getStudentId());
        PairUpMatchesResponseDTO pairUpMatchesResponseDTO = new PairUpMatchesResponseDTO();
        pairUpMatchesResponseDTO = mapper.map(pairUp, PairUpMatchesResponseDTO.class);
        if(student.isPresent()){
            pairUpMatchesResponseDTO.setContact(student.get().getContact());
            pairUpMatchesResponseDTO.setEmail(student.get().getEmail());
            pairUpMatchesResponseDTO.setName(student.get().getName());
        }
        return pairUpMatchesResponseDTO;
    }
}
