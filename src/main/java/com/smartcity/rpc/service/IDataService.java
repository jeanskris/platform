package com.smartcity.rpc.service;

/**
 * Created by ZJDX on 2016/10/21.
 */
public interface IDataService {
      <T> String sendDataToPlatform(String appID,String dataName, T data);

      <T> T getDataFromPlatform(String appID,String dataName);
}
