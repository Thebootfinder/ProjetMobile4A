package com.vogella.android.projet4a.controller.MangeController;

import android.util.Log;

import com.vogella.android.projet4a.RestApi.AnimeRestAPI;
import com.vogella.android.projet4a.RestApi.Singleton;
import com.vogella.android.projet4a.model.MangaModel.ListResponseManga;
import com.vogella.android.projet4a.model.MangaModel.Manga;
import com.vogella.android.projet4a.view.MangaView.MangaFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MangaController {

    private MangaFragment activity;

    public MangaController(MangaFragment activity) { this.activity = activity;}

    public void onCreate() {
        AnimeRestAPI animeAPI = Singleton.getRestApi();

        Call<ListResponseManga> call = animeAPI.getListManga();

        call.enqueue(new Callback<ListResponseManga>() {
            @Override
            public void onResponse(Call<ListResponseManga> call, Response<ListResponseManga> response) {
                ListResponseManga restListResponse = response.body();
                List<Manga> listManga = restListResponse.getTop();
                activity.showList(listManga);
            }
            @Override
            public void onFailure(Call<ListResponseManga> call, Throwable t) {

                Log.d("ERREUR", "API K.O.");
                t.printStackTrace();
            }
        });
    }
}

