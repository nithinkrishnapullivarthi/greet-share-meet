package com.seproject.meetgreetapp.model;

import javax.persistence.*;

@Entity
@Table(name="student_interests")
public class StudentInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_id", nullable = false)
    private Long student_id;

    @Column(name="interest_id", nullable = false)
    private Integer interest_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Integer getInterest_id() {
        return interest_id;
    }

    public void setInterest_id(Integer interest_id) {
        this.interest_id = interest_id;
    }

}
