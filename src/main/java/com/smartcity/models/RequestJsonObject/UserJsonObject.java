package com.smartcity.models.RequestJsonObject;

import org.springframework.stereotype.Repository;

/**
 * Created by ZJDX on 2016/10/8.
 */
@Repository
public class UserJsonObject {
    private String phonenum;
    private String password;
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
