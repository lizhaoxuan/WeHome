package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import butterknife.Bind;

public class WZoneActivity extends BaseActivity {

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzone);
    }

    @Override
    protected void initView() {
        setTitle("社区");
    }
}
