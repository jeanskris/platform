package com.smartcity.services.intf;

import com.smartcity.models.API;

import java.util.List;

/**
 * Created by ZJDX on 2016/6/17.
 */

public interface IAPIService {
     API findById(int id );
     int save(API API );
     List<API> findAllAPIs();
}

