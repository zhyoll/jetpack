package com.example.demo.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private MyDatabase myDatabase;
    private LiveData<List<Student>> listLiveData;

    public StudentViewModel(@NonNull Application application) {
        super(application);

        myDatabase = MyDatabase.getInstance(application);

        listLiveData= myDatabase.studentDao().getStudentList();
    }

    public LiveData<List<Student>> getListLiveData(){
        return listLiveData;
    }
}
