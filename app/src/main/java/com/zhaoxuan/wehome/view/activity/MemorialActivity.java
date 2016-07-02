package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.lizhaoxuan.cakerun.CakeRun;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.impl.MemorialPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.utils.ViewUtils;
import com.zhaoxuan.wehome.view.adapter.MemorialListAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MemorialActivity extends BaseViewActivity<MemorialPresenter> implements IMemorialDayView {

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;
    @Bind(R.id.contentLayout)
    protected ViewGroup contentLayout;
    @Bind(R.id.titleLayout)
    protected ViewGroup titleLayout;
    @Bind(R.id.familyTitleText)
    protected TextView familyTitleText;
    @Bind(R.id.familyDayText)
    protected TextView familyDayText;
    @Bind(R.id.familyLabelText)
    protected TextView familyLabelText;
    @Bind(R.id.wehomeTitleText)
    protected TextView wehomeTitleText;
    @Bind(R.id.wehomeDayText)
    protected TextView wehomeDayText;
    @Bind(R.id.wehomeLabelText)
    protected TextView wehomeLabelText;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private MemorialListAdapter listAdapter;


    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, MemorialActivity.class);
//        CakeRun.getInstance().startActivity(activity,MemorialActivity.class,intent);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorial_day);
    }


    @Override
    protected void initView() {
        setTitle("纪念日");
        applyBlur();
        setPresenter(new MemorialPresenter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new MemorialListAdapter(this);
        listAdapter.setItemClickListener(new BaseRecyclerHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MemorialDetailActivity.startActivity(MemorialActivity.this, listAdapter.getData(position));
            }
        });

        refreshLayout.setRefreshing(true);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initData();
            }
        });
    }


    private void applyBlur() {
        contentLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                contentLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                contentLayout.buildDrawingCache();

                Bitmap bmp = contentLayout.getDrawingCache();
                ViewUtils.CreateBlurView(bmp, titleLayout);

                presenter.initData();
                return true;
            }
        });
    }

    @OnClick({R.id.familyTitleText, R.id.familyDayText, R.id.familyLabelText,
            R.id.wehomeTitleText, R.id.wehomeDayText, R.id.wehomeLabelText,})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.familyTitleText || id == R.id.familyDayText || id == R.id.familyLabelText) {
            MemorialDetailActivity.startActivity(MemorialActivity.this, presenter.getData(0));
        }
        if (id == R.id.wehomeTitleText || id == R.id.wehomeDayText || id == R.id.wehomeLabelText) {
            MemorialDetailActivity.startActivity(MemorialActivity.this, presenter.getData(1));
        }
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
                MemorialDetailActivity.startActivity(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * ------View ----------
     **/
    @Override
    public void initData(MemorialDto family, MemorialDto wehome, List<MemorialDto> dataList) {
        refreshLayout.setRefreshing(false);
        familyTitleText.setText(family.getFullName());
        familyDayText.setText(family.getDayStr());
        familyLabelText.setText("天");
        wehomeTitleText.setText(wehome.getFullName());
        wehomeDayText.setText(wehome.getDayStr());
        wehomeLabelText.setText("天");
        listAdapter.setDatas(dataList);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void updateData() {
        refreshLayout.setRefreshing(false);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void doNoDataTip() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void requestEnd() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(this, msg).show(recyclerView);
    }

}
