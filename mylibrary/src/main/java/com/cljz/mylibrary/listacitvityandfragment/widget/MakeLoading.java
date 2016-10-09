package com.cljz.mylibrary.listacitvityandfragment.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cljz.mylibrary.R;


/**
 * Created by CLJZ on 2016/9/26.
 */
public class MakeLoading extends Dialog {


    private Context context;
    private TextView my_hint_tv;
    private ImageView progress_bkg_img;

    public MakeLoading(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.hint_progress);
        initView();
    }

    private void initView(){
        my_hint_tv = (TextView)findViewById(R.id.my_hint_tv);
        progress_bkg_img = (ImageView)findViewById(R.id.progress_bkg_img);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
        progress_bkg_img.startAnimation(animation);
    }

    /**
     * 设置提示信息 可不调用
     */
    public void setHintMsg(String msg) {
        my_hint_tv.setText(msg);
    }
}
