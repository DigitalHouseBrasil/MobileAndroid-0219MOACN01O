package br.com.digitalhouse.exercicioretrofitapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.exercicioretrofitapp.data.database.dao.PessoasDao;
import br.com.digitalhouse.exercicioretrofitapp.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DataBase extends RoomDatabase {
    private static volatile DataBase INSTANCE;

    public abstract PessoasDao pessoasDao();

    public static DataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DataBase.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
