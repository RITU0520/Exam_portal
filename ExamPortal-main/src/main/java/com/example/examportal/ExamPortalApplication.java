package com.example.examportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.examportal.entity.Student;
import com.example.examportal.entity.ExamResult;
import com.example.examportal.repository.ExamResultRepository;

@SpringBootApplication
public class ExamPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ExamResultRepository repository) {

        return args -> {

            // CREATE STUDENT 1
            Student student1 = new Student(
                    "Mahi Gupta",
                    "mahi@gmail.com"
            );

            ExamResult result1 = new ExamResult(
                    "Java",
                    90,
                    "A",
                    student1
            );

            result1 = repository.save(result1);

            System.out.println("\n--- STUDENT 1 CREATED ---");
            System.out.println(result1);


            // CREATE STUDENT 2
            Student student2 = new Student(
                    "Rahul Sharma",
                    "rahul@gmail.com"
            );

            ExamResult result2 = new ExamResult(
                    "Python",
                    85,
                    "A",
                    student2
            );

            result2 = repository.save(result2);

            System.out.println("\n--- STUDENT 2 CREATED ---");
            System.out.println(result2);


            // READ
            System.out.println("\n--- ALL EXAM RESULTS ---");

            repository.findAll().forEach(System.out::println);


            // UPDATE STUDENT 1'S EXAM RESULT
            System.out.println("\n--- UPDATE RESULT ---");

            result1.setMarks(95);
            result1.setGrade("A+");

            result1 = repository.save(result1);

            System.out.println(result1);


            // DISPLAY ALL RESULTS AFTER UPDATE
            System.out.println("\n--- FINAL RESULTS ---");

            repository.findAll().forEach(System.out::println);

            // DELETE is intentionally skipped
            // so records remain in MySQL.
        };
    }
}