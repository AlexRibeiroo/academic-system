package com.example.academicSystem.domain.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String cpf;
    private LocalDate birth;

    public Student() {
    }

    public Student(String name, String cpf, LocalDate birth) {
        this.name = name;
        this.cpf = cpf;
        this.birth = birth;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
