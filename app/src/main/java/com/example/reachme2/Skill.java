package com.example.reachme2;

public class Skill {
    private String skillName;
    private String proficiency;

    public Skill(String skill,String proficiency) {
        this.skillName = skill;
        this.proficiency = proficiency;
    }

    public String getSkillName() {
        return skillName;
    }

    public void getSkillName(String skill) {
        this.skillName = skill;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
