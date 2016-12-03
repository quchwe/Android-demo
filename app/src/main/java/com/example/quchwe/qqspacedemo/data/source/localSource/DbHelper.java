package com.example.quchwe.qqspacedemo.data.source.localSource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "qq_space.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGR_TYPE = " INTEGER";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_USER_ENTRIES =
            "CREATE TABLE " + PersistenceContract.UserEntry.TABLE_NAME + " (" +
                PersistenceContract.UserEntry.COLUMN_NAME_ENTRY_ID + INTEGR_TYPE + " PRIMARY KEY," +
                    PersistenceContract.UserEntry.COLUMN_NAME_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.UserEntry.COLUMN_NAME_PASSWORD+ TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.UserEntry.COLUMN_NAME_HEAD_IMAGE + TEXT_TYPE +
                    " )";

    private static final String SQL_CREATE_THINGS_ENTRIES =
            "CREATE TABLE "+PersistenceContract.ThingsEntry.TABLE_NAME+"("+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_USER+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_COMMENT+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_DATE+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_IMAGES+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_IS_TRANS+BOOLEAN_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_DATE+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_LIKE+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_TRANS_TEXT+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_TEXT+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_USER_NAME+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_HEAD_IMAGE+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_ORIGN_NAME+TEXT_TYPE+COMMA_SEP+
                    "PRIMARY KEY("+PersistenceContract.ThingsEntry.COLUMN_NAME_THINGS_ID+COMMA_SEP+
                    PersistenceContract.ThingsEntry.COLUMN_NAME_USER+"))";

    private static final String  SQL_CREATE_COMMENT_ENTRIES =
            "CREATE TABLE "+ PersistenceContract.CommentEntry.COLUMN_NAME_TABLE_NAME+"("+
                    PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_USER+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_USER+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_TEXT+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_NAME+TEXT_TYPE+COMMA_SEP+
                    PersistenceContract.CommentEntry.COLUMN_NAME_REPLY_NAME+TEXT_TYPE+COMMA_SEP+
                    "PRIMARY KEY("+ PersistenceContract.CommentEntry.COLUMN_NAME_USER_ID+COMMA_SEP+ PersistenceContract.CommentEntry.COLUMN_NAME_THINGS_ID
                    +COMMA_SEP+ PersistenceContract.CommentEntry.COLUMN_NAME_COMMENT_ID+"))";
    private static final String SQL_CREATE_LIKE_ENTRIES =
            "CREATE TABLE "+ PersistenceContract.LikeEntry.COLUMN_NAME_TABLE_NAME+"("+
                    PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID+INTEGR_TYPE+COMMA_SEP+
                    PersistenceContract.LikeEntry.COLUMN_NAME_ZAN_USER_ID +INTEGR_TYPE+COMMA_SEP+
                    "PRIMARY KEY("+ PersistenceContract.LikeEntry.COLUMN_NAME_USER_ID+COMMA_SEP+ PersistenceContract.LikeEntry.COLUMN_NAME_THINGS_ID
                    +COMMA_SEP+ PersistenceContract.LikeEntry.COLUMN_NAME_LIKE_ID+"))";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER_ENTRIES);
        db.execSQL(SQL_CREATE_THINGS_ENTRIES);
        db.execSQL(SQL_CREATE_COMMENT_ENTRIES);
        db.execSQL(SQL_CREATE_LIKE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
