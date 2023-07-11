package com.meteor.beans.factory.config;

import com.meteor.beans.BeansException;


/*
提供在对象初始化前后修改对象的功能，用户实现此接口完成自己想要的修改操作
 */
public interface BeanPostProcessor {
    /*
    在 Bean 对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /*
    在 Bean 对象执行初始化方法之后，执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
