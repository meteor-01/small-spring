package com.meteor.beans.factory.support;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/*
    提供统一的不同实例化策略的接口
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
