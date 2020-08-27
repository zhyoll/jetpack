package com.example.demo.mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "user_db";

    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, DATABASE_NAME)
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();
}
