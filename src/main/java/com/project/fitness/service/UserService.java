package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {
        User user  = new User(
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                Instant.parse("2026-02-09T14:30:00Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
                Instant.parse("2026-02-09T14:30:00Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
                List.of(),
                List.of()
        );

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
