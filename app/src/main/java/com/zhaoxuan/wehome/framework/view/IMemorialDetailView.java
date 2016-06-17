package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialDetailView extends IBaseView{

    void initViewForAdd();

    void updateView(MemorialDto memorialDayDto);

    void finishActivity(boolean isChange);

}
