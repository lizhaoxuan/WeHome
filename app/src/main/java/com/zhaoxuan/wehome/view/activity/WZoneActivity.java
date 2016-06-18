package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IWZonePresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WZonePresenter;
import com.zhaoxuan.wehome.framework.view.IWZoneView;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.view.adapter.WZoneListAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.List;

import butterknife.Bind;

public class WZoneActivity extends BaseViewActivity<IWZonePresenter> implements IWZoneView{

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private WZoneListAdapter listAdapter;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, WZoneActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzone);
    }

    protected void initView() {
        setTitle("微家社区");
        setPresenter(new WZonePresenter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new WZoneListAdapter(this);
        recyclerView.setAdapter(listAdapter);

        listAdapter.setItemClickListener(new BaseRecyclerHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                WZoneDetailActivity.startActivity(WZoneActivity.this,listAdapter.getData(position));
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_memorial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.memorialAdd:
                WZoneAddActivity.startActivity(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**------- VIEW ---------**/

    @Override
    public void initData(List<WZoneDto> dataList) {
        refreshLayout.setRefreshing(false);
        listAdapter.setDatas(dataList);
        updateData();
    }

    @Override
    public void updateData() {
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void doNoDataTip() {

    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(this, msg).show(refreshLayout);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void requestEnd() {

    }
}
