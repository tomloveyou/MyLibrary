package com.cljz.mylibrary.listacitvityandfragment.okmanager;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;

import android.view.Window;

import com.cljz.mylibrary.listacitvityandfragment.widget.MakeLoading;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by lrc
 */
public abstract class OkManagerCallback extends StringCallback {

    private MakeLoading dialog;
    public OkManagerCallback(){}
    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
    }

    @Override
    public void onSuccess(String s, Call call, Response response) {

    }

    public OkManagerCallback(Context context) {
        try {
            dialog = new MakeLoading(context);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable String s, @Nullable Exception e) {
        super.onAfter(s, e);
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
