package com.fitness.userService.Repository;

import com.fitness.userService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
}
