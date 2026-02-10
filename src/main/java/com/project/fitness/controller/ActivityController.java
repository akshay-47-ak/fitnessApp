package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ActivityController {

 private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<ActivityResponse> createActivty
            (@RequestBody ActivityRequest activityRequest){

          ActivityResponse activityResponse = activityService.addActivity(activityRequest);

      return new ResponseEntity<>(activityResponse,HttpStatus.CREATED);
    }

    @GetMapping("/activity")
    public ResponseEntity<List<ActivityResponse>> fetchActivity
            (@RequestHeader(value = "X-User-ID") String UserId){

        return new ResponseEntity<>(activityService.getUserActivities(UserId),HttpStatus.OK);
    }


}
