package com.smartcity.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcity.models.*;
import com.smartcity.models.ResponseJsonObject.APPResponse;
import com.smartcity.models.ResponseJsonObject.ResponseMessage;
import com.smartcity.models.ResponseJsonObject.UserResponse;
import com.smartcity.models.selfDefined.HttpRequest;
import com.smartcity.services.intf.IAPPService;
import com.smartcity.services.intf.IDeveloperService;
import com.smartcity.services.intf.IInterfaceService;
import com.smartcity.services.intf.IUserService;
import com.smartcity.ultis.UUIDGenerator;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by ZJDX on 2016/6/26.
 */
@CrossOrigin
@RestController
public class Action {
    private static Logger logger = LoggerFactory.getLogger(Action.class);
    @Autowired
    IUserService userService;
    @Autowired
    IDeveloperService developerService;
    @Autowired
    IAPPService appService;
    @Autowired
    IInterfaceService interfaceService;
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
        System.out.println("phoneNum:"+phonenum+"   "+"password:"+password);
        User newUser = new User();
        newUser.setPhonenum(phonenum);
        newUser.setPassword(password);
        int result = userService.save(newUser);
        System.out.println(result);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage("");
        if (result ==Constant.SUCCESS) {
            responseMessage.setResult(Constant.SUCCESS);
            responseMessage.setMessage("regist Suc! ");
        } else if (result ==Constant.FAIL){
            responseMessage.setResult(Constant.FAIL);
            responseMessage.setMessage("regist failed");
        }else if (result ==Constant.ALREADY_EXISTS){
            responseMessage.setResult(Constant.ALREADY_EXISTS);
            responseMessage.setMessage("acount already exist");
        }

