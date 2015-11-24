package com.zhaoxuan.wehome.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.MyApplication;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseFragment;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.view.activity.ChatActivity;
import com.zhaoxuan.wehome.view.activity.InviteActivity;
import com.zhaoxuan.wehome.view.widget.ImageTextLabel;

import org.w3c.dom.Text;

import butterknife.Bind;

/**
 * Created by lizhaoxuan on 15/11/24.
 */
public class DrawerMenuFragment extends BaseFragment implements ImageTextLabel.OnLabelClickListener{

    @Bind(R.id.chatMenu)
    protected ImageTextLabel chatMenu;
    @Bind(R.id.memorydatMenu)
    protected ImageTextLabel memorydatMenu;
    @Bind(R.id.wishMenu)
    protected ImageTextLabel wishMenu;
    @Bind(R.id.homeMenu)
    protected ImageTextLabel homeMenu;
    @Bind(R.id.inviteMenu)
    protected ImageTextLabel inviteMenu;
    @Bind(R.id.zoneMenu)
    protected ImageTextLabel zoneMenu;
    @Bind(R.id.setMenu)
    protected ImageTextLabel setMenu;
    @Bind(R.id.headImg)
    protected ImageView headImg;
    @Bind(R.id.nameText)
    protected TextView nameText;
    @Bind(R.id.postText)
    protected TextView postText;
    @Bind(R.id.homeNameText)
    protected TextView homeNameText;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_menu, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }



    private void initView(){
        UserDto user = MyApplication.getInstance().getUserDto();
        nameText.setText(user.getName());
        postText.setText(user.getPost());
        homeNameText.setText(user.getFamilyName());


        chatMenu.setListener(this);
        memorydatMenu.setListener(this);
        wishMenu.setListener(this);
        homeMenu.setListener(this);
        inviteMenu.setListener(this);
        zoneMenu.setListener(this);
        setMenu.setListener(this);

    }



    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.chatMenu:
                ((ChatActivity)getActivity()).hideDrawerLayout();
                return;
            case R.id.memorydatMenu:
                return;
            case R.id.wishMenu:
                return;
            case R.id.homeMenu:
                return;
            case R.id.inviteMenu:
                InviteActivity.startActivity(getActivity());
                return;
            case R.id.zoneMenu:
                return;
            case R.id.setMenu:
                return;
        }
    }
}
