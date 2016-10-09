package com.cljz.mylibrary.listacitvityandfragment.util;

import android.util.Log;

/**
 * Created by lrc on 2016/7/27.
 */
public class LogUtil {

    public static void outPutLog(String tag,String msg){
        Log.d(tag,msg);
    }

    public static void outPutLog(String msg){
        Log.d("cljz",msg);
    }
}
