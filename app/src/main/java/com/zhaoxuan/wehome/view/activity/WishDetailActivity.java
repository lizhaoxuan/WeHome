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

import com.zhaoxuan.wehome.MyApplication;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IWishDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;

public class WishDetailActivity extends BaseActivity implements IWishDetailView {
    protected static final int CHANGE_WISH = 100;
    protected static final int ADD_WISH = 101;

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

    public static void startActivity(Activity activity,int position,WishPresenter presenter){
        Intent intent = new Intent(activity,WishDetailActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("presenter",presenter);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity,WishPresenter presenter){
        Intent intent = new Intent(activity,WishDetailActivity.class);
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
        setTitle("计划详情");
        initIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initIntent(){
        Intent intent = getIntent();
        presenter = (IWishDetailPresenter)intent.getSerializableExtra("presenter");
        int position = intent.getIntExtra("position",-1);
        presenter.setDetailView(this,position);
        if(position == -1){
            initViewForAdd();
        }else{
            presenter.initView();
        }
    }

    private void initViewForAdd(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(new Date());
        timeText.setText(time);
        String buildOf = MyApplication.getInstance().getUserDto().getName()+" | "
                + MyApplication.getInstance().getUserDto().getPost();
        buildOfText.setText(buildOf);
        statesText.setText("未完成");
        finishBtn.setVisibility(View.GONE);
        unFinsihBtn.setVisibility(View.GONE);
    }

    /***
     * View 方法
     */
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

    @Override
    public void finishActivity(boolean isChange) {
        this.finish();
    }
}
