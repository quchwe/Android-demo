package com.example.quchwe.qqspacedemo.data.source.localSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import static com.google.common.base.Preconditions.checkNotNull;
import com.example.quchwe.qqspacedemo.data.Entity.Comment;
import com.example.quchwe.qqspacedemo.data.Entity.Like;
import com.example.quchwe.qqspacedemo.data.Entity.Things;
import com.example.quchwe.qqspacedemo.data.Entity.User;
import com.example.quchwe.qqspacedemo.data.source.DataSource;
import com.example.quchwe.qqspacedemo.util.schedulers.BaseSchedulerProvider;
import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

@Singleton
public class LocalDataSource implements DataSource {


    @NonNull
    private final BriteDatabase mDatabaseHelper;

    @NonNull
    private Func1<Cursor, User> mUserMapperFunction;

    @NonNull
    private Func1<Cursor,Things> mThingsMapperFunction;

    @NonNull
    private Func1<Cursor,Comment> mCommentMapperFunction;

    @NonNull
    private Func1<Cursor,Like> mLikeMapperFunction;


    public LocalDataSource(@NonNull Context context,
                                 @NonNull SchedulerProvider schedulerProvider) {
        checkNotNull(context, "context cannot be null");
        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
       DbHelper dbHelper = new DbHelper(context);
        SqlBrite sqlBrite = SqlBrite.create();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, schedulerProvider.io());
        mUserMapperFunction = new Func1<Cursor, User>() {
            @Override
            public User call(Cursor c) {
                int userId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID));
                String userName = c.getString(c.getColumnIndexOrThrow(PersistenceContract.UserEntry.COLUMN_NAME_USER_NAME));
                String password = c.getString(c.getColumnIndexOrThrow(PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD));
                String headImage = c.getString(c.getColumnIndexOrThrow(PersistenceContract.UserEntry.COLUMN_NAME_HEAD_IMAGE));

