package com.example.reachme2;

import java.io.Serializable;

public class workExperience implements Serializable {
    private int id;
    private String jobTitle;
    private String companyName;
    private String specialization;
    private String companyIndustry;
    private String startDate;
    private String endDate;
    private int iCurrentlyWorkHere;
    private String jobDescription;
    private String positionLevel;
    private String email;

    public workExperience(int id, String jobTitle, String companyName, String specialization, String companyIndustry,String positionLevel,  String startDate, String endDate, int iCurrentlyWorkHere, String jobDescription) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.specialization = specialization;
        this.companyIndustry = companyIndustry;
        this.startDate = startDate;
        this.endDate = endDate;
        this.iCurrentlyWorkHere = iCurrentlyWorkHere;
        this.jobDescription = jobDescription;
        this.positionLevel = positionLevel;

    }




    public workExperience(String jobTitle, String companyName, String specialization, String companyIndustry, String positionLevel, String startDate, String endDate, int iCurrentlyWorkHere, String jobDescription) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.specialization = specialization;
        this.companyIndustry = companyIndustry;
        this.startDate = startDate;
        this.endDate = endDate;
        this.iCurrentlyWorkHere = iCurrentlyWorkHere;
        this.jobDescription = jobDescription;
        this.positionLevel = positionLevel;

    }


    public workExperience() {

    }
    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getICurrentlyWorkHere() {
        return iCurrentlyWorkHere;
    }

    public void setiCurrentlyWorkHere(int iCurrentlyWorkHere) {
        this.iCurrentlyWorkHere = iCurrentlyWorkHere;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
