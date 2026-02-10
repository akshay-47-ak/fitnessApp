package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
   private final UserRepository userRepository;


    public ActivityResponse addActivity(ActivityRequest activityRequest) {

        User user  = userRepository.findById(activityRequest.getUserId())
                .orElseThrow(()-> new RuntimeException("Invalid User ID"));


        Activity activity = Activity.builder()
                .user(user)
                .caloriesBruned(activityRequest.getCaloriesBruned())
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .startTime(activityRequest.getStartTime())
                .additionalMatrics(activityRequest.getAdditionalMatrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {

        ActivityResponse activityResponse = new ActivityResponse();
        
        activityResponse.setUser(savedActivity.getUser());
        activityResponse.setId(savedActivity.getId());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setCaloriesBruned(savedActivity.getCaloriesBruned());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setAdditionalMatrics(savedActivity.getAdditionalMatrics());

        return activityResponse;
    }

    public List<ActivityResponse> getUserActivities(String userId) {

        List<Activity> activityList = activityRepository.findByUserId(userId);

        return activityList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}
