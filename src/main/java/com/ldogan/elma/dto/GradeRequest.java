package com.ldogan.elma.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class GradeRequest {
    @NotNull public Long studentId;
    @NotNull public Long courseId;
    @NotNull @Min(0) @Max(100) public Double grade;
}
