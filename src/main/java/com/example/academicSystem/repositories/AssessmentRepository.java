package com.example.academicSystem.repositories;

import com.example.academicSystem.domain.assessment.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<Assessment, UUID> {
}