                return new User(userId,userName,password,headImage);
            }
        };
        mThingsMapperFunction = new Func1<Cursor, Things>() {
            @Override
            public Things call(Cursor c) {
                int thingsId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID));
                int userId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_USER));
                int likeId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_LIKE));
                int transId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_ID));
                boolean isTrans = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_IS_TRANS))==0?false:true;
                int commentId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_COMMENT));
                long publishDate = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_DATE));
                String images = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_IMAGES));
                String text = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_TEXT));
                String transText = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_TEXT));
                long transDate = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_DATE));
                String userName = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_USER_NAME));
                String headImage = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_HEAD_IMAGE));
                String orignName = c.getString(c.getColumnIndexOrThrow(PersistenceContract.ThingsEntry.COLUMN_NAME_ORIGN_NAME));

                return new Things(thingsId,userName,orignName,headImage,userId,publishDate,images,text,likeId,commentId,isTrans,transId
                                    ,transText,transDate);

            }
        };
        mCommentMapperFunction = new Func1<Cursor, Comment>() {
            @Override
            public Comment call(Cursor cursor) {
                int commentId = cursor.getInt(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_ID));
                int thingsId = cursor.getInt(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID));
                int userId = cursor.getInt(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID));
                int commentUser = cursor.getInt(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_USER));
                int replyUser = cursor.getInt(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_USER));
                String replyText = cursor.getString(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_TEXT));
                String commentName = cursor.getString(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_NAME));
                String replyName = cursor.getString(cursor.getColumnIndexOrThrow(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_NAME));
                return new Comment(commentId,commentUser,replyUser,userId,thingsId,replyText,commentName,replyName);
            }
        };

        mLikeMapperFunction = new Func1<Cursor, Like>() {
            @Override
            public Like call(Cursor c) {
                int likeId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_ID));
                int thingsId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID));
                int userId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID));
                int zanId = c.getInt(c.getColumnIndexOrThrow(PersistenceContract.LikeEntry.COLUMN_NAME_ZAN_USER_ID));
                String likeName = c.getString(c.getColumnIndexOrThrow(PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_NAME));
                return new Like(zanId,userId,likeId,thingsId,likeName);
            }
        };
    }
    @Override
    public Observable<List<Things>> getThingss(int userId,int mode,long time) {
        String[] projection = {
                PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID,
                PersistenceContract.ThingsEntry.COLUMN_NAME_USER,
                PersistenceContract.ThingsEntry.COLUMN_NAME_ORIGN_NAME,
                PersistenceContract.ThingsEntry.COLUMN_NAME_HEAD_IMAGE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_TEXT,
                PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID,
                PersistenceContract.ThingsEntry.COLUMN_NAME_COMMENT,
                PersistenceContract.ThingsEntry.COLUMN_NAME_DATE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_IMAGES,
                PersistenceContract.ThingsEntry.COLUMN_NAME_IS_TRANS,
                PersistenceContract.ThingsEntry.COLUMN_NAME_LIKE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_USER_NAME,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_DATE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TEXT
        };
        String sql = "";
        if (mode == DataSource.MODE_PRIVATE){
            sql = String.format("SELECT top 10 %s FROM %s WHERE %s > %s and %s LIKE ?  ",
                    TextUtils.join(",", projection), PersistenceContract.ThingsEntry.TABLE_NAME, PersistenceContract.ThingsEntry.COLUMN_NAME_DATE,time,PersistenceContract.ThingsEntry.COLUMN_NAME_USER);
            return mDatabaseHelper.createQuery(PersistenceContract.ThingsEntry.TABLE_NAME, sql, userId+"")
                    .mapToList(mThingsMapperFunction);
        }else if(mode == DataSource.MODE_ALL) {
            sql = String.format("SELECT top 10 %s FROM %s WHERE %s > %s", TextUtils.join(",", projection), PersistenceContract.ThingsEntry.TABLE_NAME,PersistenceContract.ThingsEntry.COLUMN_NAME_DATE,time);
        }
        return mDatabaseHelper.createQuery(PersistenceContract.ThingsEntry.TABLE_NAME, sql)
                .mapToList(mThingsMapperFunction);
}

    @Override
    public Observable<Things> getThings(@NonNull String  userId,String ThingsId) {
        String[] projection = {
                PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID,
                PersistenceContract.ThingsEntry.COLUMN_NAME_USER,
                PersistenceContract.ThingsEntry.COLUMN_NAME_ORIGN_NAME,
                PersistenceContract.ThingsEntry.COLUMN_NAME_HEAD_IMAGE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_TEXT,
                PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID,
                PersistenceContract.ThingsEntry.COLUMN_NAME_COMMENT,
                PersistenceContract.ThingsEntry.COLUMN_NAME_DATE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_IMAGES,
                PersistenceContract.ThingsEntry.COLUMN_NAME_IS_TRANS,
                PersistenceContract.ThingsEntry.COLUMN_NAME_LIKE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_USER_NAME,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_DATE,
                PersistenceContract.ThingsEntry.COLUMN_NAME_TEXT
        };
        String sql = String.format("SELECT %s FROM %s WHERE %s LIKE ? and %s like ?",
                TextUtils.join(",", projection), PersistenceContract.ThingsEntry.TABLE_NAME,PersistenceContract.ThingsEntry.COLUMN_NAME_USER, PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID);
        return mDatabaseHelper.createQuery( PersistenceContract.ThingsEntry.TABLE_NAME, sql, userId,ThingsId)
                .mapToOneOrDefault(mThingsMapperFunction, null);
    }

    @Override
    public void saveThings(@NonNull Things things) {
        checkNotNull(things);
        ContentValues values = new ContentValues();
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_USER,things.getUserId());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_USER_NAME,things.getUserName());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_HEAD_IMAGE,things.getHeadImage());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID,things.getThingsId());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_COMMENT,things.getCommentId());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_TEXT,things.getText());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_IMAGES,things.getImages());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_LIKE,things.getLikeId());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_ORIGN_NAME,things.getOrignName());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_ID,things.getOriginId());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_DATE,things.getTransDate());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_DATE,things.getPublishDate());
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_IS_TRANS,things.isTrans()==false?0:1);
        values.put(PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_TEXT,things.getTransText());
        mDatabaseHelper.insert(PersistenceContract.ThingsEntry.TABLE_NAME,values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public void saveUsers(@NonNull User user) {
            checkNotNull(user);
        ContentValues values = new ContentValues();
        values.put(PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID,user.getUserId());
        values.put(PersistenceContract.UserEntry.COLUMN_NAME_USER_NAME,user.getUserName());
        values.put(PersistenceContract.UserEntry.COLUMN_NAME_HEAD_IMAGE,user.getHeadImage());
        values.put(PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD,user.getUserPassword());

        mDatabaseHelper.insert(PersistenceContract.UserEntry.TABLE_NAME,values,SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public Observable<List<User>> getUsers() {
        String [] projection = {
                PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID,
                PersistenceContract.UserEntry.COLUMN_NAME_USER_NAME,
                PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD,
                PersistenceContract.UserEntry.COLUMN_NAME_HEAD_IMAGE
        };

        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), PersistenceContract.UserEntry.TABLE_NAME);
        return mDatabaseHelper.createQuery(PersistenceContract.UserEntry.TABLE_NAME, sql)
                .mapToList(mUserMapperFunction);

    }

    @Override
    public Observable<User> getUser(String userId,@Nullable String password) {
        String [] projection = {
                PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID,
                PersistenceContract.UserEntry.COLUMN_NAME_USER_NAME,
                PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD,
                PersistenceContract.UserEntry.COLUMN_NAME_HEAD_IMAGE
        };
        String sql = String.format("SELECT %s FROM %s WHERE %s LIKE ?",
                TextUtils.join(",", projection), PersistenceContract.UserEntry.TABLE_NAME, PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID);
        if (password!=null){
            sql+=String.format(" and %s like ?", PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD);
            return mDatabaseHelper.createQuery(PersistenceContract.UserEntry.TABLE_NAME, sql, userId,password)
                    .mapToOneOrDefault(mUserMapperFunction, null);
        }else {
            return mDatabaseHelper.createQuery(PersistenceContract.UserEntry.TABLE_NAME, sql, userId)
                    .mapToOneOrDefault(mUserMapperFunction, null);
        }
    }

    @Override
    public void completeThings(@NonNull Things Things) {

    }

    @Override
    public void clearCompletedThingss() {

    }

    @Override
    public void refreshThingss() {

    }

    @Override
    public void deleteThings(@NonNull int thingsId) {

    }
    public Observable<List<Comment>> getComments(String userId,String thingsId){
        String projection[] = {
                PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_ID,
                PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID,
                PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_USER,
                PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_USER,
                PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_TEXT,
                PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_NAME,
                PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_NAME,
                PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID

        };
    String sql = String.format("SELECT %S FROM %S WHERE %S LIKE ? AND %S LIKE ?",TextUtils.join(",",projection),
            PersistenceContract.CommentEntry.COLUMN_NAME_TABLE_NAME, PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID,
            PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID
    );
   return mDatabaseHelper.createQuery(PersistenceContract.CommentEntry.COLUMN_NAME_TABLE_NAME,sql,userId,thingsId)
            .mapToList(mCommentMapperFunction);
    }

    public Observable<List<Like>> getLikes(String userId,String thingsId){
        String []projection ={
                PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_ID,
                PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_NAME,
                PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID,
                PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID,
                PersistenceContract.LikeEntry.COLUMN_NAME_ZAN_USER_ID
        };

        String sql = String.format("SELECT %S FROM %S WHERE %S LIKE ? AND %S LIKE ?",TextUtils.join(",",projection),
                PersistenceContract.LikeEntry.COLUMN_NAME_TABLE_NAME, PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID,
                PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID
        );
        return mDatabaseHelper.createQuery(PersistenceContract.LikeEntry.COLUMN_NAME_TABLE_NAME,sql,userId,thingsId)
                .mapToList(mLikeMapperFunction);
    }

    public void saveComment(Comment c){
        checkNotNull(c);
        ContentValues values = new ContentValues();
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_ID,c.getCommentId());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID,c.getUserId());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID,c.getThingsId());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_NAME,c.getCommentName());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_USER,c.getCommentUser());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_USER,c.getReplyUser());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_NAME,c.getReplyName());
        values.put(PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_TEXT,c.getReplyText());

        mDatabaseHelper.insert(PersistenceContract.CommentEntry.COLUMN_NAME_TABLE_NAME,values,SQLiteDatabase.CONFLICT_REPLACE);

    }

    public void saveLike(Like l){
        checkNotNull(l);
        ContentValues values = new ContentValues();
        values.put(PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_ID,l.getLikeId());
        values.put(PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_NAME,l.getLikeName());
        values.put(PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID,l.getThingsId());
        values.put(PersistenceContract.LikeEntry.COLUMN_NAME_ZAN_USER_ID,l.getZanId());
        values.put(PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID,l.getUserId());

        mDatabaseHelper.insert(PersistenceContract.LikeEntry.COLUMN_NAME_TABLE_NAME,values,SQLiteDatabase.CONFLICT_REPLACE);
    }
}
