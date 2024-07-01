package com.example.accessingdatajpa;

public class StudentComparator implements java.util.Comparator<Student> {
    public int compare(Student a, Student b) {

        return a.getName().compareTo(b.getName());
    }
}
