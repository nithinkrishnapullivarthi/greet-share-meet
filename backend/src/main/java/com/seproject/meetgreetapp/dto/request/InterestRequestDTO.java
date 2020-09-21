package com.seproject.meetgreetapp.dto.request;

public class InterestRequestDTO {

    private String interest;

    public InterestRequestDTO(String interest){
        this.interest = interest;
    }

    public String getInterest() {
        return interest;
    }
}
