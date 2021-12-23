package com.example.themovieappservinformacion.models;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie  {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("poster_path")
    @Expose
    public String poster;

    @SerializedName("release_date")
    @Expose
    public String release;


    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("popularity")
    @Expose
    public String popularity;

    @SerializedName("vote_average")
    @Expose
    public String vote_average;


    public Movie(String id, String title, String poster, String release, String overview, String popularity, String vote_average) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.release = release;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }



    public Movie() {
    }


}
