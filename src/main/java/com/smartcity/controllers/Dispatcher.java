package com.smartcity.controllers;

import com.smartcity.dao.APIMapper;
import com.smartcity.models.User;
import com.smartcity.services.intf.IAPIService;
import com.smartcity.services.intf.IUserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Autowired
    IUserService userService;

    @CrossOrigin
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index1(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            //get user ID
            request.setCharacterEncoding("UTF-8");
            String UUID=request.getParameter("UUID");
            System.out.println("userID:"+UUID);
            int privateID=userService.findPrivateIDByUUID(UUID);
            User user=userService.findById(privateID);//防止外部直接采用UUID查询数据库。
            System.out.println("user:"+user.getPhonenum());
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ModelAndView("index");
    }

}
