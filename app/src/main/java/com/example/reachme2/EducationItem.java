package com.example.reachme2;

public class EducationItem {
    private String institute;
    private int yearOfGraduation;
    private String fieldOfStudies;

    public EducationItem(String institute,int yearOfGraduation,String fieldOfStudies){
        this.institute = institute;
        this.yearOfGraduation = yearOfGraduation;
        this.fieldOfStudies = fieldOfStudies;
    }

    public String getInstitute() {
        return institute;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public String getFieldOfStudies() {
        return fieldOfStudies;
    }
}
