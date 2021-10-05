package com.example.demo1.model;

import java.util.List;

public class Course {
    private String name;
    private double average;
    private List<Assignment> assignment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        double totalGrade = 0.0;
        for (int i = 0; i < assignment.size(); i++) {
            totalGrade += assignment.get(i).getGrade();
        }
        average = (double) Math.round((totalGrade/assignment.size()) * 10) / 10;
        //(double) Math.round((num / sum * 100) * 10) / 10;
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<Assignment> getAssignment() {
        return assignment;
    }

    public void setAssignment(List<Assignment> assignment) {
        this.assignment = assignment;
    }
}
