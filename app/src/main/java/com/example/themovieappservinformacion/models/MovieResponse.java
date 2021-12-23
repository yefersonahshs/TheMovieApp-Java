package com.example.themovieappservinformacion.models;

import com.example.themovieappservinformacion.models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {


    @SerializedName("results")
    @Expose
    public ArrayList<Movie> movies= new ArrayList<>();


    public MovieResponse(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
