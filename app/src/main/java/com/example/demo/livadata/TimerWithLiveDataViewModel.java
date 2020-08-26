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
    private volatile int second = 0;

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
            second = 0;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    second++;

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            if (currentSecond != null)
                                currentSecond.setValue(second);
                        }
                    });

                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        currentSecond = null;
    }
}
