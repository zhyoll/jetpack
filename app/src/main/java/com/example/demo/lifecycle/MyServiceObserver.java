package com.example.demo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyServiceObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void start(){
        Log.e("TAG", "start");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void stop(){
        Log.e("TAG", "stop");
    }
}
