package com.zhaoxuan.wehome.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IWZoneAddPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WZonePresenter;
import com.zhaoxuan.wehome.framework.view.IWZoneAddView;
import com.zhaoxuan.wehome.support.dto.WZoneDto;

import butterknife.Bind;
import butterknife.OnClick;

public class WZoneAddActivity extends BaseViewActivity<IWZoneAddPresenter> implements IWZoneAddView {
    protected static final int RESULT_LOAD_IMAGE = 1;

    @Bind(R.id.wzoneImg)
    protected ImageView wzoneImg;
    @Bind(R.id.timeText)
    protected TextView timeText;
    @Bind(R.id.buildOfText)
    protected TextView buildOfText;
    @Bind(R.id.contentEdit)
    protected EditText contentEdit;

    private String picPath = "";

    public static void startActivity(Context activity) {
        Intent intent = new Intent(activity, WZoneAddActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzone_add);
    }

    @Override
    protected void initView() {
        setTitle("新建");
        setPresenter(new WZonePresenter(this));
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
            picPath = cursor.getString(columnIndex);
            cursor.close();
            Drawable drawable = Drawable.createFromPath(picPath);
            wzoneImg.setImageDrawable(drawable);
        }
    }

    @OnClick(R.id.wzoneImg)
    public void wzoneImgClick(){
        Intent i=new Intent(Intent.ACTION_PICK , android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @OnClick(R.id.addBtn)
    public void addBtnClick(){
        presenter.addData(picPath,contentEdit.getText().toString());
    }

    /**
     * --------View ---------
     **/

    @Override
    public void updateView(String buildOf, String time) {
        buildOfText.setText(buildOf);
        timeText.setText(time);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void requestEnd() {

    }
}
