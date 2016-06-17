package com.zhaoxuan.wehome.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.MemorialPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.utils.ViewUtils;
import com.zhaoxuan.wehome.view.adapter.MemorialListAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.List;

import butterknife.Bind;

public class MemorialActivity extends BaseViewActivity<IMemorialDayPresenter> implements IMemorialDayView {

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
        listAdapter = new MemorialListAdapter(this);
        listAdapter.setItemClickListener(new BaseRecyclerHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MemorialDayDetailActivity.startActivity(MemorialActivity.this, position, (MemorialPresenter) presenter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_memorial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.memorialAdd:
                MemorialDayDetailActivity.startActivity(this, (MemorialPresenter) presenter);
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
