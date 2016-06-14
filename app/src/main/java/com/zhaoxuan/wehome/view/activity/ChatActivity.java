package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatActivity extends BaseActivity {
    @Bind(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;
    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;


    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, ChatActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public void closeDrawerLayout() {
        drawerLayout.closeDrawers();
    }

    public void openDrawerLayout() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
