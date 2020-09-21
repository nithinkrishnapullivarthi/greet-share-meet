package com.seproject.meetgreetapp.model;

import javax.persistence.*;

@Entity
@Table(name="interests")
public class Interest {

    @Id
    private int id;

    @Column(name="interest")
    private String interest;

    @Column(name="category")
    private String category;

    private Interest(){}

    public int getId() {
        return id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
