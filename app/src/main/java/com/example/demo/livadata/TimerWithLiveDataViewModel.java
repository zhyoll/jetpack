package com.example.demo.livadata;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.Timer;
import java.util.TimerTask;

public class TimerWithLiveDataViewModel extends ViewModel {

    private MutableLiveData<Integer> currentSecond;

    public LiveData<Integer> getCurrentSecond() {
        if (currentSecond == null) {
            currentSecond = new MutableLiveData<>();
        }
        return currentSecond;
    }

    private Timer timer;

    //开始计时
    public void startTiming() {
        if (timer == null) {
            currentSecond.setValue(0);
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {

                    new Handler(Looper.getMainLooper()).post(() -> {
                        Integer value = currentSecond.getValue();
                        currentSecond.setValue(value++);
                    });
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

}
