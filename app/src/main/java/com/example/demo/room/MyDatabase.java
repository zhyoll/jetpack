package com.example.demo.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Student.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db";


    static final Migration migration_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    static final Migration migration_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    private static MyDatabase databaseInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()   //该方法能够在出现升级异常时，重新创新数据表，程序不会崩溃，但是表被重新创建，所有的数据也会丢失
                    .addMigrations(migration_1_2, migration_1_2)
                    .build();
        }

        return databaseInstance;
    }

    public abstract StudentDao studentDao();

}
