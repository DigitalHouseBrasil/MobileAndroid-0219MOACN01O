package br.com.digitalhouse.exercicioretrofitapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.exercicioretrofitapp.model.Result;
import io.reactivex.Flowable;

@Dao
public interface PessoasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from pessoas limit 30")
    List<Result> getAll();

    @Query("Select * from pessoas limit 30")
    Flowable<Result> getAllRxJava();

    @Query("Select * from pessoas where idBanco = :id")
    Result getPessoaById(long id);

    @Query("Select * from pessoas where idBanco = :id")
    Flowable<Result> getPessoaByIdRxJava(long id);
}
