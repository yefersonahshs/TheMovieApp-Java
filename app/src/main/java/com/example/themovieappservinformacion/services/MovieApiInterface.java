package com.example.themovieappservinformacion.services;

import com.example.themovieappservinformacion.models.MovieResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MovieApiInterface {


    @GET("movie/popular?api_key=09963e300150f9831c46a1828a82a984&language=en-US")
    Call<MovieResponse> getMovies();

}
