package com.example.demo.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UnloadLogWorker extends Worker {

    public UnloadLogWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    //耗时任务在doWork中执行
    @NonNull
    @Override
    public Result doWork() {


        //● 若执行成功，则返回Result.success()。
        // ● 若执行失败，则返回Result.failure()。
        // ● 若需要重新执行，则返回Result.retry()
        return Result.success();
    }
}
