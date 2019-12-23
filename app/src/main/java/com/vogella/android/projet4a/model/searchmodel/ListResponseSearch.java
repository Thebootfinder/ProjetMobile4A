package com.vogella.android.projet4a.model.searchmodel;

import com.vogella.android.projet4a.model.animemodel.Anime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListResponseSearch {

    // reponse pour search

    private String requestHash;
    private Boolean requestCached;
    private Integer requestCacheExpiry;
    private List<Search> results = null;
    private Integer lastPage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public Boolean getRequestCached() {
        return requestCached;
    }

    public void setRequestCached(Boolean requestCached) {
        this.requestCached = requestCached;
    }

    public Integer getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(Integer requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public List<Search> getResults() {
        return results;
    }

    public void setResults(List<Search> results) {
        this.results = results;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}