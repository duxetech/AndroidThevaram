package com.duxetech.json;

/**
 * * Created by Karthik Swamy - http://duxetech.com on 12/02/19
 **/
public class Item {
    String url, creator;
    int likes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Item(String url, String creator, int likes) {

        this.url = url;
        this.creator = creator;
        this.likes = likes;
    }
}
