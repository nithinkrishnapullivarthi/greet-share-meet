package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.Announcement;
import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.model.StudentVolunteerInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    public List<Announcement> findAllByStudentId(Integer studentId);
    public List<Announcement> findAllByInterestIdIn(List<Integer> interestId);
}
