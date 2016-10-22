package com.smartcity.models.ResponseJsonObject;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by ZJDX on 2016/10/16.
 */
@ResponseBody
@Repository
public class APPResponse implements Serializable {
    private String appname;
    private String url;
    private String categary;
    private String logo;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof APPResponse)) return false;

        APPResponse that = (APPResponse) o;

        if (!getAppname().equals(that.getAppname())) return false;
        return getUrl().equals(that.getUrl());

    }

    @Override
    public int hashCode() {
        int result = getAppname().hashCode();
        result = 31 * result + getUrl().hashCode();
        return result;
    }

    /**
     * 必须提供一个无参数的构造函数
     */
    public APPResponse(){}
}
