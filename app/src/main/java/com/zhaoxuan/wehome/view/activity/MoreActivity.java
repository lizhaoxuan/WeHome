package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import butterknife.Bind;

public class MoreActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.anniversaryLayout)
    protected RelativeLayout anniversaryLayout;
    @Bind(R.id.wishLayout)
    protected RelativeLayout wishLayout;
    @Bind(R.id.familyLayout)
    protected RelativeLayout familyLayout;
    @Bind(R.id.inviteLayout)
    protected RelativeLayout inviteLayout;
    @Bind(R.id.zoneLayout)
    protected RelativeLayout zoneLayout;


    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


    }

    @Override
    protected void initView() {
        actionBar.setTitle("更多");
        anniversaryLayout.setOnClickListener(this);
        wishLayout.setOnClickListener(this);
        familyLayout.setOnClickListener(this);
        inviteLayout.setOnClickListener(this);
        zoneLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.anniversaryLayout:
                return;
            case R.id.wishLayout:
                return;
            case R.id.familyLayout:
                return;
            case R.id.inviteLayout:
                InviteActivity.startActivity(this);
                return;
            case R.id.zoneLayout:
                return;
            default:
                return;
        }
    }

}
