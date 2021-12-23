package com.example.themovieappservinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("title")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String title = getIntent().getStringExtra("title");
            String release = getIntent().getStringExtra("release");
            String Overview = getIntent().getStringExtra("Overview");
            String popularity = getIntent().getStringExtra("popularity");
            String vote = getIntent().getStringExtra("vote");





            setImage(imageUrl,title, release, Overview,popularity,vote);
        }
    }


    private void setImage(String imageUrl,String title, String release, String Overview,String popularity,String vote){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.title_id);
        name.setText(title);

        TextView release_id = findViewById(R.id.release_id);
        release_id.setText(release);

        TextView overview = findViewById(R.id.description_id);
        overview.setText(Overview);

        TextView popularitytv = findViewById(R.id.popularity_id);
        popularitytv.setText(popularity);

        TextView votetv = findViewById(R.id.vote_id);
        votetv.setText(vote);



        ImageView image = findViewById(R.id.imageView2);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
