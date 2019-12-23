package com.vogella.android.projet4a.restapi;


import com.vogella.android.projet4a.model.animemodel.AnimeDetail;
import com.vogella.android.projet4a.model.animemodel.ListResponse;
import com.vogella.android.projet4a.model.mangamodel.ListResponseManga;
import com.vogella.android.projet4a.model.searchmodel.ListResponseSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface AnimeRestAPI {
    @GET("top/anime")
    Call<ListResponse> getListAnime();

    @GET("top/manga")
    Call<ListResponseManga> getListManga();

    @GET("search/anime")
    Call<ListResponseSearch> getListSearch(@Query("nom") String nom);

    @GET("anime/{id}")
    Call<AnimeDetail> getAnimeDetail(@Path("id") int id);
}


