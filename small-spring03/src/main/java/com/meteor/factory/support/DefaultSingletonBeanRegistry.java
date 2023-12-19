package com.meteor.factory.support;

import com.meteor.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/*
 * author: meteor_01
 * date: 2023/10/30
 * desc: 实现了单例对象的获取、添加功能
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
