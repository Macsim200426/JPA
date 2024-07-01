package com.example.accessingdatajpa;

import java.time.LocalDate;
import java.util.List;

public class Teacher {
    private String name;
    private String surname;

    private Gender gender;
    private LocalDate birthDay;
    private String greetings;
    private List<String> subjects;

    public Teacher(String name, String surname, Gender gender, LocalDate birthDay, String greetings, List<String> subjects) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDay = birthDay;
        this.greetings = greetings;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
