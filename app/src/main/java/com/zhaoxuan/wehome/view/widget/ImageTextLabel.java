package com.zhaoxuan.wehome.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;

/**
 * 侧滑菜单的item，图片加文字
 * Created by lizhaoxuan on 15/11/24.
 */
public class ImageTextLabel extends LinearLayout implements View.OnClickListener{

    private ImageView imageView;
    private TextView textView;
    private OnLabelClickListener listener;

    public ImageTextLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public ImageTextLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ImageTextLabel(Context context) {
        super(context);
        initView(context,null);
    }

    private void initView(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;

        this.setOnClickListener(this);

        LayoutInflater.from(context).inflate(R.layout.widget_image_text_label, this, true);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageTextLabel);
        CharSequence text = a.getText(R.styleable.ImageTextLabel_android_text);
        if(text!=null) textView.setText(text);
        Drawable drawable = a.getDrawable(R.styleable.ImageTextLabel_android_src);
        if(drawable != null) imageView.setImageDrawable(drawable);

        a.recycle();
    }

    public void setText(String text){
        textView.setText(text);
    }
    public void setImage(Drawable drawable){
        imageView.setImageDrawable(drawable);
    }

    public void setListener(OnLabelClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public interface OnLabelClickListener{
        void onClick(View v);
    }

}
