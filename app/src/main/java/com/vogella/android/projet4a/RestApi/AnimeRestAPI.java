package com.vogella.android.projet4a.RestApi;


import com.vogella.android.projet4a.model.AnimeDetail;
import com.vogella.android.projet4a.model.ListResponse;
import com.vogella.android.projet4a.model.MangaModel.ListResponseManga;

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


