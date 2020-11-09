package com.seproject.meetgreetapp.repository;

import com.seproject.meetgreetapp.model.Announcement;
import com.seproject.meetgreetapp.model.PairUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairUpRepository extends JpaRepository<PairUp, Integer> {

}
