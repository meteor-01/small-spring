package com.meteor.factory.support;

import com.meteor.BeansException;
import com.meteor.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/*
* author: meteor_01
* date: 2023/10/31
* desc: 实例化接口，定义实例化规范
**/
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
