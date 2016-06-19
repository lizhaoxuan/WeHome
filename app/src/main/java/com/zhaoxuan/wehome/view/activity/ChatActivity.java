package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.WindowManager;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.module.event.ChatRefreshEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;

import butterknife.Bind;

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
        UserManager.electricMoniter(this);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                DispenseBus.getInstance().post(new ChatRefreshEvent());
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.unRegisterElectricMoniter(this);
    }

    public void closeDrawerLayout() {
        drawerLayout.closeDrawers();
    }

    public void openDrawerLayout() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    public void setRefreshLayoutEnabled(boolean enabled) {
        if (refreshLayout != null){
            refreshLayout.setEnabled(enabled);
        }
    }

    public boolean isRefreshLayoutEnabled(){
        if (refreshLayout == null){
            return false;
        }
        return refreshLayout.isEnabled();
    }

    public void setRefreshingClose(){
        if (refreshLayout.isRefreshing()){
            refreshLayout.setRefreshing(false);
        }
    }


}
