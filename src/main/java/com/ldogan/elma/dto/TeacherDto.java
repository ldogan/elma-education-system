package com.ldogan.elma.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class TeacherDto {
    @NotBlank public String name;
    @Email public String email;
}
