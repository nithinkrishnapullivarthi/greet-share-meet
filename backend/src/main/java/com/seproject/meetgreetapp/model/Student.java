package com.seproject.meetgreetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

    @Id
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="contact")
    private String contact;

    @Column(name="department")
    private String department;

    @Column(name="email")
    private String email;

    @Column(name="is_volunteer")
    private String isVolunteer;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(String isVolunteer) {
        this.isVolunteer = isVolunteer;
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
}
