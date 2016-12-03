package com.example.quchwe.qqspacedemo.data.Entity;

/**
 * Created by quchwe on 2016/9/2 0002.
 */

public class Like {
    private int userId;
    private int likeId;
    private int thingsId;
    private int zanId;
    private String likeName;

    public Like() {
    }

    public Like(int zanId, int userId, int likeId, int thingsId,String likeName) {
        this.zanId = zanId;
        this.userId = userId;
        this.likeId = likeId;
        this.thingsId = thingsId;
        this.likeName = likeName;
    }

    @Override
    public String toString() {
        return "Like{" +
                "userId=" + userId +
                ", likeId=" + likeId +
                ", thingsId=" + thingsId +
                ", zanId=" + zanId +
                '}';
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getThingsId() {
        return thingsId;
    }

    public void setThingsId(int thingsId) {
        this.thingsId = thingsId;
    }

    public int getZanId() {
        return zanId;
    }

    public void setZanId(int zanId) {
        this.zanId = zanId;
    }
}
