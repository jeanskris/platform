package com.smartcity.services.impl;

import com.smartcity.dao.InterfaceMapper;
import com.smartcity.models.Constant;
import com.smartcity.models.Interface;
import com.smartcity.services.intf.IInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZJDX on 2016/10/15.
 */
@Service("interfaceService")
public class InterfaceServiceImpl implements IInterfaceService {
    @Autowired
    InterfaceMapper interfaceMapper;
    public int save(Interface api){
        Interface newInterface=api;
        Interface result=interfaceMapper.findInterfaceByAddrMethod(newInterface.getDataaddr(),newInterface.getMethod());
        if(result!=null){
            return Constant.ALREADY_EXISTS;
        }
        return  interfaceMapper.insertSelective(newInterface);
    }


}
