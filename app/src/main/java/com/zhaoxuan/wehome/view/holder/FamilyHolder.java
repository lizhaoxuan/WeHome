package com.zhaoxuan.wehome.view.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.utils.StrUtils;

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
        String headPath = data.getHeadPath();
        if (!StrUtils.isNullStr(headPath)) {
            if (StrUtils.isNumeric(headPath)) {
                headImg.setImageResource(Integer.valueOf(headPath));
            } else {
                headImg.setImageDrawable(Drawable.createFromPath(headPath));
            }
        }
        nameText.setText(data.getFullName());
        cityText.setText(data.getCity());
        weatherText.setText(data.getWeather());
        int electric = data.getElectric();
        if (electric<=10){
            electricImg.setImageResource(R.drawable.ico_battery_0);
        }else if (electric>10 && electric<30){
            electricImg.setImageResource(R.drawable.ico_battery_1);
        }else if (electric>30 && electric<60){
            electricImg.setImageResource(R.drawable.ico_battery_2);
        }else if (electric>60 && electric<80){
            electricImg.setImageResource(R.drawable.ico_battery_3);
        }else if (electric>80 && electric<=100){
            electricImg.setImageResource(R.drawable.ico_battery_4);
        }
    }


}
