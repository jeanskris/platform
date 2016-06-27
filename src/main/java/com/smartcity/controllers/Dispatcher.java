package com.smartcity.controllers;

import com.smartcity.dao.APIMapper;
import com.smartcity.services.intf.IAPIService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZJDX on 2016/6/17.
 */
@Controller
public class Dispatcher {
   /* @Autowired
    APIMapper apiMapper;
    @Autowired
    ServerMapper serverMapper;*/
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    APIMapper apiMapper;
    @Autowired
    IAPIService apiService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index1(HttpServletRequest request){
       // APIMapper apiMapper =sqlSessionFactory.openSession().getMapper(APIMapper.class);
        System.out.println(apiService.findById(1).getOriginalapi());
        System.out.println((apiMapper.findAll().get(0).getIdapi()));
        return new ModelAndView("index");
    }

}
