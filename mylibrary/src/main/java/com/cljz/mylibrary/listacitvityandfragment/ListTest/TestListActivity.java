package com.cljz.mylibrary.listacitvityandfragment.ListTest;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.cljz.mylibrary.R;
import com.cljz.mylibrary.listacitvityandfragment.BaseViewHolder;
import com.cljz.mylibrary.listacitvityandfragment.PullRecycler;
import com.cljz.mylibrary.listacitvityandfragment.core.BaseListActivity;
import com.cljz.mylibrary.listacitvityandfragment.layoutmanager.ILayoutManager;
import com.cljz.mylibrary.listacitvityandfragment.layoutmanager.MyLinearLayoutManager;
import com.cljz.mylibrary.listacitvityandfragment.okmanager.OkManagerCallback;
import com.cljz.mylibrary.listacitvityandfragment.util.GsonUtil;
import com.cljz.mylibrary.listacitvityandfragment.util.PicassoUtils;
import com.lzy.okhttputils.OkHttpUtils;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;



public class TestListActivity extends BaseListActivity<Test.TrailersBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycler.onRefresh();
    }

    @Override
    protected void setUpData() {
        super.setUpData();
        toolbar_title.setText("测试");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected ILayoutManager getLayoutManager() {
        return new MyLinearLayoutManager(this);
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHoleder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false));

    }

    @Override
    public void onRefresh(final int action) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }

        OkHttpUtils.post("http://api.m.mtime.cn/PageSubArea/TrailerList.api").execute(new OkManagerCallback() {
            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
            }

            @Override
            public void onSuccess(String s, Call call, Response response) {
                super.onSuccess(s, call, response);
                Test te = (Test) GsonUtil.json2Bean(s, Test.class);
                if (action == PullRecycler.ACTION_PULL_TO_REFRESH) {
                    mDataList.clear();
                }
                if (te.getTrailers() == null || te.getTrailers().size() == 0) {
                    recycler.enableLoadMore(false);
                } else {
                    recycler.enableLoadMore(true);
                    mDataList.addAll(te.getTrailers());
                    adapter.notifyDataSetChanged();
                }
                recycler.onRefreshCompleted();

            }

        });
    }


    class TestViewHoleder extends BaseViewHolder {

        TextView test1;
        ImageView test2;

        public TestViewHoleder(View itemView) {
            super(itemView);
          test1= (TextView) itemView.findViewById(R.id.test1);
            test2= (ImageView) itemView.findViewById(R.id.test2);
        }

        @Override
        public void onBindViewHolder(int position) {
            test1.setText(mDataList.get(position).getMovieName());
            PicassoUtils.loadImage(TestListActivity.this, mDataList.get(position).getCoverImg(), test2);

        }

        @Override
        public void onItemClick(View view, int position) {

        }
    }


}
