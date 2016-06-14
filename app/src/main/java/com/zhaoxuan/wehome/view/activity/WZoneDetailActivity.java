package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

public class WZoneDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzone_detail);
    }

    protected void initView() {
        setTitle("评论");
    }
}
