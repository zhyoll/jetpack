package com.example.demo.mvvm;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private String TAG = this.getClass().getSimpleName();
    private UserDao userDao;
    private Api api;

    public UserRepository(UserDao userDao, Api api) {
        this.userDao = userDao;
        this.api = api;
    }

    public LiveData<User> getUser(final String name){
        refresh(name);
        return userDao.getUserByName(name);
    }

    public void refresh(String userName){
        api.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null){
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void insertUser(final User user){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }
}
