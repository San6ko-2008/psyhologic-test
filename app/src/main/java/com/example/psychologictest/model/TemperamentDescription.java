package com.example.psychologictest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperamentDescription {
    @JsonProperty("sanguine")
    private String sanguine;

    @JsonProperty("phlegmatic")
    private String phlegmatic;

    @JsonProperty("choleric")
    private String choleric;

    @JsonProperty("melancholic")
    private String melancholic;
}
