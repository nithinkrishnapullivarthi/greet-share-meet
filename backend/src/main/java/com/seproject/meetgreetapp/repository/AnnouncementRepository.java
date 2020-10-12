package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
