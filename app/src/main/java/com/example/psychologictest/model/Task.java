package com.example.psychologictest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @JsonProperty("id")
    private int id;

    @JsonProperty("question")
    private String question;

    @JsonProperty("sanguineStat")
    private int sanguineStat;

    @JsonProperty("phlegmaticStat")
    private int phlegmaticStat;

    @JsonProperty("cholericStat")
    private int cholericStat;

    @JsonProperty("melancholicStat")
    private int melancholicStat;
}
