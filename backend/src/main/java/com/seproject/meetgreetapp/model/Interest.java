package com.seproject.meetgreetapp.model;

import javax.persistence.*;

@Entity
@Table(name="interests")
public class Interest {

    @Id
    private int id;

    @Column(name="interest")
    private String interest;

    private Interest(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
