package com.example.themovieappservinformacion.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.themovieappservinformacion.entitys.MovieEntity;
import com.example.themovieappservinformacion.models.Movie;


import java.util.List;

@Dao
public interface MovieDao {



    @Transaction
    @Query("SELECT * FROM Movie")
    List<Movie> getMovie();

    @Insert
    void insert(MovieEntity movieEntity);


    @Update
    void updateMoviebyId(MovieEntity movieEntity);

    @Delete
    void deleteCourseByID(MovieEntity movieEntity);
}
