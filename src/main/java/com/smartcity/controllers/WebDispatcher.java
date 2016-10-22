package com.smartcity.controllers;

import com.smartcity.dao.APIMapper;
import com.smartcity.models.Constant;
import com.smartcity.models.Developer;
import com.smartcity.models.ResponseJsonObject.ResponseMessage;
import com.smartcity.models.ResponseJsonObject.UserResponse;
import com.smartcity.services.intf.IAPIService;
import com.smartcity.services.intf.IAPPService;
import com.smartcity.services.intf.IDeveloperService;
import com.smartcity.services.intf.IUserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZJDX on 2016/6/17.
 */
@Controller
@SessionAttributes("userResponse")
public class WebDispatcher {
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

    @Autowired
    IDeveloperService developerService;
    @Autowired
    IAPPService appService;
    @CrossOrigin
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index1(){
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/PlatformUserCenter.html", method = RequestMethod.GET)
    public ModelAndView PlatformUserCenter(){
        return new ModelAndView("PlatformUserCenter");
    }

    @RequestMapping(value = "/PlatformAddAPP", method = RequestMethod.GET)
    public ModelAndView PlatformAddAPP(){
        return new ModelAndView("PlatformAddAPP");
    }

    @RequestMapping(value = "/PlatformAddAPI", method = RequestMethod.GET)
    public ModelAndView PlatformAddAPI(HttpSession session){
        ModelAndView mv =new ModelAndView("PlatformAddAPI");
        UserResponse userResponse=(UserResponse) session.getAttribute("userResponse");
        //application.setDeveloperid("1cd000f5bc6c475b9c7831096dd08e2a");
        String devloperId=developerService.findDevIDByUUID(userResponse.getUuid());
        List<String> allAPPName=appService.findAPPNameByDevloperId(devloperId);
        mv.addObject("appNameList",allAPPName);
        return mv;
    }

    @RequestMapping(value = "/loginDeveloper", method = RequestMethod.POST)
    public ModelAndView loginDeveloper(String phonenum, String password) {
        ModelAndView mv ;
        String UUID=userService.getUUIDByPhoneNum(phonenum);
        Developer developer=developerService.findDeveloperByUUID(UUID);
        ResponseMessage responseMessage=new ResponseMessage();
        if(developer!=null){
            responseMessage=loginUserAndDev(phonenum, password);
        }
        System.out.println("loginDeveloper responseMessage:"+responseMessage);
        //保存相应的参数，通过ModelAndView返回
        if(responseMessage.getResult()==Constant.SUCCESS)
        {
            mv= new ModelAndView(new RedirectView("PlatformAddAPP"));
            mv.addObject("userResponse",responseMessage.getMessage());
        }else {
            mv= new ModelAndView("index");
            mv.addObject("error", "用户名或密码输入错误！！！");
        }
        return mv;
    }
    public ResponseMessage loginUserAndDev(String phonenum, String password) {
        ResponseMessage responseMessage=new ResponseMessage();
        int result = userService.login(phonenum, password);
        if (result == Constant.SUCCESS) {
            UserResponse userResponse=userService.getUserResponseByPhoneNum(phonenum);
            responseMessage.setResult(Constant.SUCCESS);
            responseMessage.setMessage(userResponse);
        } else if (result == Constant.NO_SUCH_USER) {
            responseMessage.setResult(Constant.NO_SUCH_USER);
            responseMessage.setMessage(Constant.MSG_NO_SUCH_USER);
        } else {
            responseMessage.setResult(Constant.MISMATCH);
            responseMessage.setMessage(Constant.MSG_MISMATCH);
        }
        System.out.println("loginUser responseMessage:"+responseMessage);
        return responseMessage;
    }

}
