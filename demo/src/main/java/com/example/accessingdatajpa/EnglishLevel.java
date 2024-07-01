package com.example.accessingdatajpa;

public enum EnglishLevel {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    FLUENT("Fluent");

    private String desc;

    private EnglishLevel(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
