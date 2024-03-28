package com.example.psychologictest.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

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
    
    public int sanguineInc(){
        return sanguineStat++;
    }
    public int phlegmaticInc(){
        return phlegmaticStat++;
    }
    public int cholericInc(){
        return cholericStat++;
    }
    public int melancholicInc(){
        return melancholicStat++;
    }

    public Map<Temperament, Integer> getTemperament(){
        Map<Temperament, Integer> temperament = new HashMap<>();
        temperament.put(Temperament.SANGUINE, sanguineStat);
        temperament.put(Temperament.PHLEGMATIC, phlegmaticStat);
        temperament.put(Temperament.CHOLERIC, cholericStat);
        temperament.put(Temperament.MELANCHOLIC, melancholicStat);
        return temperament;
    }
}
