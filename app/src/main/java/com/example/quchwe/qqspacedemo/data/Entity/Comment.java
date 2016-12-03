package com.example.quchwe.qqspacedemo.data.Entity;

import java.util.List;

/**
 * Created by quchwe on 2016/9/1 0001.
 */
public class Comment {
    private int commentId;

    private int commentUser;
    private int replyUser;
    private int userId;
    private int thingsId;
    private String replyText;
    private String replyName;
    private String commentName;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(int commentUser) {
        this.commentUser = commentUser;
    }

    public int getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(int replyUser) {
        this.replyUser = replyUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getThingsId() {
        return thingsId;
    }

    public void setThingsId(int thingsId) {
        this.thingsId = thingsId;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentUser=" + commentUser +
                ", replyUser=" + replyUser +
                ", userId=" + userId +
                ", thingsId=" + thingsId +
                ", replyText='" + replyText + '\'' +
                '}';
    }

    public Comment(int commentId, int commentUser, int replyUser, int userId,
                   int thingsId, String replyText,String commentName,String ReplyName) {
        this.commentId = commentId;
        this.commentUser = commentUser;
        this.replyUser = replyUser;
        this.userId = userId;
        this.thingsId = thingsId;
        this.replyText = replyText;
        this.commentName = commentName;
        this.replyName = ReplyName;
    }
}
