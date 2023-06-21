package com.meteor.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001","李");
        hashMap.put("10002","王");
        hashMap.put("10003","张");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
