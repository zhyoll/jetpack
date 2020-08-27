package com.example.demo.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("Select * From user Where name = :name")
    LiveData<User> getUserByName(String name);
}
