package com.example.academicSystem.domain.group;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record GroupRecordDto(
        @NotNull Integer number,
        @NotNull LocalDate initialDate,
        @NotNull Integer vacanciesNumber,
        @NotBlank UUID idCourse) {
}
