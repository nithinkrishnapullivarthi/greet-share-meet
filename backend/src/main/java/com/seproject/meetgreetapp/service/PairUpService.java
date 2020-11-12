package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.PairUpRequestDTO;
import com.seproject.meetgreetapp.PairUpResponseDTO;
import com.seproject.meetgreetapp.model.Announcement;
import com.seproject.meetgreetapp.model.PairUp;
import com.seproject.meetgreetapp.repository.PairUpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Service
public class PairUpService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    PairUpRepository pairUpRepository;

    public PairUpResponseDTO requestAMatch(PairUpRequestDTO pairUpRequestDTO) {
    String startTime = pairUpRequestDTO.getStartDateTime();
    String endTime = pairUpRequestDTO.getEndDateTime();
    try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDateTIme =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(startTime);
        Date endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(endTime);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        startTime = sdf.format(startDateTIme);
        endTime = sdf.format(endDateTime);
    }
    catch(ParseException e){
        System.out.println("Parse exception");
    }
    pairUpRequestDTO.setStartDateTime(startTime);
    pairUpRequestDTO.setEndDateTime(endTime);
    PairUp mappedPairUp = mapper.map(pairUpRequestDTO, PairUp.class);
    PairUp pairUp = pairUpRepository.save(mappedPairUp);
    PairUpResponseDTO response = mapper.map(pairUp, PairUpResponseDTO.class);
    return response;
    }
}
