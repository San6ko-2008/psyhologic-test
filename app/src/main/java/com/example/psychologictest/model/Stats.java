package com.example.psychologictest.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;

@Getter
public class Stats {
    private static Stats instance;
    private Stats(){}

    public static Stats getInstance() {
        if (instance == null){
            instance = new Stats();
        }
        return instance;
    }

    private int sanguineStat = 0;
    private int phlegmaticStat = 0;
    private int cholericStat = 0;
    private int melancholicStat = 0;
    
    public void sanguineAdd(int stat){
        sanguineStat += stat;
    }
    public void phlegmaticAdd(int stat){
        phlegmaticStat += stat;
    }
    public void cholericAdd(int stat){
        cholericStat += stat;
    }
    public void melancholicAdd(int stat){
        melancholicStat += stat;
    }

    public Map<Temperament, Integer> getTemperamentsAsMap(){
        Map<Temperament, Integer> temperament = new HashMap<>();
        temperament.put(Temperament.SANGUINE, sanguineStat);
        temperament.put(Temperament.PHLEGMATIC, phlegmaticStat);
        temperament.put(Temperament.CHOLERIC, cholericStat);
        temperament.put(Temperament.MELANCHOLIC, melancholicStat);
        return temperament;
    }
}
