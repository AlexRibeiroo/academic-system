package com.example.academicSystem.domain.group;

import com.example.academicSystem.domain.course.Course;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer number;
    private LocalDate initialDate;
    private Integer vacanciesNumber;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Group() {
    }

    public Group(Integer number, LocalDate initialDate, Integer vacanciesNumber, Course course) {
        this.number = number;
        this.initialDate = initialDate;
        this.vacanciesNumber = vacanciesNumber;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public Integer getVacanciesNumber() {
        return vacanciesNumber;
    }

    public void setVacanciesNumber(Integer vacanciesNumber) {
        this.vacanciesNumber = vacanciesNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
