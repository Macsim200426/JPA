package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Student, Long> {

  //  List<Student> findByLastName(EnglishLevel englishLevel);


    Student findById(long id);


    List<Student> findAll(Sort dateOfBirth);


}