package com.zhaoxuan.wehome.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;
import com.zhaoxuan.wehome.support.utils.ViewUtils;
import com.zhaoxuan.wehome.view.adapter.MemorialListAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.List;

import butterknife.Bind;

public class MemorialDayActivity extends BaseActivity implements IMemorialDayView {

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
        applyBlur();
        listAdapter = new MemorialListAdapter(this);
    }


    private void applyBlur() {
        contentLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                contentLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                contentLayout.buildDrawingCache();

                Bitmap bmp = contentLayout.getDrawingCache();
                ViewUtils.CreateBlurView(bmp, titleLayout);
                //
                return true;
            }
        });
    }

    @Override
    public void initData(List<MemorialDayDto> topList, List<MemorialDayDto> dataList) {
        familyTitleText.setText(topList.get(0).getNameStr());
        familyDayText.setText(topList.get(0).getDayStr());
        familyLabelText.setText("天");
        wehomeTitleText.setText(topList.get(1).getNameStr());
        wehomeDayText.setText(topList.get(1).getDayStr());
        wehomeLabelText.setText("天");
        listAdapter.setDatas(dataList);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void updateData() {
        listAdapter.notifyDataSetChanged();
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
        TopToast.makeText(this, msg).showPopupWindow(recyclerView);
    }

}
