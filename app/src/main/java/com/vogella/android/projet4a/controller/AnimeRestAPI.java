package com.vogella.android.projet4a.controller;


//import com.example.filmdatabase.model.Genre;
//import com.example.filmdatabase.model.RestDetailResponse;
//import com.example.filmdatabase.model.RestListResponse;

import com.vogella.android.projet4a.model.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface AnimeRestAPI {

    @GET("top/anime")
    Call<ListResponse> getListAnime();


}


