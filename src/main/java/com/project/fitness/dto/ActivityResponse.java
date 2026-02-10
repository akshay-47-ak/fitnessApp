package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import com.project.fitness.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {

    private String id;
    private ActivityType type;
    private String userId;
    private Map<String ,Object> additionalMatrics;
    private Integer duration;
    private Integer caloriesBruned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

