package com.zhaoxuan.wehome.framework.presenter;

import com.zhaoxuan.wehome.framework.view.IMemorialDetailView;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDetailPresenter {

    void setDetailView(IMemorialDetailView view, int detailPosition);

    void initView();

    int [] getDate();

    void changeMemorialDay(String title ,long date , boolean isLoop);

    void deleteMemorialDay();

    void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title);


}
