package com.example.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examportal.entity.ExamResult;

public interface ExamResultRepository
        extends JpaRepository<ExamResult, Long> {

}