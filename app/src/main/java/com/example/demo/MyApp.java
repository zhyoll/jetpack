package com.example.demo;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.example.demo.lifecycle.ApplicationObserver;
import com.example.demo.mvvm.Api;
import com.example.demo.mvvm.RetrofitClient;
import com.example.demo.mvvm.UserDatabase;

public class MyApp extends Application {

    private static UserDatabase userDatabase;
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle()
                .addObserver(new ApplicationObserver());
        userDatabase = UserDatabase.getUserDatabase(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static Api getApi(){
        return api;
    }
    public static UserDatabase getUserDatabase(){
        return userDatabase;
    }
}
