package com.vogella.android.projet4a.controller;

import android.util.Log;

import com.vogella.android.projet4a.RestApi.AnimeRestAPI;
import com.vogella.android.projet4a.RestApi.Singleton;
import com.vogella.android.projet4a.model.AnimeDetail;
import com.vogella.android.projet4a.view.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String image_url = anime.getImageUrl();
                String title = anime.getTitle();
                String rating = anime.getRating();
                Double score = anime.getScore();
                int favorites = anime.getFavorites();
                int popularity = anime.getPopularity();
                int rank = anime.getRank();

                activity.showDetails(synopsie, image_url, score, title,  rating, favorites , popularity, rank);
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

