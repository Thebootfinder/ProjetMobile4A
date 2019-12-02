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

   // private static final String BASE_URL_BACKDROP = "https://api.jikan.moe/v3/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int idAnime = intent.getIntExtra(MyAdapter.ID_ANIME, 1 );

        detailcontroller = new DetailController(this);
        detailcontroller.onCreate(idAnime);
    }

    public void showDetails(AnimeDetail anime) {
        TextView textOverview = findViewById(R.id.titleDetail);
        textOverview.setText(anime.getSynopsis());
    }
}