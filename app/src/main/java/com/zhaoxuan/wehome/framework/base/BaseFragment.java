package com.zhaoxuan.wehome.framework.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 15/11/24.
 */
public class BaseFragment extends Fragment {

    protected Activity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this.getActivity();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }
}
