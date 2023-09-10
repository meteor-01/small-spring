package com.meteor.beans.factory.config;

import com.meteor.beans.BeansException;
import com.meteor.beans.PropertyValues;


public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    PropertyValues postProcessPropertyValues(PropertyValues propertyValues, Object bean, String beanName) throws BeansException;

    default Object getEarlyBeanReference(Object bean, String beanName){
        return bean;
    }
}
