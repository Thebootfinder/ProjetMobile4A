package com.vogella.android.projet4a.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet4a.RestApi.AnimeRestAPI;
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
    private static final String BASE_URL = "https://api.jikan.moe/v3/";

    public DetailController(DetailActivity activity) { this.activity = activity;}

    public void onCreate(int id) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AnimeRestAPI animeAPI = retrofit.create(AnimeRestAPI.class);

        Call<AnimeDetail> call = animeAPI.getAnimeDetail(id);

        call.enqueue(new Callback<AnimeDetail>() {
            @Override
            public void onResponse(Call<AnimeDetail> call, Response<AnimeDetail> response) {
                AnimeDetail anime = response.body();
                activity.showDetails(anime);
            }
            @Override
            public void onFailure(Call<AnimeDetail> call, Throwable t) {
                Log.d("ERREUR", "API K.O.");
                t.printStackTrace();
            }
        });
    }
}

