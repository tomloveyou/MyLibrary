package com.cljz.testlibrary;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by CLJZ on 2016/10/8.
 */
public class MyAplication extends Application {
    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
