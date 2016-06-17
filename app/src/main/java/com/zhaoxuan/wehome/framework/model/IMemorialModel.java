package com.zhaoxuan.wehome.framework.model;

import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialModel {

    void getData();

    void addData(MemorialDto dto);

    void changeData(MemorialDto dto);

    void deleteData(long id);
}
