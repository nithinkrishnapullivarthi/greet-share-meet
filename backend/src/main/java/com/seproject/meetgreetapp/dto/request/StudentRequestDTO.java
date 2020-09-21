package com.seproject.meetgreetapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentRequestDTO {

    private Long id;

    private String name;

    private String department;

    private String email;

    private String username;

    private String password;

    @JsonProperty
    private Boolean isVolunteer;

    private String contact;

    private List<InterestRequestDTO> interests;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<InterestRequestDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestRequestDTO> interestRequestDTOS) {
        this.interests = interestRequestDTOS;
    }

    public Boolean getVolunteer() {
        return isVolunteer;
    }

    public void setVolunteer(Boolean volunteer) {
        isVolunteer = volunteer;
    }

}
