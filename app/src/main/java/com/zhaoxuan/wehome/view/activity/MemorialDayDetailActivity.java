package com.zhaoxuan.wehome.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.ThemeManager;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.MemorialDayPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayDetailView;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class MemorialDayDetailActivity extends BaseViewActivity<IMemorialDayDetailPresenter> implements IMemorialDayDetailView {

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

    private boolean isLoop;
    private long memorialDate;

    public static void startActivity(Context activity, int position, MemorialDayPresenter presenter) {
        Intent intent = new Intent(activity, MemorialDayDetailActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("presenter", presenter);
        activity.startActivity(intent);
    }

    public static void startActivity(Context activity, MemorialDayPresenter presenter) {
        startActivity(activity, -1, presenter);
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
        presenter = (IMemorialDayDetailPresenter) intent.getSerializableExtra("presenter");
        int position = intent.getIntExtra("position", -1);
        presenter.setDetailView(this, position);
        if (position == -1) {
            initViewForAdd();
        } else {
            presenter.initView();
        }
    }

    private void initViewForAdd() {
        setTitle("纪念日详情");
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
        presenter.changeMemorialDay(titleEdit.getText().toString(), memorialDate, isLoop);
    }

    /* -----------  View 方法  -----------*/
    @Override
    public void updateView(MemorialDayDto memorialDayDto) {
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
        TopToast.makeText(this, msg).show(titleEdit);
    }


}
