package com.example.demo.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demo.R;

public class ViewModelActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        initComponent();
    }

    private void initComponent() {
        textView = findViewById(R.id.textView);
        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        timerViewModel.setOnTimeChangeListener(second -> {
            runOnUiThread(() -> {
                textView.setText("time:" + second);
            });

        });
        timerViewModel.startTiming();
    }
}