package com.example.quchwe.qqspacedemo.data.source;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by quchwe on 2016/6/23 0023.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface local {
}
