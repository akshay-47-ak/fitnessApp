package com.project.fitness.service;

import com.project.fitness.dto.RecoRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;


    public Recommendation generateRecommendation(RecoRequest recoRequest) {



    }
}
