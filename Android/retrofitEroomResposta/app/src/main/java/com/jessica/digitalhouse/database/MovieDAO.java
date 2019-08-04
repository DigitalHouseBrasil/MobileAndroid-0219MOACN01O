package com.jessica.digitalhouse.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.jessica.digitalhouse.model.Result;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Result> results);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from movie limit 30")
    Flowable<List<Result>> getAll(); //Flowable é um observable que podemos usar com o RoomDataBase


}
