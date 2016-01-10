package com.zhaoxuan.wehome.view.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.utils.ViewUtils;

import butterknife.Bind;

public class MemorialDayActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorial_day);
    }


    @Override
    protected void initView() {
        applyBlur();
    }

    private void updateView() {
        familyTitleText.setText("我们的家已经：");
        familyDayText.setText("125");
        familyLabelText.setText("天");
        wehomeTitleText.setText("微家创建已经");
        wehomeDayText.setText("56");
        wehomeLabelText.setText("天");
    }

    private void applyBlur() {
        contentLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                contentLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                contentLayout.buildDrawingCache();

                Bitmap bmp = contentLayout.getDrawingCache();
                ViewUtils.CreateBlurView(bmp, titleLayout);
                updateView();
                return true;
            }
        });
    }



}
