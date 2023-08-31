package com.meteor.bean;

import com.meteor.beans.factory.annotation.Autowired;
import com.meteor.beans.factory.annotation.Value;
import com.meteor.stereotype.Component;

import java.util.Random;

@Component("userService")
public class UserService implements IUserService {
    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001")+","+token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { "+token +"}";
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
}
