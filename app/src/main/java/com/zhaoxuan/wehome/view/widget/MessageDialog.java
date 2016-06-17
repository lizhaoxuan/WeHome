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

/**
 * Created by lizhaoxuan on 16/6/16.
 */
public class MessageDialog {

    private Dialog dialog;
    private TextView titleText;
    private TextView contentText;
    private Button cancelBtn, enterBtn;
    private IDialogListener listener;
    private Context context;
    private RelativeLayout dialogLayout;
    private AlertDialog.Builder builder;


    private MessageDialog(Context context, final IDialogListener listener) {
        this.context = context;
        this.listener = listener;

        LayoutInflater inflaterDl = LayoutInflater.from(context);
        dialogLayout = (RelativeLayout) inflaterDl.inflate(R.layout.dialog_msg, null);

        titleText = (TextView) dialogLayout.findViewById(R.id.titleEdit);
        cancelBtn = (Button) dialogLayout.findViewById(R.id.cancelBtn);
        enterBtn = (Button) dialogLayout.findViewById(R.id.enterBtn);
        contentText = (TextView) dialogLayout.findViewById(R.id.contentText);

        builder = new AlertDialog.Builder(context);
        builder.setView(dialogLayout);
        dialog = builder.create();


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null) {
                    listener.onCancel();
                }
            }
        });

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null) {
                    listener.onEnter();
                }
            }
        });

    }

    public static MessageDialog makeDialog(Context context, IDialogListener listener) {
        return new MessageDialog(context, listener);
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

    public void show(String title, String msg) {
        titleText.setText(title);
        contentText.setText(msg);

        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public interface IDialogListener {
        void onCancel();

        void onEnter();
    }

}
