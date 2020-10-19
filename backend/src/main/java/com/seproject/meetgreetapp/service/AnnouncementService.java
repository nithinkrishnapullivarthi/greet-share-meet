package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.model.Announcement;
import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.model.StudentInterest;
import com.seproject.meetgreetapp.repository.AnnouncementRepository;
import com.seproject.meetgreetapp.repository.InterestRepository;
import com.seproject.meetgreetapp.repository.StudentInterestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    StudentInterestRepository studentInterestRepository;

    @Autowired
    ModelMapper mapper;

    public AnnouncementResponseDTO createAnnouncement(AnnouncementRequestDTO announcementRequest) {
        Interest interest = interestRepository.findByInterest(announcementRequest.getInterest());
        announcementRequest.setInterestId(interest.getId());
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Announcement mappedAnnouncement = mapper.map(announcementRequest, Announcement.class);
        Announcement announcement = announcementRepository.save(mappedAnnouncement);
        AnnouncementResponseDTO response = mapper.map(announcement, AnnouncementResponseDTO.class);
        return response;
    }

    public List<AnnouncementResponseDTO> getAllAnnouncementForStudent(Integer studentId)
    {
        List<StudentInterest> listOfInterests = studentInterestRepository.findByStudentId(studentId);
        List<Integer> matchingInterestIds = listOfInterests.stream().map(x -> x.getInterestId()).distinct().collect(Collectors.toList());
        List<Announcement> announcements = announcementRepository.findAllByInterestIdIn(matchingInterestIds);
        List<AnnouncementResponseDTO> listOfMatchingAnnouncements = new ArrayList<>();
        announcements.forEach(x -> listOfMatchingAnnouncements.add(mapper.map(x, AnnouncementResponseDTO.class)));

        return listOfMatchingAnnouncements;
    }
}