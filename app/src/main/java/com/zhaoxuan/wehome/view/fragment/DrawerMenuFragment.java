package com.zhaoxuan.wehome.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseFragment;
import com.zhaoxuan.wehome.framework.presenter.IMenuPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.MenuPresenter;
import com.zhaoxuan.wehome.framework.view.IMenuView;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.view.activity.ChatActivity;
import com.zhaoxuan.wehome.view.activity.InviteActivity;
import com.zhaoxuan.wehome.view.activity.MemorialDayActivity;
import com.zhaoxuan.wehome.view.activity.SetActivity;
import com.zhaoxuan.wehome.view.activity.WishActivity;
import com.zhaoxuan.wehome.view.widget.ImageTextLabel;

import butterknife.Bind;

/**
 * 侧滑菜单
 * Created by lizhaoxuan on 15/11/24.
 */
public class DrawerMenuFragment extends BaseFragment implements IMenuView, ImageTextLabel.OnLabelClickListener {

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
    @Bind(R.id.homeNameText)
    protected TextView homeNameText;

    private View view;
    private IMenuPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MenuPresenter(this);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        //刷新界面
        presenter.updateView();
    }

    private void initView() {
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
        switch (viewId) {
            case R.id.chatMenu:
                ((ChatActivity) getActivity()).closeDrawerLayout();
                return;
            case R.id.memorydatMenu:
                startActivity(new Intent(getActivity(), MemorialDayActivity.class));
                return;
            case R.id.wishMenu:
                WishActivity.startActivity(getActivity());
                return;
            case R.id.homeMenu:
                return;
            case R.id.inviteMenu:
                InviteActivity.startActivity(getActivity());
                return;
            case R.id.zoneMenu:
                return;
            case R.id.setMenu:
                SetActivity.startActivity(activity);
                return;
            default:
        }
    }

    @Override
    public void setUserData(UserDto userDto) {
        if (!userDto.getHeadImageUri().equals("")) {
            Bitmap bitmap = BitmapFactory.decodeFile(userDto.getHeadImageUri());
            headImg.setImageBitmap(bitmap);
        }
        nameText.setText(userDto.getName());
        homeNameText.setText(userDto.getHomeName());
    }
}
