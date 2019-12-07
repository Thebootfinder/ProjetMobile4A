package com.vogella.android.projet4a.model;

public class AnimeDetail {

    private String synopsis;
    private String image_url;
    private String title;
    private String rating;
    private float score;
    private int popularity;
    private int favorites;

    public AnimeDetail() {
    }

    public String getSynopsis() {
        return synopsis;
    }


    public String getImg_url() {
        return image_url;
    }


    public String getTitle() {
        return title;
    }
    public float getScore() {
        return score;
    }
    public String getRating() {
        return rating;
    }
    public int getPopularity(){
        return popularity;
    }

    public int getFavorites() {
        return favorites;
    }
}