package com.example.demo.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.example.demo.R;

import java.util.concurrent.TimeUnit;

public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        initWorkManager();
    }

    private void initWorkManager() {
        //触发条件
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresStorageNotLow(true)
                .build();

        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UnloadLogWorker.class)
                .setConstraints(constraints)                        //设置触发条件
                .setInitialDelay(10, TimeUnit.SECONDS)    //符合出发条件后，延迟10S执行
                .setBackoffCriteria(BackoffPolicy.LINEAR, OneTimeWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS) //设置指数退避策略
                .addTag("UploadTag")//设置tag标签，可以通过标签跟踪任务状态：WorkManager.getWorkInfosByTagLiveData（String tag）；也可以取消任务：WorkManager.cancelAll WorkByTag（String tag）
                .build();

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消任务
        WorkManager.getInstance(this).cancelAllWork();
    }
}