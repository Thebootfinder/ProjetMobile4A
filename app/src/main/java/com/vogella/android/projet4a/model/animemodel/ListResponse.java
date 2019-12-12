package com.vogella.android.projet4a.model.animemodel;

import java.util.List;
// top/anime/ reponse detaillé des [ ]
public class ListResponse {

// reponse pour top/anime

    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private List<Anime> top;


    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public List<Anime> getTop() {
        return top;
    }
}
