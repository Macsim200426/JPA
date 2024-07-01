package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.*;

import static com.example.accessingdatajpa.EnglishLevel.*;
import static com.example.accessingdatajpa.EnglishLevel.ADVANCED;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }
    private List<Country> countries;
    private List<Student> students;
    private Teacher teachers;

    public AccessingDataJpaApplication() {
        countries = new ArrayList<Country>();
        students = new ArrayList<Student>();
    }
    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            countries.add(new Country(1,"France"));
            countries.add(new Country(2, "China"));
            countries.add(new Country(3, "Japan"));
            countries.add(new Country(4, "Spain"));
            countries.add(new Country(5, "Africa"));
            countries.add(new Country(6, "Germany"));
            countries.add(new Country(7, "Austria"));
            countries.add(new Country(8, "Australia"));

            teachers = new Teacher("Ольга","Лужникова",Gender.FEMALE,
                    LocalDate.of(1980,5,10),"Здравствуйте студенты!",
                    List.of("Математика","Физика","Английский"));

            repository.save(new Student("Virginia","Hill",Gender.FEMALE,
                    LocalDate.of(2006, 8, 5), countries.get(0).getName(), "Hello",
                    INTERMEDIATE, List.of("English", "Franc")));

            repository.save(new Student("Jiang", "Chen",Gender.MALE,
                    LocalDate.of(2007, 7, 4), countries.get(1).getName(), "您好",
                    INTERMEDIATE, List.of("English", "China")));

            repository.save(new Student("Aramaki", "Mitsuyuki",Gender.MALE,
                    LocalDate.of(2006, 1, 8), countries.get(2).getName(), "konichiwa",
                    INTERMEDIATE, List.of("English", "Japan")));

            repository.save(new Student("Chloe", "Ferrer",Gender.FEMALE,
                    LocalDate.of(2006, 12, 20), countries.get(3).getName(), "¡Hola",
                    BEGINNER, List.of("English", "Spain")));

            repository.save(new Student("Johan", "Anderson",Gender.MALE,
                    LocalDate.of(2005, 6, 3), countries.get(4).getName(), "Jambo",
                    ADVANCED, List.of("English", "Africa")));

            repository.save(new Student("Frank", "Abel",Gender.MALE,
                    LocalDate.of(2006, 11, 13), countries.get(5).getName(), "Gruess dich",
                    BEGINNER, List.of("English", "Franc","Germany")));

            repository.save(new Student("Josef", "Huber",Gender.MALE,
                    LocalDate.of(2004, 4, 7), countries.get(6).getName(), "Servus",
                    INTERMEDIATE, List.of("English", "Austria")));

            repository.save(new Student("Amanda", "Williams",Gender.FEMALE,
                    LocalDate.of(2006, 10, 27), countries.get(7).getName(), "G’day",
                    ADVANCED, List.of("English", "Australia")));



            log.info(teachers.getGreetings());
            log.info("Меня зовут "+teachers.getName()+" "+teachers.getSurname());
            log.info("Я буду вести у вас такие предметы:");
            teachers.getSubjects().forEach(s -> log.info(s + " "));
            log.info("");

            repository.findAll().forEach(student -> {
                if (Gender.MALE.equals(student.getGender())) {
                    log.info("Студент: " + student.getName() + " " + student.getLastName() + " - " +
                            "приветствие: " + student.getGreetings());
                } else {
                    log.info("Студентка: " + student.getName() + " " + student.getLastName() + " - " +
                            "приветствие: " + student.getGreetings());
                };
            });


                for (EnglishLevel level : Arrays.asList(ADVANCED, INTERMEDIATE,BEGINNER)) {
                    log.info("");
                    log.info(level.getDesc() + ":");
                    students.stream().filter(s -> Objects.equals(s.getEnglishLevel(), level))
                            .sorted(new StudentComparato())
                            .forEach(s -> log.info(s.getName()));
                    log.info("");
                };


            List<Student> duty = repository.findAll(Sort.by("dateOfBirth").descending());
            String Duty = String.valueOf(duty.get(0));
            log.info("Дежурный "+Duty.toString());


          log.info("");
        };
    }


    private class StudentComparato implements Comparator<Student> {
        public int compare(Student a, Student b) {

            return a.getName().compareTo(b.getName());
        }
    }
}
