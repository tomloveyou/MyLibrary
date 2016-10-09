package com.cljz.mylibrary.listacitvityandfragment.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;


import com.cljz.mylibrary.R;
import com.cljz.mylibrary.listacitvityandfragment.widget.MakePToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by lrc
 */
public class Utils {

    /**
     * 验证手机号
     * */
    public static boolean checkPhone(String phoneNumber) {
//	    Pattern p = Pattern.compile("^1[34578]{1}\\d{9}$");
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    /**
     * 过滤特殊字符*
     * */
    public static boolean StringFilter(String str) {
        // String regEx = "[~!@#$%^&*<>?]";
        String regEx = "\\W";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return false;
        }
        return true;
    }

    /**
     * 验证密码
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        Pattern p = Pattern.compile("/^[_0-9a-zA-Z]{6,16}$/i");
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

    /**
     * 判断网络是否连接
     */
    public static boolean IsConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * 时间戳转日期
     */
    public static String timeConvert(long mill) {
        Date date = new Date(mill * 1000L);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    /**
     * 判断是否联网
     */
    public static boolean noteIntent(Context context) {
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = con.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isAvailable()) {
            MakePToast.showToast(context,context.getString(R.string.judeg_networking_msg));
            return false;
        }
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        if (!wifi) {
 //           MakePToast.showToast(context,context.getString(R.string.judeg_notwifi_show));
        }
        return true;
    }

    /**
     * 检测Sdcard是否存在
     *
     * @return
     */
    public static boolean isExitsSdcard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }

    /**
     * 验证验证码格式
     */
    public boolean checkIdentifyCode(String pw) {
        Pattern p = Pattern.compile("^[0-9]{4}$");
        Matcher m = p.matcher(pw);
        return m.matches();
    }

    public static boolean isDownloadManagerAvailable(Context context) {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setClassName("com.android.providers.downloads.ui", "com.android.providers.downloads.ui.DownloadList");
            List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 校验身份证
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches("(^\\d{18}$)|(^\\d{15}$)", idCard);
    }

    /**
     * 校验邮箱
     */
    public static boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);
    }

    public static boolean isString(String s){
        return TextUtils.isEmpty(s);
    }

    /**
    * 生成32位编码
    */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().trim();
        return uuid;
    }

    /**
     * 反转
     */
    public static String getReverse(String s){
        StringBuffer sb=new StringBuffer(s);
        sb = sb.reverse();
        return sb.toString();
    }
}
