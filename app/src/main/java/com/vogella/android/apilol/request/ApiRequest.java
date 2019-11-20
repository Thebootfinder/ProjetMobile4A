package com.vogella.android.apilol.request;

import android.content.Context;
import android.util.Log;

import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequest {

    private RequestQueue queue;
    private Context context;
    private static final String API_KEY = "RGAPI-63da28c6-1df7-408c-a1a0-a3417455114d";
    private String region = "euw";

    public ApiRequest(RequestQueue queue, Context context ){
        this.queue = queue;
        this.context = context;
    }

    public void checkPlayerName(final String name, final CheckPlayerCallBack callBack){

      String url= "https://"+region+"1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+name+"?api_key="+API_KEY;
   //   String url ="https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/bouctine?api_key=RGAPI-63da28c6-1df7-408c-a1a0-a3417455114d";



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null ,  new Response.Listener<JSONObject>() { // API APPEL
            @Override
            public void onResponse(JSONObject response) {

                Log.d("APP", response.toString());

                try {
                    JSONObject json = response.getJSONObject(name.toLowerCase());
                    String name = json.getString("name");
                    long id = json.getLong("id");
                    callBack.onSucess(name, id);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if(error instanceof NetworkError){
                    callBack.onError("impossible de se connecter");
                }else if(error instanceof ServerError){
                    callBack.dontExist("ce joueur n'existe pas");
                }
                Log.d("APP", "ERROR= " + error);

            }
        });

    queue.add(request);




    }

    public interface CheckPlayerCallBack{
        void onSucess(String name, long id);
        void dontExist(String message);
        void onError(String message);
    }

}
