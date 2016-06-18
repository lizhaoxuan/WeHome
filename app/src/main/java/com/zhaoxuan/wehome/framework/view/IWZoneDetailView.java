package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.dto.WZoneDto;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public interface IWZoneDetailView extends IBaseView {

    void updateView(WZoneDto wZoneDto);

    void clearEdit();

}
