package com.vogella.android.projet4a.view;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.controller.DetailController;
import com.vogella.android.projet4a.model.Anime;
import com.vogella.android.projet4a.model.AnimeDetail;

import java.text.DecimalFormat;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public DetailActivity(){ }
    private DetailController detailcontroller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int idAnime = intent.getIntExtra(MyAdapter.ID_ANIME, 1 );

        detailcontroller = new DetailController(this);
        detailcontroller.onCreate(idAnime);
    }

    public void showDetails(String Synopsie, String image_url, Double score , String title , String rating,int favorites, int popularity, int rank) {
        TextView textSynopsis = findViewById(R.id.synopsis);
        textSynopsis.setText(Synopsie);

     /*  if (image_url != null) {
            ImageView imageView = findViewById(R.id.img_url);
            Picasso.with(this).load(image_url).into(imageView);
        }*/

        TextView textTitle = findViewById(R.id.title);
        textTitle.setText(title);

        TextView textTagline = findViewById(R.id.rating);
        textTagline.setText("Public : " + rating);

        TextView textRank = findViewById(R.id.rank);
       textRank.setText("Classement note : " + String.format(String.valueOf(rank)));

        TextView textPopularity = findViewById(R.id.popularity);
        textPopularity.setText("Classement popularité : " + String.format(String.valueOf(popularity)));





        TextView textVote_average = findViewById(R.id.note);
        DecimalFormat df = new DecimalFormat("#.##");
        if(score<2) {
            textVote_average.setText("Note : ★☆☆☆☆   "+df.format(score));
        }else if(score<4) {
            textVote_average.setText("Note : ★★☆☆☆   "+df.format(score));
        }else if(score<6) {
            textVote_average.setText("Note : ★★★☆☆   "+df.format(score));
        }else if(score<8) {
            textVote_average.setText("Note : ★★★★☆   "+df.format(score));
        }else if(score<10) {
            textVote_average.setText("Note : ★★★★★   "+df.format(score));
        }else {
            textVote_average.setText("Note : ☆☆☆☆☆   "+df.format(score));
        }

        /*
        if (image_url != null) {
            ImageView ImageAnime = findViewById(R.id.ImageAnime);
            Picasso.with(this).load(image_url).into(ImageAnime);
        }*/
    }


    public void showError() {

    }
}