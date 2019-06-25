package br.com.digitalhouse.roomdatabaseapp.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.roomdatabaseapp.model.Contato;
import io.reactivex.Flowable;

@Dao
public interface ContatosDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contato contato);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contato> contatos);

    @Update
    void update(Contato contato);

    @Delete
    void delete(Contato contato);

    @Query("SELECT * FROM Contatos")
    List<Contato> getAll();

    @Query("SELECT * FROM Contatos")
    Flowable<List<Contato>> getAllRXJava();

    @Query("SELECT * FROM Contatos WHERE id = :id")
    Contato getById(long id);

    @Query("SELECT * FROM Contatos WHERE nome = :nome")
    Contato getByName(String nome);
}
