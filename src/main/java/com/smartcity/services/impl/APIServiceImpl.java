package com.smartcity.services.impl;

import com.smartcity.dao.APIMapper;
import com.smartcity.models.API;
import com.smartcity.services.intf.IAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJDX on 2016/6/17.
 */
@Service("apiService")
public class APIServiceImpl implements IAPIService {
    @Autowired(required = true)
    private APIMapper apiMapper;

    public void setapiMapper(APIMapper apiMapper) {
        this.apiMapper = apiMapper;
    }
    public API findById(int id )
    {
        return apiMapper.selectByPrimaryKey(id);
    }
    public int save(API API )
    {
        return apiMapper.insert(API);
    }
    public List<API> findAllAPIs()
    {
        return apiMapper.findAll();
    }
}
