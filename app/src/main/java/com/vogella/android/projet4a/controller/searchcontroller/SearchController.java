package com.vogella.android.projet4a.controller.searchcontroller;

import android.util.Log;

import com.vogella.android.projet4a.model.searchmodel.ListResponseSearch;
import com.vogella.android.projet4a.model.searchmodel.Search;
import com.vogella.android.projet4a.restapi.AnimeRestAPI;
import com.vogella.android.projet4a.restapi.Singleton;
import com.vogella.android.projet4a.view.searchview.SearchFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchController {

    private SearchFragment activity;

    public SearchController(SearchFragment activity) { this.activity = activity;}

    public void onCreate() {
        AnimeRestAPI animeAPI = Singleton.getRestApi();

        Call<ListResponseSearch> call = animeAPI.getListSearch("Hunter");

        call.enqueue(new Callback<ListResponseSearch>() {
            @Override
            public void onResponse(Call<ListResponseSearch> call, Response<ListResponseSearch> response) {
                ListResponseSearch restListResponse = response.body();
                List<Search> listSearch = restListResponse.getResults();
                Log.d("ERREUR", "Ok");
                activity.showList(listSearch);
            }
            @Override
            public void onFailure(Call<ListResponseSearch> call, Throwable t) {

                Log.d("ERREUR", "API K.O.");
                t.printStackTrace();
            }
        });
    }
}

