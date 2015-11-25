package com.zhaoxuan.wehome.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;

import javax.microedition.khronos.egl.EGLDisplay;

/**
 * 带图片的输入框
 * Created by lizhaoxuan on 15/11/18.
 */
public class ImageEditText extends LinearLayout {

    private ImageView imageView;
    private EditText editText;

    public ImageEditText(Context context) {
        super(context);
        initView(context, null);
    }

    public ImageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ImageEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;

        LayoutInflater.from(context).inflate(R.layout.widget_image_edit_text, this, true);
        imageView = (ImageView)findViewById(R.id.imageView);
        editText = (EditText)findViewById(R.id.editText);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageEditText);
        CharSequence text = a.getText(R.styleable.ImageEditText_android_text);
        if(text!=null) editText.setText(text);
        CharSequence hint = a.getText(R.styleable.ImageEditText_android_hint);
        if(hint!=null) editText.setHint(hint);
        Drawable drawable = a.getDrawable(R.styleable.ImageEditText_android_src);
        if(drawable != null) imageView.setImageDrawable(drawable);

        int inputType = a.getInt(R.styleable.ImageEditText_android_inputType,InputType.TYPE_CLASS_TEXT);
        editText.setInputType(inputType);

        a.recycle();
    }

    public void setText(String str){
        editText.setText(str);
    }
    public void setImageDrawable(Drawable drawable){
        imageView.setImageDrawable(drawable);
    }
    public void setHint(String str){
        editText.setHint(str);
    }
    public void setinputType(){
        editText.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }
    public String getText(){
        return editText.getText().toString();
    }

}

