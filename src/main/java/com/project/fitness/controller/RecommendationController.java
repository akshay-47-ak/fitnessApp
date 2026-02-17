package com.project.fitness.controller;

import com.project.fitness.dto.RecoRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendation/")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateReco(
         @RequestBody RecoRequest recoRequest
    ){

        Recommendation recommendation = recommendationService.generateRecommendation(recoRequest);

        return new ResponseEntity<>(recommendation,HttpStatus.CREATED);
    }

}
