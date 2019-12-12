package com.vogella.android.projet4a.restapi;


import com.vogella.android.projet4a.model.animemodel.AnimeDetail;
import com.vogella.android.projet4a.model.animemodel.ListResponse;
import com.vogella.android.projet4a.model.mangamodel.ListResponseManga;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface AnimeRestAPI {
    @GET("top/anime")
    Call<ListResponse> getListAnime();

    @GET("top/manga")
    Call<ListResponseManga> getListManga();

    @GET("anime/{id}")
    Call<AnimeDetail> getAnimeDetail(@Path("id") int id);
}


