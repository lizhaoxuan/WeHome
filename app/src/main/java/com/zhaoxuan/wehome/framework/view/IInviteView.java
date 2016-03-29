package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseListView;
import com.zhaoxuan.wehome.framework.base.IBaseView;

/**
 * Created by lizhaoxuan on 15/11/19.
 */
public interface IInviteView extends IBaseView{

    void sendMessage(String phone ,String message);
}
