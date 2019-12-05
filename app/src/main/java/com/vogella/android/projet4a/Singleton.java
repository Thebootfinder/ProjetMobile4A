package com.vogella.android.projet4a;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.projet4a.RestApi.AnimeRestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {

    private static AnimeRestAPI restApi = null;

    public static AnimeRestAPI getRestApi(){
        if(restApi == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApi = retrofit.create(AnimeRestAPI.class);
        }
        return restApi;
    }
}
