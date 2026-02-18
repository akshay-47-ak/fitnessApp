package com.project.fitness.service;

import com.project.fitness.dto.RecoRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;


    public Recommendation generateRecommendation(RecoRequest recoRequest) {

        User user = userRepository.findById(recoRequest.getUserId())
                .orElseThrow(()->new RuntimeException("User Not Found With Id :" + recoRequest.getUserId()));

        Activity activity = activityRepository.findById(recoRequest.getActivityId())
                .orElseThrow(()-> new RuntimeException("Activity Not Found By Id :"+recoRequest.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(recoRequest.getImprovements())
                .suggestions(recoRequest.getSuggestions())
                .safety(recoRequest.getSafety())
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

         return savedRecommendation;
    }

    public List<Recommendation> getRecoByUserId(String userId) {

        List<Recommendation> recommendationList = recommendationRepository.findByUserId(userId);

     return recommendationList;
    }
}
