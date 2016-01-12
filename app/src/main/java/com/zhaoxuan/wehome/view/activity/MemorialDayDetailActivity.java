package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.ThemeManager;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.OnClick;

public class MemorialDayDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorial_day_detail);
    }

    @Override
    protected void initView() {

    }

    protected void onClick() {
        boolean isLightTheme = ThemeManager.getInstance().getCurrentTheme() == 0;

        Dialog.Builder builder = new DatePickerDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_DatePicker_Light : R.style.Material_App_Dialog_DatePicker) {
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                DatePickerDialog dialog = (DatePickerDialog) fragment.getDialog();
                String date = dialog.getFormattedDate(SimpleDateFormat.getDateInstance());
                Toast.makeText(MemorialDayDetailActivity.this,
                        "Date is " + date, Toast.LENGTH_SHORT).show();
                super.onPositiveActionClicked(fragment);
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                Toast.makeText(MemorialDayDetailActivity.this,
                        "Cancelled", Toast.LENGTH_SHORT).show();
                super.onNegativeActionClicked(fragment);
            }
        }.date(8,18,1993);


        builder.positiveAction("OK")
                .negativeAction("CANCEL");
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(getSupportFragmentManager(), null);
    }
}
