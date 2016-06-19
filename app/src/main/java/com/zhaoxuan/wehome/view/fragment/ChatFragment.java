package com.zhaoxuan.wehome.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseFragment;
import com.zhaoxuan.wehome.framework.presenter.impl.ChatPresenter;
import com.zhaoxuan.wehome.framework.view.IChatView;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.ChatDto;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.view.activity.ChatActivity;
import com.zhaoxuan.wehome.view.activity.ChatAddActivity;
import com.zhaoxuan.wehome.view.adapter.ChatListAdapter;
import com.zhaoxuan.wehome.view.adapter.MemorialListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by lizhaoxuan on 15/11/24.
 */
public class ChatFragment extends BaseFragment implements IChatView {
    protected static final int RESULT_LOAD_IMAGE = 1;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.backdrop)
    protected ImageView backdrop;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private View view;
    private long backdropClickTime;

    private ChatActivity activity;
    private ChatPresenter presenter;
    private ChatListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ChatPresenter(this);
        DispenseBus.getInstance().register(presenter);
        activity = (ChatActivity) getActivity();
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ico_action_menu);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(UserManager.getInstance().getUserDto().getHomeName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openDrawerLayout();
            }
        });

        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isEnabled = activity.isRefreshLayoutEnabled();

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0 && !isEnabled) {
                    activity.setRefreshLayoutEnabled(true);
                    isEnabled = activity.isRefreshLayoutEnabled();
                } else if (verticalOffset != 0 && isEnabled) {
                    activity.setRefreshLayoutEnabled(false);
                    isEnabled = activity.isRefreshLayoutEnabled();
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAdapter = new ChatListAdapter(getActivity());

    }

    @OnClick(R.id.backdrop)
    public void backdropClick() {
        long time = System.currentTimeMillis();
        if (time - backdropClickTime > 1500) {
            backdropClickTime = time;
            Toast.makeText(getActivity(), "再次点击可设置全家福照片~", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_LOAD_IMAGE);
        }
    }

    @OnClick(R.id.addBtn)
    public void addBtnClick(){
        ChatAddActivity.startActivity(getActivity());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            presenter.changeFamilyPhoto(picturePath);
        }
    }

    /**
     * ---------- VIEW -----------
     **/

    @Override
    public void updateView(List<ChatDto> chatDtos) {
        listAdapter.setDatas(chatDtos);
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void updatePhoto(Drawable drawable) {
        if (drawable != null) {
            backdrop.setImageDrawable(drawable);
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void requestEnd() {
        activity.setRefreshingClose();
    }

    @Override
    public void doNoDataTip() {

    }
}
