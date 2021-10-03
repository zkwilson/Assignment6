package com.example.demo1.model;

import java.util.List;
public class Student {
    private String lastName;
    private String firstName;
    private List<Course> course;

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course){
        this.course = course;
    }

}

