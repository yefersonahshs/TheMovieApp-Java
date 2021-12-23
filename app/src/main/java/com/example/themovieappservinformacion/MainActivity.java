package com.example.themovieappservinformacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.themovieappservinformacion.Client.RetrofitClient;
import com.example.themovieappservinformacion.database.AppDatabase;
import com.example.themovieappservinformacion.entitys.MovieEntity;
import com.example.themovieappservinformacion.models.Movie;
import com.example.themovieappservinformacion.models.MovieResponse;
import com.example.themovieappservinformacion.services.MovieApiInterface;
import com.example.themovieappservinformacion.util.MovieAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;


    ArrayList<Movie> movieList = new ArrayList<Movie>();

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("aca si llega");

        recyclerView= (RecyclerView) findViewById(R.id.rv_movie_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        loadingMovies();

        MovieAdapter adapter=new MovieAdapter(getApplicationContext(),movieList);


        recyclerView.setAdapter(adapter);

        leerBaseDatosTask();


        int numero =adapter.getItemCount();
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "numero selecionado " + movieList.get(recyclerView.getChildAdapterPosition(v)).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void loadingMovies() {

        System.out.println("entrooo");
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        MovieApiInterface getMovie = retrofit.create(MovieApiInterface.class);
        Call<MovieResponse> response = getMovie.getMovies();
        response.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                movieList = response.body().movies;
                recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),movieList));

                for (Movie movies: movieList){
                    System.out.println(movies.id + movies.poster+ movies.release + movies.title);

                }

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

    private void llenarPersonajes() {

     /*   employeEntity3s = AppDatabase.getAppDatabase(getApplicationContext()).EmployeeDao().getAllUsuarios();


        for(EmployeEntity3 entity3: employeEntity3s){
            int employee_id= (int) entity3.getId();
            employeeAttachments = (ArrayList<Attachment>) AppDatabase.getAppDatabase(getApplicationContext()).employeeAttachmentDao().getLanguagesForRepository(employee_id);
            for (Attachment attachment: employeeAttachments){
                empleadosLista1.add(new ListaEmpleado(entity3.getName(), entity3.getWork_location() ,attachment.getUrl()));

            }

        }
*/
    }

    public void  leerBaseDatosTask() {


        for (Movie movies : movieList) {

            MovieEntity obj = new MovieEntity();
            obj.setId(movies.getId().toString());
            obj.setTitle(movies.getTitle().toString());
            obj.setRelease(movies.getRelease().toString());
            obj.setOverview(movies.getOverview().toString());
            obj.setPoster(movies.getPoster().toString());
            obj.setPopularity(movies.getPopularity().toString());
            obj.setVote_average(movies.getVote_average().toString());


            db.movieDao().insert(obj);
            System.out.println(" Se Insertaron Datos ...");
        }


    }
}



