package com.smartcity.services.impl;

import com.smartcity.dao.DeveloperMapper;
import com.smartcity.models.Constant;
import com.smartcity.models.Developer;
import com.smartcity.services.intf.IDeveloperService;
import com.smartcity.ultis.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZJDX on 2016/10/10.
 */
@Service("developerService")
public class DeveloperServiceImpl implements IDeveloperService{
    @Autowired(required = true)
    private DeveloperMapper developerMapper;
    public int saveDeveloper(Developer  developer){
        Developer newDeveloper=developer;
        developer.setDeveloperid(UUIDGenerator.getUUID());
        Developer developer1 =developerMapper.findDevByUUID(newDeveloper.getUserUuid());
        if (developer1 != null) {
            return Constant.ALREADY_EXISTS;//返回0
        }
        //newDeveloperMapper.setPassword(MD5Ultis.getMD5(newDeveloperMapper.getPassword()));//进行MD5加密，不过本来应该客户端加密后再传输。
        return developerMapper.insertSelective(newDeveloper);//返回插入条数
    }
    public Developer findDeveloperByUUID(String UUID){
        Developer developer=developerMapper.findDevByUUID(UUID);
        return developer;
    }
    public String findDevIDByUUID(String UUID){
        String developerID=developerMapper.findDevIDByUUID(UUID);
        return developerID;
    }

}
