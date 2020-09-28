package com.seproject.meetgreetapp.controller;


import com.seproject.meetgreetapp.dto.LoginDTO;
import com.seproject.meetgreetapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/login")
    public LoginDTO login(@RequestBody LoginDTO loginDTO){
        return registrationService.getLoginDetails(loginDTO);
    }

}
