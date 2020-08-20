package com.example.demo.lifecycle;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LocationObserver implements LifecycleObserver {

    private OnLocationChangeListener listener;

    public LocationObserver(Activity activity, OnLocationChangeListener onLocationChangeListener) {
        listener = onLocationChangeListener;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void startLocation() {
        Log.e("TAG", "startLocation");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void stopLocation() {
        if (listener != null) {
            listener.onLocationChange();
        }
        Log.e("TAG", "stopLocation");
    }


    public interface OnLocationChangeListener {
        void onLocationChange();
    }
}
