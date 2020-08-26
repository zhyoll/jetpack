package com.example.demo.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Query("Select * From student")
    LiveData<List<Student>> getStudentList();

    @Query("Select * From student Where id = :id")
    LiveData<Student> getStudentById(int id);
}