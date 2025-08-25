package com.fitness.userService.dto;

import com.fitness.userService.models.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UserResponse {

//VCS
    private String id;

    private String email;

    private String password;

    private String firstName;
    private String lastName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
