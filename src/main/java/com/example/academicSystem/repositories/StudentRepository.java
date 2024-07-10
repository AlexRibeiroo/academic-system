package com.example.academicSystem.repositories;

import com.example.academicSystem.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
