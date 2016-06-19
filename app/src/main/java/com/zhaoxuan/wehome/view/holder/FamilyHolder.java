package com.zhaoxuan.wehome.view.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class FamilyHolder extends BaseRecyclerHolder<FamilyDto> {

    protected ImageView headImg;
    protected ImageView electricImg;
    protected TextView nameText;
    protected TextView cityText;
    protected TextView weatherText;

    public FamilyHolder(Context context, int layoutId, ViewGroup parent, ItemClickListener itemClickListener) {
        super(LayoutInflater.from(context).inflate(layoutId, parent, false), itemClickListener);
        headImg = (ImageView) view.findViewById(R.id.headImg);
        electricImg = (ImageView) view.findViewById(R.id.electricImg);
        nameText = (TextView) view.findViewById(R.id.nameText);
        cityText = (TextView) view.findViewById(R.id.cityText);
        weatherText = (TextView) view.findViewById(R.id.weatherText);
    }

    @Override
    public void updateView(FamilyDto data) {
        nameText.setText(data.getFullName());
        cityText.setText(data.getCity());
        weatherText.setText(data.getWeather());
    }



}
