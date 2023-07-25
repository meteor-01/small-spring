package com.meteor.beans.factory;

import com.meteor.beans.BeansException;

import java.util.Map;

/*
    提供遍历功能，即可以遍历某个Bean的所有实例
 */
public interface ListableBeanFactory extends BeanFactory {
    /*
    按照类型返回Bean实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type)throws BeansException;
    /*
    返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
