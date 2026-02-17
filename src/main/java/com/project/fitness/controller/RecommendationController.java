package com.project.fitness.controller;

import com.project.fitness.dto.RecoRequest;
import com.project.fitness.model.Recommendation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    public ResponseEntity<Recommendation> generateReco(
         @RequestBody RecoRequest recoRequest
    ){

        Recommendation recommendation = recommendationService.generateRecommendation(recoRequest);

        return new ResponseEntity<>(recommendation,HttpStatus.CREATED);
    }

}
