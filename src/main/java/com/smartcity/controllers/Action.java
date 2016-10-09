package com.smartcity.controllers;

import com.smartcity.models.Constant;
import com.smartcity.models.ResponseJsonObject.ResponseMessage;
import com.smartcity.models.User;
import com.smartcity.models.selfDefined.HttpRequest;
import com.smartcity.services.intf.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJDX on 2016/6/26.
 */
@CrossOrigin
@RestController
public class Action {
    private static Logger logger = LoggerFactory.getLogger(Action.class);
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public String application(){
       return "http://10.214.143.78:8080/index.html";
        //return "http://114.215.144.107:8080/park-core-1.0-SNAPSHOT/index.html";
    }
    @RequestMapping(value = "/startByPlatform", method = RequestMethod.GET)
    public void startByPlatform(){
        logger.debug("startByPlatform");
        HttpRequest hr=new HttpRequest();
        Object result=hr.sendGet("http://localhost:8083/startAutoPark","");
        System.out.println(result.toString());
    }
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public Object getData(){
        logger.debug("getData");
        HttpRequest hr=new HttpRequest();
        Object obj=hr.sendGet("http://localhost:8083/getData","");
        return obj;
    }
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseMessage registerNewUser(String phonenum, String password) {
       /* User newUser = new User(); JSONObject userjson
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserJsonObject userJsonObject = mapper.readValue(userjson.toString(), UserJsonObject.class);

            newUser.setPhonenum(userJsonObject.getPhonenum());
            newUser.setPassword(userJsonObject.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int result = userService.save(newUser);
        System.out.println(result);
        if (result > 0) {
            return "registSuc";
        } else {
            return "registfail";
        }
    }*/
        System.out.println("phoneNum:"+phonenum+"   "+"password:"+password);
        User newUser = new User();

        newUser.setPhonenum(phonenum);
        newUser.setPassword(password);
        int result = userService.save(newUser);
        System.out.println(result);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage("");
        if (result ==1) {
            responseMessage.setResult(Constant.SUCCESS);
            responseMessage.setMessage("regist Suc! ");
        } else if (result ==0){
            responseMessage.setResult(Constant.FAIL);
            responseMessage.setMessage("regist failed");
        }else if (result ==2){
            responseMessage.setResult(Constant.FAIL);
            responseMessage.setMessage("acount already exist");
        }

        System.out.println("responseMessage:"+responseMessage);
        return responseMessage;
    }
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ResponseMessage loginUser(String phonenum, String password) {
        ResponseMessage responseMessage=new ResponseMessage();
        int result = userService.login(phonenum, password);
        if (result == Constant.SUCCESS) {
            responseMessage.setResult(Constant.SUCCESS);
            responseMessage.setMessage(Constant.MSG_SUCCESS);
        } else if (result == Constant.NO_SUCH_USER) {
            responseMessage.setResult(Constant.NO_SUCH_USER);
            responseMessage.setMessage(Constant.MSG_NO_SUCH_USER);
        } else {
            responseMessage.setResult(Constant.MISMATCH);
            responseMessage.setMessage(Constant.MSG_MISMATCH);
        }
        return responseMessage;
    }

}
