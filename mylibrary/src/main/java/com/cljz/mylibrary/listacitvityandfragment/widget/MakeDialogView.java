package com.cljz.mylibrary.listacitvityandfragment.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.cljz.mylibrary.R;


/**
 * Created by CLJZ on 2016/9/26.
 */
public class MakeDialogView extends Dialog implements View.OnClickListener{

    private MyDialogListener listener;
    private Context context;

    private TextView ok;
    private TextView cancel;
    private TextView dialogHint;

    public MakeDialogView(Context context) {
        super(context);
        this.context = context;
    }


    @Override
    public void onClick(View view) {
        listener.onClick(view);
    }

    public interface MyDialogListener{
        public void onClick(View view);
    }

    public MakeDialogView(Context context, int theme, MyDialogListener listener) {
        super(context,theme);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_view);
        initView();
    }
    private void initView(){
        ok = (TextView)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        cancel = (TextView)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        dialogHint = (TextView)findViewById(R.id.dialogHint);
    }
}
