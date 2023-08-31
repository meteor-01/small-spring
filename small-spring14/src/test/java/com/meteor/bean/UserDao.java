package com.meteor.bean;

import com.meteor.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();
    static {
        hashMap.put("10001","meteor_01");
        hashMap.put("10002","meteor_01");
        hashMap.put("10003","meteor_02");
    }
    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
