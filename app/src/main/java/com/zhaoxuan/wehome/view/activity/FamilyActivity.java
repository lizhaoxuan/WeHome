package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IFamilyPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.FamilyPresent;
import com.zhaoxuan.wehome.framework.view.IFamilyView;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.view.adapter.FamilyListAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.List;

import butterknife.Bind;

public class FamilyActivity extends BaseActivity implements IFamilyView{

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private FamilyListAdapter listAdapter;
    private IFamilyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
    }

    @Override
    protected void initView() {
        setTitle("我的家");
        presenter = new FamilyPresent(this);
        listAdapter = new FamilyListAdapter(this);
        presenter.initData();

        refreshLayout.setRefreshing(false);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initData();
            }
        });
    }


    /* -------- View 方法 ---------*/

    @Override
    public void init(List<FamilyDto> familyDtos) {
        refreshLayout.setRefreshing(true);
        listAdapter.setDatas(familyDtos);
        recyclerView.setAdapter(listAdapter);
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
        TopToast.makeText(this, msg).show(recyclerView);
    }


}
