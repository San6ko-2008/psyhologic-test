package com.example.psychologictest.handler;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.psychologictest.R;
import com.example.psychologictest.data.Stats;
import com.example.psychologictest.data.Temperament;
import com.example.psychologictest.model.TemperamentDescription;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResultHandler {
    private final AppCompatActivity activity;
    private final TemperamentDescription descriptions;
    private final Stats stats = Stats.getInstance();

    public void getResult(){
        switch (getMaxTemperament(stats.getTemperamentsAsMap())){
            case SANGUINE: contentUploader("Сангвінік", R.drawable.sanguine, descriptions.getSanguine());
                return;
            case PHLEGMATIC: contentUploader("Флегматік", R.drawable.phlegmatic, descriptions.getPhlegmatic());
                return;
            case CHOLERIC: contentUploader("Холерик", R.drawable.choleric, descriptions.getCholeric());
                return;
            case MELANCHOLIC: contentUploader("Меланхолік", R.drawable.melangholic, descriptions.getMelancholic());
        }
    }

    private Temperament getMaxTemperament(Map<Temperament, Integer> results){
        int max = Integer.MIN_VALUE;
        Temperament maxTemperament = null;

        for (Map.Entry<Temperament, Integer> entry : results.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxTemperament = entry.getKey();
            }
        }

        return maxTemperament;
    }

    @SuppressLint("SetTextI18n")
    private void contentUploader(String temperamentTitleUa, int imageId, String description){
        TextView temperamentTitle = activity.findViewById(R.id.temperametTitle);
        temperamentTitle.setText("Ви - " + temperamentTitleUa);

        ImageView temperamentView = activity.findViewById(R.id.temperamentView);
        temperamentView.setImageResource(imageId);

        TextView temperamentDescription = activity.findViewById(R.id.temperamentDescription);
        temperamentDescription.setText(description);
    }
}
