package com.example.quchwe.qqspacedemo.data.Entity;


/**
 * Created by quchwe on 2016/9/1 0001.
 */

public class Things {
    private int thingsId;
    private String userName;
    private String orignName;
    private String headImage;
    private int userId;
    private long publishDate;
    private String images;
    private String text;
    private int likeId;
    private int  commentId;
    private boolean isTrans;
    private int originId;
    private String transText;
    private long transDate;

    public Things() {
    }

    public Things(int thingsId, String userName, String transName, String headImage, int userId, long publishDate, String images, String text, int likeId, int commentId, boolean isTrans, int originId, String transText, long transDate) {
        this.thingsId = thingsId;
        this.userName = userName;
        this.orignName = transName;
        this.headImage = headImage;
        this.userId = userId;
        this.publishDate = publishDate;
        this.images = images;
        this.text = text;
        this.likeId = likeId;
        this.commentId = commentId;
        this.isTrans = isTrans;
        this.originId = originId;
        this.transText = transText;
        this.transDate = transDate;
    }

    public int getThingsId() {
        return thingsId;
    }

    public void setThingsId(int thingsId) {
        this.thingsId = thingsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrignName() {
        return orignName;
    }

    public void setOrignName(String orignName) {
        this.orignName = orignName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public boolean isTrans() {
        return isTrans;
    }

    public void setTrans(boolean trans) {
        isTrans = trans;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public String getTransText() {
        return transText;
    }

    public void setTransText(String transText) {
        this.transText = transText;
    }

    public long getTransDate() {
        return transDate;
    }

    public void setTransDate(long transDate) {
        this.transDate = transDate;

    }

    @Override
    public String toString() {
        return "Things{" +
                "thingsId=" + thingsId +
                ", userName='" + userName + '\'' +
                ", orignName='" + orignName + '\'' +
                ", headImage='" + headImage + '\'' +
                ", userId=" + userId +
                ", publishDate=" + publishDate +
                ", images='" + images + '\'' +
                ", text='" + text + '\'' +
                ", likeId=" + likeId +
                ", commentId=" + commentId +
                ", isTrans=" + isTrans +
                ", originId=" + originId +
                ", transText='" + transText + '\'' +
                ", transDate=" + transDate +
                '}';
    }
}
