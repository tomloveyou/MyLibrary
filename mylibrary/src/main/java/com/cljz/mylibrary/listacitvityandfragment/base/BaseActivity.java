package com.cljz.mylibrary.listacitvityandfragment.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lrc
 * 所有activity须继承此类
 */
public class BaseActivity extends FragmentActivity {

    private static final String BASE_TAG = "BaseActivity";
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加当前打开的Activity到列表里面
        AppManager.getAppManager().addActivity(this);
        Log.d(BASE_TAG, "启动并添加了Activity：" + TAG);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从列表移除当前关闭的Activity
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 在ActionBarActivity中，如果设置窗口主题为全屏无标题栏，则需要禁止menu键，否则程序报错崩溃
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            Log.v(BASE_TAG, "默认已禁止系统menu键按下");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
