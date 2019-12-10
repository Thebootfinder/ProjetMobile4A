package com.vogella.android.projet4a.model.MangaModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListResponseManga {

    private String requestHash;
    private Boolean requestCached;
    private Integer requestCacheExpiry;
    private List<Manga> top = null;
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

    public List<Manga> getTop() {
        return top;
    }

    public void setTop(List<Manga> top) {
        this.top = top;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}