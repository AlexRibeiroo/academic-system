package com.example.academicSystem.domain.result;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ResultRecordDto(
        @NotNull Double obtainedGrade,
        @NotBlank UUID assessmentId,
        @NotBlank UUID studentId
) {
}
