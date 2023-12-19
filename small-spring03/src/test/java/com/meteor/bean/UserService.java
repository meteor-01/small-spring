package com.meteor.bean;

public class UserService {
    private final String name;
    public UserService(String name){
        this.name = name;
    }
    public void queryUserInfo(){
        System.out.println("查询用户信息："+name);
    }

}
