package com.jessica.digitalhouse.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

import com.jessica.digitalhouse.model.Result;

@androidx.room.Database(entities = {Result.class}, version =1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {

    public abstract MovieDAO movieDAO();

    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "movie_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
