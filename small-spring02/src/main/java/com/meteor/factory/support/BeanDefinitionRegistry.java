package com.meteor.factory.support;

import com.meteor.factory.config.BeanDefinition;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: 提供注册Bean定义的功能
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
