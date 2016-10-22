package com.smartcity.rpc.service;

import com.patterncat.rpc.common.annotation.ServiceExporter;
import com.smartcity.dao.redis.RedisDao;
import com.smartcity.services.intf.IAPPService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by ZJDX on 2016/10/21.
 */
@ServiceExporter(value = "dataService",targetInterface = IDataService.class)
public class DataService implements IDataService{

    @Autowired
    RedisDao redisDao;
    @Autowired
    IAPPService  appService;

    public <T> String sendDataToPlatform(String appID,String dataName, T data){
        if(appID!=""&&dataName!=""){
            if(appService.findById(appID)!=null){
                redisDao.save(appID+dataName,data);
                return "upload data success!";
            }else{
                return "no app with id="+appID;
            }
        }else{
            return "appid can not be null!";
        }

    }
    public <T> T getDataFromPlatform(String appID,String dataName){

        if(appID!=""&&dataName!=""){
           T t=(T)redisDao.read(appID+dataName);
            return t;
        }else{
            return null;
        }
    }


}
