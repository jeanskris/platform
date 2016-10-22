package com.smartcity.services.intf;

import com.smartcity.models.Developer;

/**
 * Created by ZJDX on 2016/10/10.
 */
public interface IDeveloperService {
    int saveDeveloper(Developer user );
    Developer findDeveloperByUUID(String UUID);
    String findDevIDByUUID(String UUID);
}
