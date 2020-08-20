package com.example.demo;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.example.demo.lifecycle.ApplicationObserver;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle()
                .addObserver(new ApplicationObserver());
    }
}
