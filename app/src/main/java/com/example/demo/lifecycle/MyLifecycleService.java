package com.example.demo.lifecycle;

import androidx.lifecycle.LifecycleService;

public class MyLifecycleService extends LifecycleService {

    MyServiceObserver myServiceObserver;

    public MyLifecycleService() {

        myServiceObserver = new MyServiceObserver();
        getLifecycle().addObserver(myServiceObserver);
    }

}
