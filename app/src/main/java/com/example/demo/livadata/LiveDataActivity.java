package com.example.demo.livadata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.demo.R;

public class LiveDataActivity extends AppCompatActivity {

    TextView textView;
    MutableLiveData<Integer> liveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        textView = findViewById(R.id.textViewLiveData);
        initComponent();
    }

    private void initComponent() {
        TimerWithLiveDataViewModel timerWithLiveDataViewModel = new ViewModelProvider(this)
                .get(TimerWithLiveDataViewModel.class);
        liveData = (MutableLiveData<Integer>) timerWithLiveDataViewModel
                .getCurrentSecond();
        liveData.observe(this, integer -> textView.setText("time: " + integer));
        timerWithLiveDataViewModel.startTiming();
    }

    public void resetTimer(View view) {
        liveData.setValue(0);
    }
}