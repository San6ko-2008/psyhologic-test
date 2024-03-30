package com.example.psychologictest.handler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.psychologictest.R;
import com.example.psychologictest.ResultActivity;
import com.example.psychologictest.data.Stats;
import com.example.psychologictest.model.Task;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskHandler {
    private final AppCompatActivity activity;
    private final List<Task> tasks;
    private final Stats stats = Stats.getInstance();
    private int position = 0;

    @SuppressLint("SetTextI18n")
    public void uploadTask(){
        if (position < tasks.size()){
            Task task = tasks.get(position);

            TextView questionView = activity.findViewById(R.id.questionView);
            questionView.setText(task.getQuestion());

            TextView textNumber = activity.findViewById(R.id.textNumber);
            textNumber.setText("Питання №" + task.getId());

            activity.findViewById(R.id.agreeButton).setOnClickListener(v -> {
                stats.cholericAdd(task.getCholericStat());
                stats.melancholicAdd(task.getMelancholicStat());
                stats.phlegmaticAdd(task.getPhlegmaticStat());
                stats.sanguineAdd(task.getSanguineStat());

                position++;
                uploadTask();
            });
            activity.findViewById(R.id.notSureButton).setOnClickListener(v -> {
                position++;
                uploadTask();
            });
            activity.findViewById(R.id.notAgreeButton).setOnClickListener(v -> {
                stats.cholericAdd(task.getCholericStat() * -1);
                stats.melancholicAdd(task.getMelancholicStat() * -1);
                stats.phlegmaticAdd(task.getPhlegmaticStat() * -1);
                stats.sanguineAdd(task.getSanguineStat() * -1);

                position++;
                uploadTask();
            });
        } else {
            Intent intent = new Intent(activity, ResultActivity.class);
            activity.startActivity(intent);
        }
    }
}
