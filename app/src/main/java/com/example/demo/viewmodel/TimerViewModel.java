package com.example.demo.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {

    private Timer timer;
    private int currentSecond;
    private OnTimeChangeListener onTimeChangeListener;

    //开始计时
    public void startTiming() {
        if (timer == null){
            currentSecond = 0;
            timer= new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    currentSecond ++;
                    if (onTimeChangeListener != null){
                        onTimeChangeListener.onTimeChanged(currentSecond);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    public interface OnTimeChangeListener{
        void onTimeChanged(int second);
    }

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener){
        this.onTimeChangeListener = onTimeChangeListener;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("viewModel", "onCleared");
        timer.cancel();
    }
}
