package com.smartcity.services.intf;

import com.smartcity.models.Server;

import java.util.List;

/**
 * Created by ZJDX on 2016/6/17.
 */

public interface IServerService {
    Server findById(int id );
    int save(Server Server );
    List<Server> findAllServers();
}
