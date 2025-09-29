package com.ldogan.elma.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentDto {
    @NotBlank public String firstName;
    @NotBlank public String lastName;
    @Email public String email;
}
