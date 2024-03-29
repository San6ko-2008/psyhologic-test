package com.example.psychologictest.json;

import android.content.Context;
import android.util.Log;

import com.example.psychologictest.R;
import com.example.psychologictest.model.Task;
import com.example.psychologictest.model.TemperamentDescription;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Parser {
    private final Context context;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Task> parseTasks() {
        List<Task> tasks = null;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.tasks);
            tasks = objectMapper.readValue(inputStream, new TypeReference<List<Task>>() {});

            inputStream.close();
        } catch (IOException e) {
            Log.e("TAG", "Error reading JSON", e);
        }
        return tasks;
    }

    public TemperamentDescription parseDescription(){
        TemperamentDescription description = new TemperamentDescription();
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.temperaments);
            description = objectMapper.readValue(inputStream, TemperamentDescription.class);

            inputStream.close();
        } catch (IOException e) {
            Log.e("TAG", "Error reading JSON", e);
        }
        return description;
    }
}
