package com.zhaoxuan.wehome.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;

/**
 * 设置界面属性设置item
 * Created by lizhaoxuan on 15/11/26.
 */
public class ValueSetLabel extends RelativeLayout {
    private ImageView keyIcon, valueIcon;
    private TextView keyText, valueText;

    public ValueSetLabel(Context context) {
        super(context);
        init(context, null);
    }

    public ValueSetLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ValueSetLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        LayoutInflater.from(context).inflate(R.layout.widget_value_set_label, this, true);
        keyIcon = (ImageView) findViewById(R.id.keyIcon);
        valueIcon = (ImageView) findViewById(R.id.valueIcon);
        keyText = (TextView) findViewById(R.id.keyText);
        valueText = (TextView) findViewById(R.id.valueText);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ValueSetLabel);
        CharSequence keyStr = a.getText(R.styleable.ValueSetLabel_SetValueKeyText);
        if (keyStr != null) keyText.setText(keyStr);
        Drawable keyDrawable = a.getDrawable(R.styleable.ValueSetLabel_SetValueKeyIcon);
        if (keyDrawable != null) keyIcon.setImageDrawable(keyDrawable);
        CharSequence valueStr = a.getText(R.styleable.ValueSetLabel_SetValueValueText);
        if (valueStr != null) valueText.setText(valueStr);
        Drawable valueDrawable = a.getDrawable(R.styleable.ValueSetLabel_SetValueValueIcon);
        if (valueDrawable != null) valueIcon.setImageDrawable(valueDrawable);

        a.recycle();
    }


    public String getKeyText() {
        return keyText.getText().toString();
    }

    public String getText() {
        return valueText.getText().toString();
    }

    public Drawable getKeyIcon() {
        return keyIcon.getDrawable();
    }

    public Drawable getValueIcon() {
        return valueIcon.getDrawable();
    }

    public void setKeyText(String str) {
        keyText.setText(str);
    }

    public void setText(String str) {
        valueText.setText(str);
    }
}
