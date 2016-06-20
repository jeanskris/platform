package com.smartcity.services.impl;

import com.smartcity.dao.ServerMapper;
import com.smartcity.models.Server;
import com.smartcity.services.intf.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJDX on 2016/6/17.
 */
@Service("serverService")
public class ServerServiceImpl implements IServerService {
    @Autowired(required = true)
    private ServerMapper serverMapper;


    public Server findById(int id )
    {
        return serverMapper.selectByPrimaryKey(id);
    }
    public int save(Server Server )
    {
        return serverMapper.insert(Server);
    }
    public List<Server> findAllServers()
    {
        return serverMapper.findAll();
    }

}
