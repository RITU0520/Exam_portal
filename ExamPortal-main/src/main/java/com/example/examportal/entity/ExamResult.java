package com.example.examportal.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private int marks;

    private String grade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", unique = true)
    private Student student;

    public ExamResult() {
    }

    public ExamResult(String subject, int marks, String grade,
                      Student student) {
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                ", student='" + student.getName() + '\'' +
                '}';
    }
}