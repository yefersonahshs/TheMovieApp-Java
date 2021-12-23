package com.example.themovieappservinformacion.util;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovieappservinformacion.DetailActivity;
import com.example.themovieappservinformacion.R;
import com.example.themovieappservinformacion.models.Movie;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolderDatos> implements View.OnClickListener {
        private Context mContext;


    //  AppDatabase db;
        ArrayList<Movie> listDatos;
        private View.OnClickListener listener;

        public MovieAdapter( Context mContext, ArrayList<Movie> listDatos) {
            this.listDatos = listDatos;
            this.mContext=mContext;
        }


        @NonNull
        @Override
        public MovieAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_item,null,false);

            view.setOnClickListener(this);
            return new MovieAdapter.ViewHolderDatos(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onBindViewHolder(@NonNull MovieAdapter.ViewHolderDatos holder, int position) {
            String poster = "https://image.tmdb.org/t/p/w500" ;

            holder.title.setText(listDatos.get(position).getTitle());
            holder.release.setText(listDatos.get(position).getRelease());
            Glide.with(holder.itemView).load(poster + listDatos.get(position).getPoster()).into(holder.poster_path);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked on: " + listDatos.get(position).getTitle());

                    Toast.makeText(mContext,listDatos.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("image_url",poster + listDatos.get(position).getPoster());
                    intent.putExtra("title", listDatos.get(position).getTitle());
                    intent.putExtra("release", listDatos.get(position).getRelease());
                    intent.putExtra("Overview", listDatos.get(position).getOverview());
                    intent.putExtra("popularity", listDatos.get(position).getPopularity());
                    intent.putExtra("vote", listDatos.get(position).getVote_average());




                    mContext.startActivity(intent);


                }
            });




        }

        @Override
        public int getItemCount() {
            return listDatos == null ? 0 : listDatos.size();
        }

        public void setOnClickListener(View.OnClickListener listener){
            this.listener=listener;



        }
    @Override
    public void onClick(View v) {
            if(listener!=null){
                listener.onClick(v);
                System.out.println("lo cosgisteeeeeeeeeeee");
            }
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {

            TextView title;
            TextView release;
            ImageView poster_path;

            public ViewHolderDatos(@NonNull View itemView) {
                super(itemView);

                title = itemView.findViewById(R.id.movie_title);
                release = itemView.findViewById(R.id.release);
                poster_path = itemView.findViewById(R.id.imageView);


            }




        }


    }
