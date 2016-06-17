package com.zhaoxuan.wehome.framework.presenter;

import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialPresenter {

    void initData();

    MemorialDto getData(int position);

}
