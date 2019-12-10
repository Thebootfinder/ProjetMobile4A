package com.vogella.android.projet4a.model.AnimeModel;

public class Anime {

    private int mal_id;
    private int rank;
    private String title;
    private String url;
    private String image_url;
    private String type;
    private int episodes;
    private String start_date;
    private String end_date;
    private int members;
    private float score;

    public int getMal_id() {
        return mal_id;
    }


    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getMembers() {
        return members;
    }

    public float getScore() {
        return score;
    }
}
