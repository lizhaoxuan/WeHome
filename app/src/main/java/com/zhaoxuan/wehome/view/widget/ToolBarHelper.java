package com.zhaoxuan.wehome.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zhaoxuan.wehome.R;

/**
 * Created by lizhaoxuan on 15/12/1.
 */
public class ToolBarHelper {

    /*上下文，创建view的时候需要用到*/
    private Context context;

    /*base view*/
    private FrameLayout contentView;

    /*用户定义的view*/
    private View userView;

    /*toolbar*/
    private Toolbar toolBar;

    /*视图构造器*/
    private LayoutInflater inflater;

    /*
    * 两个属性
    * 1、toolbar是否悬浮在窗口之上
    * 2、toolbar的高度获取
    * */
    private static int[] ATTRS = {
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };

    public ToolBarHelper(Context context, int layoutId) {
        this.context = context;
        inflater = LayoutInflater.from(this.context);
        /*初始化整个内容*/
        initContentView();
        /*初始化用户定义的布局*/
        initUserView(layoutId);
        /*初始化toolbar*/
        initToolBar();
    }

    private void initContentView() {
        /*直接创建一个帧布局，作为视图容器的父容器*/
        contentView = new FrameLayout(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(params);

    }

    private void initToolBar() {
        /*通过inflater获取toolbar的布局文件*/
        View toolbar = inflater.inflate(R.layout.widget_toolbar, contentView);
        toolBar = (Toolbar) toolbar.findViewById(R.id.id_tool_bar);
    }

    private void initUserView(int id) {
        userView = inflater.inflate(id, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0, false);
        /*获取主题中定义的toolbar的高度*/
        int toolBarSize = (int) typedArray.getDimension(1,(int) context.getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态，则不需要设置间距*/
        params.topMargin = overly ? 0 : toolBarSize;
        contentView.addView(userView, params);

    }

    public FrameLayout getContentView() {
        return contentView;
    }

    public Toolbar getToolBar() {
        return toolBar;
    }

}
