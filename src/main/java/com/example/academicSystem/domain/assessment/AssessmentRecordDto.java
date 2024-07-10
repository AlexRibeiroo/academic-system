package com.example.academicSystem.domain.assessment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AssessmentRecordDto(
        @NotNull Double grade,
        @NotBlank LocalDate date
        ) {
}
