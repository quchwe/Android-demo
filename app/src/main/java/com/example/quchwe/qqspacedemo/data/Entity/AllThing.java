package com.example.quchwe.qqspacedemo.data.Entity;

import java.util.List;

/**
 * Created by quchwe on 2016/9/5 0005.
 */

public class AllThing {
    private Things things;
    private List<Like> likes;
    private List<Comment> comments;

    public AllThing() {
    }

    public Things getThings() {
        return things;
    }

    public void setThings(Things things) {
        this.things = things;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
