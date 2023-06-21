package com.meteor.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
