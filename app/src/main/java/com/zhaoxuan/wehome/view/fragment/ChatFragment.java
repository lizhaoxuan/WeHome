package com.zhaoxuan.wehome.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseFragment;
import com.zhaoxuan.wehome.view.activity.ChatActivity;

import butterknife.Bind;

/**
 * Created by lizhaoxuan on 15/11/24.
 */
public class ChatFragment extends BaseFragment {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    private View view;

    private ChatActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (ChatActivity)getActivity();
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Love+");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openDrawerLayout();
            }
        });
    }




}
