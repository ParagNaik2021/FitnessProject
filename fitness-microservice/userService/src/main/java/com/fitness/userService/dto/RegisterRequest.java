package com.fitness.userService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email should be filled")
    @Email(message = "Invlaid email format")
    private String email;
    @Size(min = 6, message = "password must have 6 characters")
    private String password;
    private String firstName;
    private String lastName;
}
