package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.framework.presenter.IInvitePresenter;
import com.zhaoxuan.wehome.framework.view.IInviteView;
import com.zhaoxuan.wehome.support.constants.Strs;

/**
 * Created by lizhaoxuan on 15/11/19.
 */
public class InvitePresenter implements IInvitePresenter {

    private IInviteView view ;

    public InvitePresenter(IInviteView view) {
        this.view = view;
    }

    @Override
    public void send(String phone) {
        if (phone.equals("")){
            view.showToast("电话号码不可以为空哦~");
        }else{
            String message = "集合啦！我已经在爱+创建了一个小微家，超有爱的应用哦。。。满满的都是爱！微家的账号是"+
                    WeHomeApplication.getInstance().getUserDto().getHomeId()+
                    "  这是下载链接。快来哦！"+
                    Strs.DOWNLOAD_URL;    //编辑短信内容
            view.sendMessage(phone,message);
        }
    }
}
