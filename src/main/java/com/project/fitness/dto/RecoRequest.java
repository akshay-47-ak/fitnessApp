package com.project.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecoRequest {

    private String user_id;
    private String activity_id;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
