package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.view.IFamilyView;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

import butterknife.Bind;

public class FamilyActivity extends BaseActivity implements IFamilyView{

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


    }

    @Override
    protected void initView() {
        setTitle("我的家");
    }


    /* -------- View 方法 ---------*/

    @Override
    public void init(List<FamilyDto> familyDtos) {

    }

    @Override
    public void doNoDataTip() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showToast(String msg) {

    }


}
