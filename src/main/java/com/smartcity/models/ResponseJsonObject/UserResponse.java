package com.smartcity.models.ResponseJsonObject;

import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by ZJDX on 2016/10/10.
 */
@ResponseBody
public class UserResponse implements Serializable{
    public String getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String uuid;
    private String idcardnumber;
    private String username;
    private String phonenum;
    private String sex;

}
