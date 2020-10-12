package com.seproject.meetgreetapp.service;

import com.seproject.meetgreetapp.AnnouncementRequestDTO;
import com.seproject.meetgreetapp.AnnouncementResponseDTO;
import com.seproject.meetgreetapp.model.Announcement;
import com.seproject.meetgreetapp.repository.AnnouncementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    ModelMapper mapper;

    public AnnouncementResponseDTO createAnnouncement(AnnouncementRequestDTO announcementRequest) {
        Announcement mappedAnnouncement = mapper.map(announcementRequest, Announcement.class);
        Announcement announcement = announcementRepository.save(mappedAnnouncement);
        AnnouncementResponseDTO response = mapper.map(announcement, AnnouncementResponseDTO.class);
        return response;
    }
}