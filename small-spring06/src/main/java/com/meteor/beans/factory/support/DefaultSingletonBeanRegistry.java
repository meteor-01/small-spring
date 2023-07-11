package com.meteor.beans.factory.support;

import com.meteor.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/*
    实现了单例注册
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }
}
