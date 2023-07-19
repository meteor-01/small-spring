package com.meteor.beans.factory.config;

/*
    提供单例bean注册功能
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
    /*
    销毁单例对象
     */
    void destroySingletons();
}
