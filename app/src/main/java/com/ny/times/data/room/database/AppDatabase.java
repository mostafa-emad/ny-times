package com.ny.times.data.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ny.times.data.room.Dao.ArticleDao;

import com.ny.times.data.room.entity.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "ny_times";
    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract ArticleDao articleDao();

}
