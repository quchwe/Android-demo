package com.example.quchwe.qqspacedemo.data.source.localSource;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

public final class PersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PersistenceContract() {}

    /* Inner class that defines the table contents */
    public static abstract class UserEntry  {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_ENTRY_ID = "userId";
        public static final String COLUMN_NAME_USER_NAME = "userName";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_HEAD_IMAGE = "headImage";
    }

    public static abstract class ThingsEntry {
        public static final String TABLE_NAME = "things";
        public static final String COLUMN_NAME_THINGS_ID = "thingsId";
        public static final String COLUMN_NAME_USER = "userId";
        public static final String COLUMN_NAME_DATE = "publishDate";
        public static final String COLUMN_NAME_IMAGES = "images";
        public static final String COLUMN_NAME_TEXT = "text";
        public static final String COLUMN_NAME_COMMENT = "commentId";
        public static final String COLUMN_NAME_LIKE = "likeId";
        public static final String COLUMN_NAME_IS_TRANS = "isTrans";
        public static final String COLUMN_NAME_TRANS_ID = "transId";
        public static final String COLUMN_NAME_TRANS_TEXT = "transText";
        public static final String COLUMN_NAME_TRANS_DATE = "transDate";
        public static final String COLUMN_NAME_USER_NAME = "userName";
        public static final String COLUMN_NAME_HEAD_IMAGE = "headImage";
        public static final String COLUMN_NAME_ORIGN_NAME = "orignName";
    }

    public static abstract class CommentEntry {
        public static final String COLUMN_NAME_TABLE_NAME = "comment";
        public static final String COLUMN_NAME_COMMENT_ID = "commentId";
        public static final String COLUMN_NAME_THINGS_ID = "thingsId";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_COMMENT_USER = "commentUser";
        public static final String COLUMN_NAME_REPLY_USER = "replyUser";
        public static final String COLUMN_NAME_REPLY_TEXT = "replyText";
        public static final String COLUMN_NAME_COMMENT_NAME = "commentName";
        public static final String COLUMN_NAME_REPLY_NAME = "replyName";

    }

    public static abstract class LikeEntry {
        public static final String COLUMN_NAME_TABLE_NAME = "like";
        public static final String COLUMN_NAME_LIKE_ID = "likeId";
        public static final String COLUMN_NAME_THINGS_ID = "thingsId";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_ZAN_USER_ID = "zanId";
        public static final String COLUMN_NAME_LIKE_NAME = "likeName";
    }
}
