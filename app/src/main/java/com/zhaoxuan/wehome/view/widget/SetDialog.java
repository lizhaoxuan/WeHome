package com.zhaoxuan.wehome.view.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * 设置界面 修改属性Dialog
 * Created by lizhaoxuan on 15/11/27.
 */
public class SetDialog {

    private Dialog dialog;
    private TextView titleText;
    private ImageEditText oneEdit, twoEdit, threeEdit;
    private Button cancelBtn, changeBtn;
    private ISetDialogListener listener;
    private AlertDialog.Builder builder;
    private RelativeLayout dialogLayout;
    private Context context;

    private SetDialog(Context context, final ISetDialogListener listener) {
        this.context = context;
        this.listener = listener;
        LayoutInflater inflaterDl = LayoutInflater.from(context);
        dialogLayout = (RelativeLayout) inflaterDl.inflate(R.layout.dialog_set, null);
        oneEdit = (ImageEditText) dialogLayout.findViewById(R.id.oneEdit);
        twoEdit = (ImageEditText) dialogLayout.findViewById(R.id.twoEdit);
        threeEdit = (ImageEditText) dialogLayout.findViewById(R.id.threeEdit);
        cancelBtn = (Button) dialogLayout.findViewById(R.id.cancelBtn);
        changeBtn = (Button) dialogLayout.findViewById(R.id.changeBtn);
        titleText = (TextView) dialogLayout.findViewById(R.id.titleText);

        builder = new AlertDialog.Builder(context);
        builder.setView(dialogLayout);
        dialog = builder.create();


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public static SetDialog makeDialog(Context context, ISetDialogListener listener) {
        return new SetDialog(context, listener);
    }

    public boolean isShowing() {
        if (dialog != null && dialog.isShowing()) {
            return true;
        } else {
            return false;
        }
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void show(final int type, String title, String value) {
        titleText.setText(title);
        if (type == UserDto.KEY_PASSWORD) {
            oneEdit.setHint("请输入旧密码");
            twoEdit.setHint("请输入新密码");
            threeEdit.setHint("请再次输入新密码");
            twoEdit.setVisibility(View.VISIBLE);
            threeEdit.setVisibility(View.VISIBLE);
            changeBtn.setVisibility(View.VISIBLE);
            changeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.enterClick(type, oneEdit.getText(), twoEdit.getText(),
                            threeEdit.getText());
                }
            });
        } else if (type == UserDto.KEY_HOME_ID || type == UserDto.KEY_ACCOUNT) {
            oneEdit.setText(value);
            twoEdit.setVisibility(View.INVISIBLE);
            threeEdit.setVisibility(View.INVISIBLE);
            changeBtn.setVisibility(View.GONE);
        } else {
            oneEdit.setHint(value);
            changeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.enterClick(type, oneEdit.getText(),oneEdit.getHint());
                }
            });
        }
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


    }

    public interface ISetDialogListener {
        void enterClick(int key, String args1, String args2, String args3);

        void enterClick(int key, String textStr, String hintStr);
    }
}
