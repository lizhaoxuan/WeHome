package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import butterknife.Bind;

public class FamilyActivity extends BaseActivity {

    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


    }

    @Override
    protected void initView() {

    }
}
