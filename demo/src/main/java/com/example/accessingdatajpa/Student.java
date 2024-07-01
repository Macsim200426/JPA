package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String country;
    private String greetings;
    private EnglishLevel englishLevel;
    private List<String> languages;

    protected Student() {}

//    public Student(String firstName, String lastName) {
//        this.name = firstName;
//        this.lastName = lastName;
//    }


    public Student(String name, String lastName, Gender gender, LocalDate dateOfBirth, String country, String greetings, EnglishLevel englishLevel, List<String> languages) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.greetings = greetings;
        this.englishLevel = englishLevel;
        this.languages = languages;
    }

    //    @Override
//    public String toString() {
//        return String.format(
//                "Customer[id=%d, name='%s', surname='%s']",
//                id, name, surname);
//    }
@Override
public String toString() {
    return String.format(
            "%s, %s",
            name,dateOfBirth);
}




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public String getGreetings() {
        return greetings;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public List<String> getLanguages() {
        return languages;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
}
