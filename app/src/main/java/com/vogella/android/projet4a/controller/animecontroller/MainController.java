package com.vogella.android.projet4a.controller.animecontroller;

import android.util.Log;

import com.vogella.android.projet4a.restapi.AnimeRestAPI;
import com.vogella.android.projet4a.restapi.Singleton;
import com.vogella.android.projet4a.view.animeview.AnimeFragment;
import com.vogella.android.projet4a.model.animemodel.Anime;
import com.vogella.android.projet4a.model.animemodel.ListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

