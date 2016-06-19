package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IChatAddPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.ChatPresenter;
import com.zhaoxuan.wehome.framework.view.IChatAddView;
import com.zhaoxuan.wehome.support.utils.SoftInputManager;

import butterknife.Bind;
import butterknife.OnClick;

public class ChatAddActivity extends BaseViewActivity<IChatAddPresenter> implements IChatAddView {
    protected static final int RESULT_LOAD_IMAGE = 1;

    @Bind(R.id.timeText)
    protected TextView timeText;
    @Bind(R.id.buildOfText)
    protected TextView buildOfText;
    @Bind(R.id.contentEdit)
    protected EditText contentEdit;
    @Bind(R.id.addImg)
    protected TextView addImg;
    @Bind(R.id.chatImg)
    protected ImageView chatImg;
    @Bind(R.id.addBtn)
    protected Button addBtn;

    private String picPath="";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, ChatAddActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_add);
    }


    @Override
    protected void initView() {
        setTitle("新建");
        setPresenter(new ChatPresenter(this));

    }

    @OnClick(R.id.addBtn)
    protected void addBtnClick(){
        presenter.addChat(contentEdit.getText().toString(),picPath);
    }

    @OnClick(R.id.addImg)
    protected void addImgClick(){
        addImg.setVisibility(View.GONE);
        Intent i=new Intent(Intent.ACTION_PICK , android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picPath = cursor.getString(columnIndex);
            cursor.close();
            Drawable drawable = Drawable.createFromPath(picPath);
            chatImg.setVisibility(View.VISIBLE);
            chatImg.setImageDrawable(drawable);
        }
    }

    /**
     * ------------- VIEW -----------
     **/
    @Override
    public void initView(String buildOf, String time) {
        timeText.setText(time);
        buildOfText.setText(buildOf);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void clearView() {
        contentEdit.setText("");
        SoftInputManager.hideSoftInput(this);
    }

    @Override
    public void requestEnd() {

    }
}
