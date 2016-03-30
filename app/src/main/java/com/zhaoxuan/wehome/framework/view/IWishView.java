package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseListView;
import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public interface IWishView extends IBaseListView{

    void initData(List<WishDto> unFinishList,List<WishDto> finishList);

    void updateData();


}
