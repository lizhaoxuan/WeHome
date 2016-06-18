package com.zhaoxuan.wehome.view.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.support.utils.StrUtils;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class WZoneHolder extends BaseRecyclerHolder<WZoneDto> {

    private TextView nameText;
    private TextView timeText;
    private TextView msgText;
    private ImageView picImg;
    private TextView commentText;
    private TextView commentNum;

    public WZoneHolder(Context context, int layoutId, ViewGroup parent, ItemClickListener itemClickListener) {
        super(LayoutInflater.from(context).inflate(layoutId, parent, false), itemClickListener);
        nameText = (TextView) view.findViewById(R.id.nameText);
        timeText = (TextView) view.findViewById(R.id.timeText);
        msgText = (TextView) view.findViewById(R.id.msgText);
        picImg = (ImageView) view.findViewById(R.id.picImg);
        commentNum = (TextView) view.findViewById(R.id.commentNum);
        commentText = (TextView) view.findViewById(R.id.commentText);
    }

    @Override
    public void updateView(WZoneDto data) {
        nameText.setText(data.getFullName());
        timeText.setText(data.getTime());
        msgText.setText(data.getMsg());
        if (StrUtils.isNullStr(data.getPicUrl())) {
            picImg.setVisibility(View.GONE);
        } else {
            picImg.setVisibility(View.VISIBLE);
            Drawable drawable = Drawable.createFromPath(data.getPicUrl());
            picImg.setImageDrawable(drawable);
        }
        if (data.getPraiseNum() != 0) {
            commentNum.setVisibility(View.VISIBLE);
            commentNum.setText(":" + data.getPraiseNum());
        } else {
            commentNum.setVisibility(View.GONE);
        }
    }
}
