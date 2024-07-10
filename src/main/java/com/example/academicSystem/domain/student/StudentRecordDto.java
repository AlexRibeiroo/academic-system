package com.example.academicSystem.domain.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StudentRecordDto(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotNull LocalDate birth
        ) {
}
