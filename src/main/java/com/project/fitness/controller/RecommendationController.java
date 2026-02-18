package com.project.fitness.controller;

import com.project.fitness.dto.RecoRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getReco/{userId}")
    public ResponseEntity<List<Recommendation>> getRecoByUser(
            @PathVariable("userId") String userId
    ){
          List<Recommendation> recommendation = recommendationService.getRecoByUserId(userId);

        return new ResponseEntity<>(recommendation,HttpStatus.OK);
    }

}
