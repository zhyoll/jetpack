package com.example.demo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ApplicationObserver implements LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.e("TAG", "Lifecycle.Event.ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.e("TAG", "Lifecycle.Event.ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.e("TAG", "Lifecycle.Event.ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.e("TAG", "Lifecycle.Event.ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.e("TAG", "Lifecycle.Event.ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        Log.e("TAG", "Lifecycle.Event.ON_DESTROY");
    }


}
