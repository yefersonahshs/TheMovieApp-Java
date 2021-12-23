package com.example.themovieappservinformacion.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.themovieappservinformacion.interfaces.MovieDao;
import com.example.themovieappservinformacion.entitys.MovieEntity;
import com.example.themovieappservinformacion.config.constants;


@Database(entities = {MovieEntity.class}, version = 0)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public static AppDatabase getAppDatabase(Context context){ //instancia para bd
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, constants.BD_NAME)
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE; //no usar mas instancias de las que se necesita

    }


    public static void destroyInstance(){ //si la appa ya no usara la bd se destruye instancia
        INSTANCE=null;
    }

    @SuppressWarnings("WeakerAccess")
    public abstract MovieDao movieDao(); //que permisos va tener listar, eliminar, update, insertar



    private static AppDatabase sInstance; //variable.


}