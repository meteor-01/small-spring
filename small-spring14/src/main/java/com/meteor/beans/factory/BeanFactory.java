package com.meteor.beans.factory;

import com.meteor.beans.BeansException;

/*
    提供获取bean的功能，其下接口或类实现bean定义的注册、获取和bean的创建、实例化、属性填充功能
 */
public interface BeanFactory {
    /*
        根据名称获取bean，无参
     */
    Object getBean(String name) throws BeansException;

    /*
        根据名称和参数获取bean
     */
    Object getBean(String name, Object... args) throws BeansException;

    /*
        根据名称和类型获取bean
     */
    <T> T getBean(String name, Class<T> requiredType);

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
