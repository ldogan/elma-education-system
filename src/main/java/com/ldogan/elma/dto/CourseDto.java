package com.ldogan.elma.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseDto {
    @NotBlank public String name;
    @NotBlank public String code;
    public Long teacherId; // optional
}
