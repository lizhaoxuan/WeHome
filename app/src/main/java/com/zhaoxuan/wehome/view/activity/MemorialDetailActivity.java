package com.zhaoxuan.wehome.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.ThemeManager;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.MemorialDetailPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDetailView;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

public class MemorialDetailActivity extends BaseViewActivity<IMemorialDetailPresenter> implements IMemorialDetailView {

    @Bind(R.id.titleEdit)
    protected EditText titleEdit;
    @Bind(R.id.timeText)
    protected TextView timeText;
    @Bind(R.id.loopRadio)
    protected RadioGroup loopRadio;
    @Bind(R.id.trueBtn)
    protected RadioButton trueBtn;
    @Bind(R.id.falseBtn)
    protected RadioButton falseBtn;
    @Bind(R.id.cancelBtn)
    protected Button cancelBtn;

    private boolean isLoop;
    private long memorialDate;
    private boolean isAdd = false;

    public static void startActivity(Context activity, MemorialDto dto) {
        Intent intent = new Intent(activity, MemorialDetailActivity.class);
        intent.putExtra("data", dto);
        activity.startActivity(intent);
    }

    public static void startActivity(Context activity) {
        startActivity(activity,null);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorial_day_detail);
    }

    protected void initView() {
        setTitle("纪念日详情");
        initIntent();
        loopRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == trueBtn.getId()) {
                    isLoop = true;
                } else if (checkedId == falseBtn.getId()) {
                    isLoop = false;
                }
            }
        });
    }

    private void initIntent() {
        Intent intent = getIntent();
        MemorialDto dto = (MemorialDto) intent.getSerializableExtra("data");
        setPresenter(new MemorialDetailPresenter(this,dto));
    }


    @OnClick(R.id.timeLayout)
    protected void timeClick() {
        boolean isLightTheme = ThemeManager.getInstance().getCurrentTheme() == 0;
        int date[] = presenter.getDate();

        Dialog.Builder builder = new DatePickerDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_DatePicker_Light : R.style.Material_App_Dialog_DatePicker) {
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                DatePickerDialog dialog = (DatePickerDialog) fragment.getDialog();
                memorialDate = dialog.getDate();
                String str = dialog.getYear() + "年" + dialog.getMonth() + "月" + dialog.getDay() + "日";
                timeText.setText(str);
                super.onPositiveActionClicked(fragment);
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                super.onNegativeActionClicked(fragment);
            }
        }.date(date[0], date[1], date[2]);

        builder.positiveAction("确定")
                .negativeAction("取消");
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(getSupportFragmentManager(), null);
    }

    @OnClick(R.id.enterBtn)
    protected void enterClick() {
        if (isAdd){
            UserDto user = UserManager.getInstance().getUserDto();
            presenter.addMemorialDay(user.getAccount(),user.getFullName(),
                    memorialDate,isLoop,titleEdit.getText().toString());
        }else {
            presenter.changeMemorialDay(titleEdit.getText().toString(), memorialDate, isLoop);
        }
    }

    @OnClick(R.id.cancelBtn)
    protected void cancelBtn(){
        presenter.deleteMemorialDay();
    }

    /* -----------  View 方法  -----------*/
    @Override
    public void initViewForAdd() {
        isAdd = true;
        setTitle("新增纪念日");
        cancelBtn.setVisibility(View.GONE);
    }

    @Override
    public void updateView(MemorialDto memorialDayDto) {
        titleEdit.setText(memorialDayDto.getTitle());
        timeText.setText(memorialDayDto.getDateStr());
        isLoop = memorialDayDto.isLoop();
        if (isLoop) {
            trueBtn.setSelected(true);
        } else {
            falseBtn.setSelected(true);
        }
    }

    @Override
    public void finishActivity(boolean isChange) {
        this.finish();
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
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


}
