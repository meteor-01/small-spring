package com.meteor.factory.config;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: 单例接口，提供获取单例对象的功能，
 * 体现了接口隔离原则，获取 Bean 和获取单例对象是两个功能，可以同时拥有这两个功能，但不应该混在一起
 **/
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
