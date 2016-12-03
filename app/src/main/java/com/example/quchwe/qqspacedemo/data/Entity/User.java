package com.example.quchwe.qqspacedemo.data.Entity;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String headImage;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", headImage='" + headImage + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public User() {
    }

    public User(int userId, String userName, String userPassword, String headImage) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.headImage = headImage;
    }
}
