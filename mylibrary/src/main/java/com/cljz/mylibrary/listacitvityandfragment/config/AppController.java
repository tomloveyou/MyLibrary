package com.cljz.mylibrary.listacitvityandfragment.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;


import com.cljz.mylibrary.listacitvityandfragment.dbmanager.UnCaughtCrashExceptionHandler;
import com.lzy.okhttputils.OkHttpUtils;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;


/**
 * Created by lrc
 */
public class AppController extends Application {

    public static final String TAG = "AppController";
    private static AppController sInstance;
    public String mUsername = "";
    public String mUser_Token = "", mUser_id = "00";
    public String mCardid = "";
    public boolean mUser_isLogin = false;// 是否登录
    public SharedPreferences mSharedPrefs; // 为MODE_PRIVATE模式

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mSharedPrefs = getSharedPreferences(AppConfig.PRFES_NAME, Context.MODE_PRIVATE);
        initUser();
        initDb();
        initOkHttpUtils();
    }

    public static AppController getInstance() {
        if (sInstance == null) {
            sInstance = new AppController();
        }
        return sInstance;
    }

    /**
     * 初始化用户
     */
    private void initUser() {

    }

    /**
     * 初始化db
     */
    public void initDb(){
        UnCaughtCrashExceptionHandler handler = UnCaughtCrashExceptionHandler.getInstance();
        handler.init(this);
    }
    /**
     * 初始化 OkHttpUtils
     */
    private void initOkHttpUtils() {
        OkHttpUtils.init(this);
    }
}