package com.example.academicSystem.domain.enrollment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EnrollmentRecordDto(
        @NotNull Integer installments,
        @NotBlank LocalDate enrollmentDate,
        @NotBlank UUID classId,
        @NotBlank UUID studentId
        ) {
}
