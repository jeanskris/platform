package com.smartcity.services.intf;

import com.smartcity.models.Application;
import com.smartcity.models.ResponseJsonObject.APPResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by ZJDX on 2016/10/13.
 */
public interface IAPPService {
    int save(Application APP );
    int update(Application APP);
    String uploadFile(MultipartFile file, String pathRoot);
    String uploadFileToFTP(MultipartFile file, String pathRoot);
    Application findById(String id);
    List<String> findAPPNameByDevloperId(String devID);
    String findAPPIDByAppName(String AppName);
     List<APPResponse> findAllAPPResponse();
}
