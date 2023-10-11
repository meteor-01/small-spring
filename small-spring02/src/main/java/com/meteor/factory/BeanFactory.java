package com.meteor.factory;

import com.meteor.BeansException;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: Bean 工厂，向外提供容器中存储的 Bean，Bean 的创建、实例化、属性填充由它的实现类完成
 **/
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
