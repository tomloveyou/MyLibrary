package com.cljz.mylibrary.listacitvityandfragment.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by lrc
 */
public class VerCodeUitl {

    /**
     * 版本号
     * @param context
     * @return
     */
    public static int getVerCode(Context context) {
        int verCode = -1;
            PackageManager manager = context.getPackageManager();
            try {
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                verCode = info.versionCode;
            } catch (Exception e) {
                // TODO Auto-generated catch blockd
                e.printStackTrace();
            }
        return verCode;
    }

    /**
     * 版本名
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String appVersion = null ;
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionName;
        } catch (Exception e) {
            // TODO Auto-generated catch blockd
            e.printStackTrace();
        }
        return appVersion;
    }
}
