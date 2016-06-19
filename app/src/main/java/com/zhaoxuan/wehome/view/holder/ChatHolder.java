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
import com.zhaoxuan.wehome.support.dto.ChatDto;
import com.zhaoxuan.wehome.support.utils.StrUtils;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class ChatHolder extends BaseRecyclerHolder<ChatDto> {

    protected ImageView headImg;
    protected ImageView chatImg;
    protected TextView nameText;
    protected TextView timeText;
    protected TextView contentText;

    public ChatHolder(Context context, int layoutId, ViewGroup parent, ItemClickListener itemClickListener) {
        super(LayoutInflater.from(context).inflate(layoutId, parent, false), itemClickListener);
        headImg = (ImageView) view.findViewById(R.id.headImg);
        chatImg = (ImageView) view.findViewById(R.id.chatImg);
        nameText = (TextView) view.findViewById(R.id.nameText);
        timeText = (TextView) view.findViewById(R.id.timeText);
        contentText = (TextView) view.findViewById(R.id.contentText);
    }

    @Override
    public void updateView(ChatDto data) {
        if (!StrUtils.isNullStr(data.getPicPath())){
            Drawable drawable = Drawable.createFromPath(data.getPicPath());
            headImg.setImageDrawable(drawable);
        }
        nameText.setText(data.getBuildOf());
        timeText.setText(data.getTime());
        contentText.setText(data.getContent());
        if (!StrUtils.isNullStr(data.getPicPath())){
            Drawable drawable = Drawable.createFromPath(data.getPicPath());
            chatImg.setVisibility(View.VISIBLE);
            chatImg.setImageDrawable(drawable);
        }else {
            chatImg.setVisibility(View.GONE);
        }
    }

}
