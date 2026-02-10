package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {

          LocalDateTime a = Instant.parse("2026-02-09T14:30:00Z").atZone(ZoneOffset.UTC).toLocalDateTime();
          LocalDateTime b =  Instant.parse("2026-02-09T14:30:00Z").atZone(ZoneOffset.UTC).toLocalDateTime();

        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .createdAt(a)
                .updatedAt(b)
                .build();

 /*       User user  = new User(
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),

                List.of(),
                List.of()
        );*/

        User savedUser = userRepository.save(user);

      return  mapToUserResponse(savedUser);
    }

    private UserResponse mapToUserResponse(User savedUser) {
          UserResponse userResponse = new UserResponse();

          userResponse.setId(savedUser.getId());
          userResponse.setEmail(savedUser.getEmail());
          userResponse.setPassword(savedUser.getPassword());
          userResponse.setFirstName(savedUser.getFirstName());
          userResponse.setLastName(savedUser.getLastName());
          userResponse.setCreatedAt(savedUser.getCreatedAt());
          userResponse.setUpdatedAt(savedUser.getUpdatedAt());

    return userResponse;
    }
}
