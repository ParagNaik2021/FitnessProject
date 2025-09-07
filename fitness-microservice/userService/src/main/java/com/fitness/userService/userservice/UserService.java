package com.fitness.userService.userservice;

import com.fitness.userService.Repository.UserRepository;
import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepositor;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        if (userRepositor.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already Exists!!!");

        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        User savedUser = userRepositor.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        //  userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());

        return userResponse;

    }

    public UserResponse getUserProfile(String userID) {

        User user = userRepositor.findById(userID).orElseThrow(() -> new RuntimeException("User not present"));
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }

    public Boolean existByUserId(String userID) {
        log.info("Calling user service for {}", userID);
        return userRepositor.existsById(userID);
    }
}
