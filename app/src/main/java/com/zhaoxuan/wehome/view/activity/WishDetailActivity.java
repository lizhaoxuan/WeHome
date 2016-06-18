package com.zhaoxuan.wehome.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.impl.WishDetailPresenter;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.WishDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

public class WishDetailActivity extends BaseViewActivity<WishDetailPresenter> implements IWishDetailView {
    protected static final int RESULT_LOAD_IMAGE = 1;


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
    @Bind(R.id.deleteBtn)
    protected Button deleteBtn;
    @Bind(R.id.addBtn)
    protected Button addBtn;
    @Bind(R.id.changeBtn)
    protected Button changeBtn;

    public static void startActivity(Context activity, WishDto dto) {
        Intent intent = new Intent(activity, WishDetailActivity.class);
        intent.putExtra("data", dto);
        activity.startActivity(intent);
    }

    public static void startActivity(Context activity) {
        startActivity(activity, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);

    }

    protected void initView() {
        setTitle("计划详情");
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        WishDto wishDto = (WishDto) intent.getSerializableExtra("data");
        setPresenter(new WishDetailPresenter(this, wishDto));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            presenter.changeWishImg(picturePath);
        }
    }

    @OnClick(R.id.wishImg)
    protected void wishImgClick() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @OnClick(R.id.finishBtn)
    protected void finishBtnClick() {
        presenter.changeFinish(true);
    }

    @OnClick(R.id.unFinishBtn)
    protected void unFinishBtnClick() {
        presenter.changeFinish(false);
    }

    @OnClick(R.id.changeBtn)
    protected void changeBtnClick() {
        presenter.changeWish(titleEdit.getText().toString(), contentEdit.getText().toString());
    }

    @OnClick(R.id.addBtn)
    protected void addBtnClick() {
        presenter.addWish(DateUtil.getDefaultDate(new Date()),
                titleEdit.getText().toString(), contentEdit.getText().toString());
    }

    @OnClick(R.id.deleteBtn)
    protected void deleteBtnClick() {
        presenter.deleteWish();
    }

    /* ----- View 方法 ------ */
    @Override
    public void updateView(WishDto wishDto) {
        Log.d("TAG", "updateView" + wishDto.getImgUrl());
        if (!StrUtils.isNullStr(wishDto.getImgUrl())) {
            Bitmap bitmap = BitmapFactory.decodeFile(wishDto.getImgUrl());
            wishImg.setImageBitmap(bitmap);
        }
        timeText.setText(wishDto.getTime());
        buildOfText.setText(wishDto.getFullName());
        statesText.setText(wishDto.getFinsih());
        titleEdit.setText(wishDto.getTitle());
        contentEdit.setText(wishDto.getWishContent());
        updateFinishBtn(wishDto.isFinish());
        addBtn.setVisibility(View.GONE);
    }

    @Override
    public void initViewForAdd() {
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();
        String time = dateFormat.format(new Date());
        timeText.setText(time);
        String buildOf = UserManager.getInstance().getUserDto().getName() + " | "
                + UserManager.getInstance().getUserDto().getPost();
        buildOfText.setText(buildOf);
        statesText.setText("未完成");
        finishBtn.setVisibility(View.GONE);
        unFinsihBtn.setVisibility(View.GONE);
        deleteBtn.setVisibility(View.GONE);
        changeBtn.setVisibility(View.GONE);
    }

    @Override
    public void updateImg(Bitmap bitmap) {
        if (bitmap != null) {
            wishImg.setImageBitmap(bitmap);
        }
    }

    @Override
    public void updateFinishBtn(boolean isFinish) {
        if (isFinish) {
            finishBtn.setVisibility(View.GONE);
            unFinsihBtn.setVisibility(View.VISIBLE);
        } else {
            finishBtn.setVisibility(View.VISIBLE);
            unFinsihBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void finishActivity() {
        this.finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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
