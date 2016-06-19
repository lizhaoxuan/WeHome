package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.ChatDto;
import com.zhaoxuan.wehome.view.holder.ChatHolder;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class ChatListAdapter extends BaseAdapter<ChatDto> {

    public ChatListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<ChatDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatHolder(context, R.layout.item_chat, parent, itemClickListener);
    }

}
