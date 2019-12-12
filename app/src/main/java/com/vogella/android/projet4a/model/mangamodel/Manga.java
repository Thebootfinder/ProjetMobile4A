package com.vogella.android.projet4a.model.mangamodel;

import java.util.HashMap;
import java.util.Map;

public class Manga {

    private Integer malId;
    private Integer rank;
    private String title;
    private String url;
    private String type;
    private Object volumes;
    private String startDate;
    private Object endDate;
    private Integer members;
    private Double score;
    private String image_url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getVolumes() {
        return volumes;
    }

    public void setVolumes(Object volumes) {
        this.volumes = volumes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImage_url() { return image_url; }

    public void setImageUrl(String imageUrl) {
        this.image_url = image_url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
