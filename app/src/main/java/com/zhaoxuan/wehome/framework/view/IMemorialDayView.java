package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseListView;
import com.zhaoxuan.wehome.support.dto.MemorialDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDayView extends IBaseListView{

    void initData(MemorialDto family, MemorialDto wehome, List<MemorialDto> dataList);

    void updateData();
}
