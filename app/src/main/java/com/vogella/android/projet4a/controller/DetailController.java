package com.vogella.android.projet4a.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet4a.Constants;
import com.vogella.android.projet4a.RestApi.AnimeRestAPI;
import com.vogella.android.projet4a.Singleton;
import com.vogella.android.projet4a.model.Anime;
import com.vogella.android.projet4a.model.AnimeDetail;
import com.vogella.android.projet4a.model.ListResponse;
import com.vogella.android.projet4a.view.AnimeFragment;
import com.vogella.android.projet4a.view.DetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailController {

    private DetailActivity activity;

    public DetailController(DetailActivity activity) { this.activity = activity;}

    public void onCreate(int id) {
        AnimeRestAPI animeAPI = Singleton.getRestApi();

        Call<AnimeDetail> call = animeAPI.getAnimeDetail(id);

        call.enqueue(new Callback<AnimeDetail>() {
            @Override
            public void onResponse(Call<AnimeDetail> call, Response<AnimeDetail> response) {
                AnimeDetail anime = response.body();
                String synopsie = anime.getSynopsis();
                String image_url = anime.getImg_url();
                String title = anime.getTitle();
                String rating = anime.getRating();
                float score = anime.getScore();
                int popularity = anime.getPopularity();

                activity.showDetails(synopsie, image_url, score, title, rating, popularity);
            }
            @Override
            public void onFailure(Call<AnimeDetail> call, Throwable t) {
                Log.d("ERREUR", "API K.O.");
                t.printStackTrace();
                activity.showError();
            }
        });
    }
}

