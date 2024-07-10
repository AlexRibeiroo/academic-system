package com.example.academicSystem.domain.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRecordDto(  @NotBlank String name,
                                @NotNull Integer courseHours,
                                @NotNull Double value,
                                @NotNull Double minimumScore) {
}
