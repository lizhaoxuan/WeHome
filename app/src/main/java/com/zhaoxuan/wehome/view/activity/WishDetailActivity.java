package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IWishDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWishPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.support.dto.WishDto;

import butterknife.Bind;

public class WishDetailActivity extends BaseActivity,IWishDetailView {
    @Bind(R.id.wishImg)
    protected ImageView wishImg;
    @Bind(R.id.timeText)
    protected TextView timeText;
    @Bind(R.id.buildOfText)
    protected TextView buildOfText;
    @Bind(R.id.statesText)
    protected TextView statesText;
    @Bind(R.id.titleEdit)
    protected EditText titleEdit;
    @Bind(R.id.contentEdit)
    protected EditText contentEdit;
    @Bind(R.id.unFinishBtn)
    protected Button unFinsihBtn;
    @Bind(R.id.finishBtn)
    protected Button finishBtn;

    private IWishDetailPresenter presenter;

    public static void startActivity(Activity activity,int itemId,WishPresenter presenter){
        Intent intent = new Intent(activity,WishDetailActivity.class);
        intent.putExtra("itemId",itemId);
        intent.putExtra("presenter",presenter);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);


    }

    @Override
    protected void initView() {
        actionBar.setTitle("计划详情");
        initIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initIntent(){
        Intent intent = getIntent();
        presenter = (IWishDetailPresenter)intent.getSerializableExtra("presenter");
        presenter.setDetailView(this);
        //presenter.initView(intent.getIntExtra());
    }


    @Override
    public void updateView(String time, String buildOF, String isFinishStr, boolean isFinish, String title, String content) {
        timeText.setText(time);
        buildOfText.setText(buildOF);
        statesText.setText(isFinishStr);
        titleEdit.setText(title);
        contentEdit.setText(content);
        updateFinishBtn(isFinish);

    }

    @Override
    public void updateImg(Drawable drawable) {
        if(drawable!=null){
            wishImg.setImageDrawable(drawable);
        }
    }

    @Override
    public void updateFinishBtn(boolean isFinish) {
        if (isFinish){
            finishBtn.setVisibility(View.GONE);
            unFinsihBtn.setVisibility(View.VISIBLE);
        }else {
            finishBtn.setVisibility(View.VISIBLE);
            unFinsihBtn.setVisibility(View.GONE);
        }
    }
}