        System.out.println("registerUser responseMessage:"+responseMessage);
        return responseMessage;
    }
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ResponseMessage loginUser(String phonenum, String password) {
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
    @RequestMapping(value = "/registerDeveloper", method = RequestMethod.POST)
    public ResponseMessage registerDeveloper(String phonenum, String password) {
        User user=userService.findByPhoneNum(phonenum);
        ResponseMessage responseMessage=new ResponseMessage();
        if(user==null) {
            responseMessage= registerNewUser(phonenum, password);
        }
        if(user!=null||responseMessage.getResult()==Constant.SUCCESS){
            Developer developer=new Developer();
            String UUID=userService.getUUIDByPhoneNum(phonenum);
            developer.setUserUuid(UUID);
            int result=developerService.saveDeveloper(developer);
            if (result == Constant.SUCCESS) {
                responseMessage.setResult(Constant.SUCCESS);
                responseMessage.setMessage(developer.toString());
            } else if (result ==0){
                responseMessage.setResult(Constant.FAIL);
                responseMessage.setMessage("regist failed");
            }else if (result==Constant.ALREADY_EXISTS){
                responseMessage.setResult(Constant.FAIL);
                responseMessage.setMessage("acount already exist");
            }
        }
        System.out.println("registerDeveloper responseMessage:"+responseMessage);
        return responseMessage;

    }


    @RequestMapping(value = "/createAPP", method = RequestMethod.POST)
    public ResponseMessage createApp(String APPName, HttpSession session) {
        System.out.println("*** Session data ***");
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()){
            String s = e.nextElement();
            System.out.println(s);
            System.out.println("**" + session.getAttribute(s));
        }

        ResponseMessage responseMessage=new ResponseMessage();
        Application application=new Application();
        application.setAppname(APPName);
        application.setAppid(UUIDGenerator.getUUID());
        UserResponse userResponse=(UserResponse) session.getAttribute("userResponse");
        //application.setDeveloperid("1cd000f5bc6c475b9c7831096dd08e2a");
        application.setDeveloperid(developerService.findDevIDByUUID(userResponse.getUuid()));
        int result=appService.save(application);
        if (result == Constant.SUCCESS) {
            responseMessage.setResult(Constant.SUCCESS);
            responseMessage.setMessage(application);
        } else if (result ==0){
            responseMessage.setResult(Constant.FAIL);
            responseMessage.setMessage("createApp failed");
        }else if (result==Constant.ALREADY_EXISTS){
            responseMessage.setResult(Constant.ALREADY_EXISTS);
            responseMessage.setMessage("app already exist");
        }
        return  responseMessage;
    }
    @RequestMapping(value = "/updateAPP", method = RequestMethod.POST)
    public ResponseMessage updateAPP(String application, MultipartFile file, HttpSession session) {//application 是一个json数据，不知道为何只能用String接收，不能用Application接收
        ResponseMessage responseMessage=new ResponseMessage();
        Application app =new Application();
        try{
            ObjectMapper mapper = new ObjectMapper();
            JSONObject jsonObject=new JSONObject(application);
            app = mapper.readValue(jsonObject.toString(), Application.class);
            System.out.println("getCurrentPosition: coordinate " +jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String pathRoot=session.getServletContext().getRealPath("")+"uploadLogo\\";
        String pathRoot=Constant.FTP_PATH;
        System.out.println(pathRoot);
        String logoPath=appService.uploadFileToFTP(file,pathRoot);
        System.out.println(logoPath);
        if( logoPath!=Constant.MSG_FAIL) {
            app.setLogo(logoPath);
            int result = appService.update(app);
            if (result == Constant.SUCCESS) {
                responseMessage.setResult(Constant.SUCCESS);
                responseMessage.setMessage(application);
            } else if (result == 4) {
                responseMessage.setResult(Constant.FAIL);
                responseMessage.setMessage("no such APP");
            }
        }else{
            responseMessage.setResult(Constant.FAIL);
            responseMessage.setMessage(Constant.MSG_FAIL);
        }
        return  responseMessage;
    }

    @RequestMapping(value = "/createAPI", method = RequestMethod.POST)
    public ResponseMessage createAPI(@RequestBody Interface newInterf) {//ajax里面必须连参数顺序也要一样才能获取
        ResponseMessage responseMessage=new ResponseMessage();
        try {
            int result=interfaceService.save(newInterf);
            if (result == Constant.SUCCESS) {
                responseMessage.setResult(Constant.SUCCESS);
                responseMessage.setMessage(newInterf);
            } else if (result ==0){
                responseMessage.setResult(Constant.FAIL);
                responseMessage.setMessage("createAPI failed");
            }else if (result==Constant.ALREADY_EXISTS){
                responseMessage.setResult(Constant.ALREADY_EXISTS);
                responseMessage.setMessage("api already exist");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMessage;
    }

    @RequestMapping(value = "/getAPPID", method = RequestMethod.GET)
    public String getAPPID(String AppName) {
      String appid=appService.findAPPIDByAppName(AppName);
        return appid;
    }
    @RequestMapping(value = "/getAllAPPList", method = RequestMethod.GET)
    public List<APPResponse> getAllAPPList() {
        List<APPResponse>  list=appService.findAllAPPResponse();
        for(int i=0;i<list.size();i++){

            String fileName=list.get(i).getLogo();
            if(fileName==null)continue;
            String sr =fileName.substring(fileName.lastIndexOf("\\")+1);
            list.get(i).setLogo(sr);
        }
        return list;
    }


    /**
     * 下载文件
     * @param response
     * @param logoName
     * @throws IOException
     */
    @RequestMapping(value = "/getAPPLogo", method = RequestMethod.GET)
    public void getAPPLogo(HttpServletResponse response, HttpSession session,
                             @RequestParam("logoName")
                                     String logoName) throws IOException {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + new String(logoName.getBytes("gb2312"), "iso8859-1"));
        File file = new File(logoName);
        String path=session.getServletContext().getRealPath("")+"uploadLogo\\";

        InputStream in = new FileInputStream(path + "\\" + file);

        OutputStream os = response.getOutputStream();

        byte[] b = new byte[1024 * 1024];
        int length;
        while ((length = in.read(b)) > 0) {
            os.write(b, 0, length);
        }
        in.close();
    }


}
