package com.smartcity.services.impl;

import com.smartcity.dao.UserMapper;
import com.smartcity.models.Constant;
import com.smartcity.models.ResponseJsonObject.UserResponse;
import com.smartcity.models.User;
import com.smartcity.services.intf.IUserService;
import com.smartcity.ultis.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZJDX on 2016/9/30.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired(required = true)
    private UserMapper userMapper;

    public User findById(int id ){
        return userMapper.selectByPrimaryKey(id);
    }
    public int save(User obj){
        User newUser=obj;
        User user =userMapper.findByPhoneNum(newUser.getPhonenum());
        if (user != null) {
            return Constant.ALREADY_EXISTS;//返回2
        }
        newUser.setUuid(UUIDGenerator.getUUID());
        //newUser.setPassword(MD5Ultis.getMD5(newUser.getPassword()));//进行MD5加密，不过本来应该客户端加密后再传输。
        return userMapper.insertSelective(newUser);//返回插入条数
    }
    public void delete(int id){
        userMapper.deleteByPrimaryKey(id);
    }
    public int login(String PhoneNum, String password) {
        User user =userMapper.findByPhoneNum(PhoneNum);
        if (user == null) {
            return Constant.NO_SUCH_USER;
        }
        if (user.getPassword().equals(password)) {
            return Constant.SUCCESS;
        }
        return Constant.MISMATCH;
    }
    public UserResponse getUserResponseByPhoneNum(String PhoneNum){
        User user =userMapper.findByPhoneNum(PhoneNum);
        if (user == null) {
            return null;
        }
        UserResponse userResponse=new UserResponse();
        userResponse.setPhonenum(user.getPhonenum());
        userResponse.setUsername(user.getUsername());
        userResponse.setIdcardnumber(user.getIdcardnumber());
        userResponse.setSex(user.getSex());
        userResponse.setUuid(user.getUuid());
        return userResponse;
    }
    public String getUUIDByPhoneNum(String PhoneNum){
        User user =userMapper.findByPhoneNum(PhoneNum);
        if (user == null) {
            return "null";
        }
        return user.getUuid();
    }
    public User findByPhoneNum(String PhoneNum){
        User user =userMapper.findByPhoneNum(PhoneNum);
        if (user == null) {
            return null;
        }
        return user;
    }
    public int findPrivateIDByUUID(String UUID){
        int privateID=userMapper.findByUUID(UUID);
        return privateID;
    }
}
