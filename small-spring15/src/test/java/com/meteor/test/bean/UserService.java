package com.meteor.test.bean;

import java.util.Random;


public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "meteor_01"+token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
