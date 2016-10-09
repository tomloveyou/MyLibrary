package com.cljz.mylibrary.listacitvityandfragment.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lrc on 2016/9/23.
 */
public class MakePToast {

    private static Toast toast;
    private Context context;

    public MakePToast(){

    }
    public MakePToast(Context context){
        this.context = context;
    }

    public void show(String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }
    public static void showToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    public static void showOneToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content,Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
