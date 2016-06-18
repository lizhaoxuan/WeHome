package com.zhaoxuan.wehome.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IWZoneDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WZonePresenter;
import com.zhaoxuan.wehome.framework.view.IWZoneDetailView;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.support.utils.SoftInputManager;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class WZoneDetailActivity extends BaseViewActivity<IWZoneDetailPresenter> implements IWZoneDetailView {

    @Bind(R.id.listView)
    protected ListView listView;
    @Bind(R.id.commentEdit)
    protected EditText commentEdit;
    @Bind(R.id.sendBtn)
    protected Button sendBtn;
    @Bind(R.id.nameText)
    protected TextView nameText;
    @Bind(R.id.timeText)
    protected TextView timeText;
    @Bind(R.id.msgText)
    protected TextView msgText;
    @Bind(R.id.picImg)
    protected ImageView picImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzone_detail);
    }

    public static void startActivity(Context activity, WZoneDto dto) {
        Intent intent = new Intent(activity, WZoneDetailActivity.class);
        intent.putExtra("data", dto);
        activity.startActivity(intent);
    }

    protected void initView() {
        setTitle("评论");
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        WZoneDto wZoneDto = (WZoneDto) intent.getSerializableExtra("data");
        setPresenter(new WZonePresenter(this, wZoneDto));
    }

    @OnClick(R.id.sendBtn)
    protected void sendBtnClick() {
        String praise = commentEdit.getText().toString();
        presenter.addPraise(praise);
    }

    /**
     * ------- VIEW ---------
     */
    @Override
    public void updateView(WZoneDto data) {
        nameText.setText(data.getFullName());
        timeText.setText(data.getTime());
        msgText.setText(data.getMsg());
        if (StrUtils.isNullStr(data.getPicUrl())) {
            picImg.setVisibility(View.GONE);
        } else {
            picImg.setVisibility(View.VISIBLE);
            Drawable drawable = Drawable.createFromPath(data.getPicUrl());
            picImg.setImageDrawable(drawable);
        }
        if (data.getPraiseNum() != 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_praise,
                    data.getPraiseArray());
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void clearEdit() {
        commentEdit.setText("");
        SoftInputManager.hideSoftInput(this);
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

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
