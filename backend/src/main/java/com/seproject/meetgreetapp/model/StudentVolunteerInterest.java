package com.seproject.meetgreetapp.model;

import javax.persistence.*;

@Entity
@Table(name="student_volunteer_interests")
public class StudentVolunteerInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_id", nullable = false)
    private Integer studentId;

    @Column(name="volunteer_interest_id", nullable = false)
    private Integer volunteerInterestId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getInterestId() {
        return volunteerInterestId;
    }

    public void setInterestId(Integer interestId) {
        this.volunteerInterestId = interestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
