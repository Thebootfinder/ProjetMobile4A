package com.vogella.android.projet4a.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet4a.Constants;
import com.vogella.android.projet4a.RestApi.AnimeRestAPI;
import com.vogella.android.projet4a.Singleton;
import com.vogella.android.projet4a.view.AnimeFragment;
import com.vogella.android.projet4a.model.Anime;
import com.vogella.android.projet4a.model.ListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private AnimeFragment activity;

    public MainController(AnimeFragment activity) { this.activity = activity;}

    public void onCreate() {
        AnimeRestAPI animeAPI = Singleton.getRestApi();

        Call<ListResponse> call = animeAPI.getListAnime();

        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse restListResponse = response.body();
                List<Anime> listAnime = restListResponse.getTop();
                activity.showList(listAnime);
            }
            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {

                Log.d("ERREUR", "API K.O.");
                t.printStackTrace();
            }
        });
    }
}

