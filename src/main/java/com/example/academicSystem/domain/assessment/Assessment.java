package com.example.academicSystem.domain.assessment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="assessment")
public class Assessment {
    @Id
    @GeneratedValue
    private UUID id;
    private Double grade;
    private LocalDate date;

    public Assessment() {
    }

    public Assessment(Double grade, LocalDate date) {
        this.grade = grade;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
