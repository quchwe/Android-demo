package com.example.quchwe.qqspacedemo.util.TimeUtil;

import java.util.Date;

/**
 * Created by quchwe on 2016/9/6 0006.
 */

public class FriendlyTime {
    public static String friendlyTime(long time) {
        //获取time距离当前的秒数
        int ct = (int)((System.currentTimeMillis() - time/1000));

        if(ct == 0) {
            return "刚刚";
        }

        if(ct > 0 && ct < 60) {
            return ct + "秒前";
        }

        if(ct >= 60 && ct < 3600) {
            return Math.max(ct / 60,1) + "分钟前";
        }
        if(ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if(ct >= 86400 && ct < 2592000){ //86400 * 30
            int day = ct / 86400 ;
            return day + "天前";
        }
        if(ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }
}
