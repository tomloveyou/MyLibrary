package com.cljz.mylibrary.listacitvityandfragment.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;



import butterknife.ButterKnife;

/**
 * Created by Stay on 22/10/15.
 * Powered by www.stay4it.com
 */
public class BaseFragmentRe extends Fragment {
    public Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
