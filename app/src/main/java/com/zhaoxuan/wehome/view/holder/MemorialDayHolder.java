package com.zhaoxuan.wehome.view.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

/**
 * Created by lizhaoxuan on 16/2/24.
 */
public class MemorialDayHolder extends BaseRecyclerHolder<MemorialDayDto> {

    protected TextView titleText;
    protected TextView dayText;

    public MemorialDayHolder(Context context, int layoutId, ViewGroup parent, ItemClickListener itemClickListener) {
        super(LayoutInflater.from(context).inflate(layoutId, parent, false), itemClickListener);
        titleText = (TextView) view.findViewById(R.id.titleText);
        dayText = (TextView) view.findViewById(R.id.dayText);
    }

    @Override
    public void updateView(MemorialDayDto data) {
        titleText.setText(data.getNameStr());
        dayText.setText(data.getDayStr());
    }
}
