package com.example.themovieappservinformacion.entitys;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = MovieEntity.TABLE_NAME)
public class MovieEntity {
    /** The name of the Cheese table. */
    public static final String TABLE_NAME = "Movie";

    public static final String COLUMN_NAME = "name";

    /** The name of the ID column. */
    public static final String COLUMN_ID = BaseColumns._ID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long id1;


    @ColumnInfo(name = "id")
    public String id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "poster")
    public String poster;
    @ColumnInfo(name = "release")
    public String release;
    @ColumnInfo(name = "overview")
    public String overview;
    @ColumnInfo(name = "popularity")
    public String popularity;
    @ColumnInfo(name = "vote_average")
    public String vote_average;


    public long getId1() {
        return id1;
    }

    public void setId1(long id1) {
        this.id1 = id1;
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
}
