package com.software.engineering.alcohollife.util;


import android.util.Log;

import com.software.engineering.alcohollife.BuildConfig;

public class LogUtil {
    private static boolean DEBUG = BuildConfig.DEBUG;

    public static void v(String tag, String msg) {
        if(DEBUG) Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if(DEBUG) Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if(DEBUG) Log.d(tag, msg);
    }

    public static void w(String tag, String msg) {
        if(DEBUG) Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if(DEBUG) Log.e(tag, msg);
    }
}
