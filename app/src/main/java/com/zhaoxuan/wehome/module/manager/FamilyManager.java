package com.zhaoxuan.wehome.module.manager;

import android.util.Log;
import android.widget.Toast;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.module.event.WeatherEvent;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 16/6/22.
 */
public class FamilyManager {

    private static FamilyManager instance;

    public static FamilyManager getInstance() {
        if (instance == null) {
            instance = new FamilyManager();
        }
        return instance;
    }

    private AbstractCakeDao<FamilyDto> familyDao = CakeDao.getCakeDao(FamilyDto.class);
    private DispenseBus dispenseBus = DispenseBus.getInstance();

    public void checkWeather() {
        for (FamilyDto dto : getFamilys()) {
            WeatherManager.getInstance().getWeather(dto, new WeatherManager.ICallBack() {
                @Override
                public void callBack(FamilyDto dto) {
                    dispenseBus.post(new WeatherEvent(dto.getPost() + "所在的城市：" + dto.getCity() +
                            "天气情况较差：" + dto.getWeather() + "发个短信或打个电话照顾一下吧"));
                }
            });
        }
    }

    public FamilyDto[] getFamilys() {
        FamilyDto[] familyDtos = familyDao.loadAllData();
        if (familyDtos != null && familyDtos.length > 0) {
            return familyDtos;
        }
        UserDto userDto = UserManager.getInstance().getUserDto();
        familyDtos = new FamilyDto[3];
        FamilyDto f1 = new FamilyDto();
        f1.setCity(userDto.getCity());
        f1.setElectric(UserManager.getInstance().getElectricLevel());
        f1.setAccount(userDto.getAccount());
        f1.setName(userDto.getName());
        f1.setPost("爸爸");
        f1.setHeadPath(String.valueOf(R.drawable.father));
        familyDtos[0] = f1;

        FamilyDto f2 = new FamilyDto();
        f2.setCity("北京");
        f2.setElectric(9);
        f2.setAccount("690770332@qq.com");
        f2.setName("小哈");
        f2.setPost("儿子");
        f2.setHeadPath(String.valueOf(R.drawable.son));

        familyDtos[1] = f2;

        FamilyDto f3 = new FamilyDto();
        f3.setCity("上海");
        f3.setElectric(99);
        f3.setAccount("690770331@qq.com");
        f3.setName("阿美");
        f3.setPost("妈妈");
        f3.setHeadPath(String.valueOf(R.drawable.mother));
        familyDtos[2] = f3;

        familyDao.insert(f1);
        familyDao.insert(f2);
        familyDao.insert(f3);

        return familyDao.loadAllData();
    }

}
