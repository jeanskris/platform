package com.smartcity.services.intf;

import com.smartcity.models.User;

/**
 * Created by ZJDX on 2016/9/30.
 */
public interface IUserService {
    User findById(int id );
    int save(User user );
    void delete(int id);
    int login(String findByPhoneNum, String password);
    int findPrivateIDByUUID(String UUID);
}
