package com.smartcity.services.impl;

import com.smartcity.dao.ApplicationMapper;
import com.smartcity.models.Application;
import com.smartcity.models.Constant;
import com.smartcity.models.ResponseJsonObject.APPResponse;
import com.smartcity.services.intf.IAPPService;
import com.smartcity.ultis.UUIDGenerator;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZJDX on 2016/10/13.
 */
@Service("appService")
public class APPServiceImpl implements IAPPService {
    @Autowired
    ApplicationMapper applicationMapper;
    public int save(Application obj){
        Application newApplication=obj;
        Application application =applicationMapper.findByAppName(newApplication.getAppname());
        if (application != null) {

            return Constant.ALREADY_EXISTS;//返回2
        }
        newApplication.setAppid(UUIDGenerator.getUUID());
        //newApplication.setPassword(MD5Ultis.getMD5(newApplication.getPassword()));//进行MD5加密，不过本来应该客户端加密后再传输。
        return applicationMapper.insertSelective(newApplication);//返回插入条数
    }
    public List<String> findAPPNameByDevloperId(String devID){
        return applicationMapper.findAPPNameByDevloperId(devID);
    }
    public Application findById(String id){
        Application app=applicationMapper.selectByPrimaryKey(id);
        return app;
    }
    public String findAPPIDByAppName(String AppName){
        return applicationMapper.findAPPIDByAppName(AppName);
    }
    public int update(Application obj){
        Application newApplication=obj;
        Application application =applicationMapper.selectByPrimaryKey(newApplication.getAppid());
        if (application == null) {
            return Constant.NO_SUCH_APP;//返回4
        }
        return applicationMapper.updatePartOfAPPByPrimaryKey(newApplication);
    }

    //文件上传
    public String uploadFile(MultipartFile file,String pathRoot) {
        try{
            String fileName = file.getOriginalFilename();
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //定义一个数组，用于保存可上传的文件类型
            List fileTypes = new ArrayList();
            fileTypes.add("image/jpg");
            fileTypes.add("image/jpeg");
            fileTypes.add("image/bmp");
            fileTypes.add("image/png");
            if(fileTypes.contains(contentType)) {
                File tempFile = new File(pathRoot, fileName);
                if (!tempFile.getParentFile().exists()) {
                    tempFile.getParentFile().mkdir();
                }
                if (!tempFile.exists()) {
                    tempFile.createNewFile();
                }
                file.transferTo(tempFile);
                return pathRoot+ tempFile.getName();
            }
            else {
                return Constant.MSG_FAIL;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Constant.MSG_FAIL;
        }



    }
    //文件上传
    public String uploadFileToFTP(MultipartFile uploadFile,String pathRoot) {

            String fileName = uploadFile.getOriginalFilename();
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=uploadFile.getContentType();
            //定义一个数组，用于保存可上传的文件类型
            List fileTypes = new ArrayList();
            fileTypes.add("image/jpg");
            fileTypes.add("image/jpeg");
            fileTypes.add("image/bmp");
            fileTypes.add("image/png");
            boolean success = false;
            InputStream inStream = null;
            //设置连接ip  
            FTPClient client = new FTPClient();
            if(fileTypes.contains(contentType)) {
                try {
                client.connect(Constant.FTP_IP,21);
                    //连接是否正常  
                    if (client.isConnected()) {
                        //使用用户名和密码进行登录
                        if (client.login( "anonymous", "abc@abc.com" )) {
                            //判断FTP连接是否可用、源码中判断ReplyCode值为(reply >= 200) && (reply < 300)为可用,非单纯200！
                            if (FTPReply.isPositiveCompletion(client.getReplyCode())) {


                                System.out.println("FTP登录成功，FTP IP:" + client.getRemoteAddress());
                            }
                        }

                        //设置文件类型

                        //默认为ASCII(value:0),此处设置为2进制
                        System.out.println("设置文件类型为：" + client.BINARY_FILE_TYPE);
                        client.setFileType(client.BINARY_FILE_TYPE);
                        client.enterLocalPassiveMode();//不设置就无法上传，success=false
                        System.out.println("当前工作目录为：" + client.printWorkingDirectory());
                        //设置工作目录
                        if(client.changeWorkingDirectory(pathRoot)){
                            System.out.println("当前工作目录为2：" + client.printWorkingDirectory());
                        }

                        inStream = uploadFile.getInputStream();
                        success = client.storeFile(fileName, inStream);

                        if (success == true) {
                            return "ftp://"+Constant.FTP_IP+Constant.FTP_PATH+fileName;
                        }else {
                            return  Constant.MSG_FAIL;
                        }
                        }else{
                        return  Constant.MSG_FAIL;
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                    return Constant.MSG_FAIL;
                } finally {
                    try {

                        inStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
            else {
                return Constant.MSG_FAIL;
            }

    }


    public List<APPResponse> findAllAPPResponse(){
        return applicationMapper.findAllAPPResponse();
    }
}
