package com.example.reachme2;

import java.io.Serializable;

public class Education implements Serializable {
    private int id;
    private  String educationLevel;
    private String institute;
    private String fieldOfStudies;
    private String location;
    private String yearOfGraduation;
    private String monthOfGraduation;
    private String grade;
    private String additionalInformation;

    public Education(int id, String educationLevel, String institute, String fieldOfStudies, String location, String yearOfGraduation, String monthOfGraduation, String grade, String additionalInformation) {
        this.id = id;
        this.educationLevel = educationLevel;
        this.institute = institute;
        this.fieldOfStudies = fieldOfStudies;
        this.location = location;
        this.yearOfGraduation = yearOfGraduation;

        this.monthOfGraduation = monthOfGraduation;
        this.grade = grade;
        this.additionalInformation = additionalInformation;
    }

    public Education(String educationLevel, String institute, String fieldOfStudies, String location, String yearOfGraduation, String monthOfGraduation, String grade, String additionalInformation) {
        this.educationLevel = educationLevel;
        this.institute = institute;
        this.fieldOfStudies = fieldOfStudies;
        this.location = location;
        this.yearOfGraduation = yearOfGraduation;
        this.monthOfGraduation = monthOfGraduation;
        this.grade = grade;
        this.additionalInformation = additionalInformation;
    }
    public Education( String institute, String yearOfGraduation, String fieldOfStudies) {
        this.id = id;
        this.institute = institute;
        this.yearOfGraduation = yearOfGraduation;
        this.fieldOfStudies = fieldOfStudies;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getFieldOfStudies() {
        return fieldOfStudies;
    }

    public void setFieldOfStudies(String fieldOfStudies) {
        this.fieldOfStudies = fieldOfStudies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(String yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getMonthOfGraduation() {
        return monthOfGraduation;
    }

    public void setMonthOfGraduation(String monthOfGraduation) {
        this.monthOfGraduation = monthOfGraduation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
