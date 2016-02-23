package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDayView extends IBaseView{

    void initData(MemorialDayDto family, MemorialDayDto wehome, List<MemorialDayDto> dataList);

    void updateData();

}
