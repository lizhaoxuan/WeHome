package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public interface IFamilyView extends IBaseView{

    void init(List<FamilyDto> familyDtos);

}
