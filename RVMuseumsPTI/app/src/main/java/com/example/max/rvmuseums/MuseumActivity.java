package com.example.max.rvmuseums;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MuseumActivity extends AppCompatActivity {

    TextView name, website, trivia, adress, phone;
    ImageView poster;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        Intent intent = getIntent();

        name = findViewById(R.id.name);
        website=findViewById(R.id.website);
        trivia=findViewById(R.id.trivia);
        adress=findViewById(R.id.adress);
        phone=findViewById(R.id.phone);
        poster = findViewById(R.id.poster);


        class WebsiteClicker implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Скоро сделаю переход на сайты", Toast.LENGTH_SHORT).show();
            }
        }
        website.setOnClickListener(new WebsiteClicker());


        name.setText(intent.getStringExtra("name"));
        trivia.setText(intent.getStringExtra("trivia"));
        adress.setText(intent.getStringExtra("adress"));
        website.setText(intent.getStringExtra("website"));
        phone.setText(intent.getStringExtra("phone"));
        //Picasso.get().load(intent.getStringExtra("URL")).resize(640, 480).into(poster);
        if(intent.getStringExtra("URL").isEmpty()){
            Picasso.get().load("https://yt3.ggpht.com/a-/AJLlDp3w3Ok_TD46pLqIlFB7_TbbwUHQ4D867hKRhQ=s900-mo-c-c0xffffffff-rj-k-no").resize(640, 480).into(poster);
            //Log.d("NewsPosterLost", "потрачено "+news.getNewsPicURL());
        }else {
            Picasso.get().load(intent.getStringExtra("URL")).resize(640, 480).into(poster);
            //Log.d("NewsPosterLostGet", news.getNewsPicURL());
        }

        setTitle("Музей");


    }
}
