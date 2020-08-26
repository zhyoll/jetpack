package com.example.demo.room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private static final String TAG = "RoomActivity";

    private List<Student> studentList;
    private MyDatabase myDatabase;
    private ListView mListView;

    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        studentList = new ArrayList<>();
        Student student1 = new Student(1, "张三", "10");
        Student student2 = new Student(2, "李四", "15");
        Student student3 = new Student(3, "王五", "45");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentAdapter = new StudentAdapter(studentList, this);
        myDatabase = MyDatabase.getInstance(this);
        mListView = findViewById(R.id.listView);
        mListView.setAdapter(studentAdapter);

        StudentViewModel studentViewModel = new ViewModelProvider(this)
                .get(StudentViewModel.class);
        studentViewModel.getListLiveData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentList.clear();
                studentList.addAll(students);
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addStudent(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myDatabase.studentDao().insertStudent(new Student(100, "赵六", "23"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void updateStudent(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                myDatabase.studentDao().insertStudent(new Student(100, "赵六", "23"));
            }
        }).start();
    }

    public void deleteStudent(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    public void queryStudent(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
//                studentList.clear();
//                studentList.addAll(myDatabase.studentDao().getStudentList());
//                mHandler.sendEmptyMessage(4);
            }
        }).start();
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 4){
                studentAdapter.notifyDataSetChanged();
            }
        }
    };

}