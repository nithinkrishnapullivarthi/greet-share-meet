package com.seproject.meetgreetapp.controller;

import com.seproject.meetgreetapp.model.Interest;
import com.seproject.meetgreetapp.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InterestsController {

    @Autowired
    InterestRepository repository;

    @GetMapping("/interests")
    public ResponseEntity<List<Interest>> getInterests(){
        List<Interest> interests = repository.findAll();
        return ResponseEntity.ok(interests);
    }

}
