package com.ldogan.elma.dto;

import jakarta.validation.constraints.NotNull;

public class EnrollRequest {
    @NotNull public Long studentId;
    @NotNull public Long courseId;
}
