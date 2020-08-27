package com.example.demo.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demo.MyApp;

public class UserViewModel extends AndroidViewModel {

    private LiveData<User> user;
    private UserRepository userRepository;
    private String userName = "zhy";


    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = MyApp.getUserDatabase();
        UserDao userDao = database.userDao();
        userRepository = new UserRepository(userDao, MyApp.getApi());
        user = userRepository.getUser(userName);
    }

    public LiveData<User> getUser(){
        return user;
    }

    public void refresh(){
        userRepository.refresh(userName);
    }
}
