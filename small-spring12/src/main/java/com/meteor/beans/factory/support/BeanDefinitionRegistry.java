package com.meteor.beans.factory.support;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.config.BeanDefinition;

/*
    提供bean定义的注册和获取功能
 */
public interface BeanDefinitionRegistry {
    /*
    向注册表中注册 BeanDefinition
     */
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /*
    使用Bean名称查询BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /*
    判断是否包含指定名称的BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /*
    返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
