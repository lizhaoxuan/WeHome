package com.zhaoxuan.wehome.module.manager;

import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 16/6/14.
 */
public class UserManager {
    private static final String TAG = UserManager.class.getSimpleName();

    private static volatile UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    private UserDto userDto = null;

    public UserDto getUserDto() {
        if (userDto == null) {
            userDto = SharedManager.loadUser();
            return userDto;
        } else {
            return userDto;
        }
    }

    public void setUserDto(UserDto userDto) {
        if (userDto == null) {
            return;
        }
        this.userDto = userDto;
        SharedManager.saveUser(userDto);
    }

}
