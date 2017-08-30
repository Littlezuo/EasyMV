package com.jaydenxiao.common.baseapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

/**
 * Created by Littlezuo on 2017/8/29.
 */

public class RouterManager {
    public static void start(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public static void start(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void start4result(Activity context, Class<?> cls,int requestCode) {
        Intent intent = new Intent(context, cls);
        context.startActivityForResult(intent,requestCode);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void start4result(Activity context, Class<?> cls, int requestCode, Bundle options) {
        Intent intent = new Intent(context, cls);
        context.startActivityForResult(intent,requestCode,options);
    }

    public static void start(Class<?> cls) {
        start(AppManager.getAppManager().currentActivity(),cls);
    }

    public static void start(Class<?> cls, Bundle bundle) {
        start(AppManager.getAppManager().currentActivity(),cls,bundle);
    }


    public static String  getString(String key,String defaultValue) {
        String value = defaultValue;
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = activity.getIntent();
        if(intent != null) {
            value = intent.getStringExtra(key);
            Bundle extras = intent.getExtras();
            if(extras != null) {
                extras.getString(key,defaultValue);
            }
        }

        return value;
    }

    public static Integer getInt(String key) {
        return getInt(key,-1);
    }
    public static Integer getInt(String key,int defaultValue) {
        int value = defaultValue;
        Activity activity = AppManager.getAppManager().currentActivity();
        Intent intent = activity.getIntent();
        if(intent != null) {
            Bundle extras = intent.getExtras();
            if(extras != null) {
                value = extras.getInt(key,defaultValue);
            }
        }
        return value;
    }





}