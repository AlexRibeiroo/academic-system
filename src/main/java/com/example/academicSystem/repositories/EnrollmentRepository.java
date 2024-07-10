package com.example.academicSystem.repositories;

import com.example.academicSystem.domain.enrollment.Enrollment;
import com.example.academicSystem.domain.enrollment.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
}
