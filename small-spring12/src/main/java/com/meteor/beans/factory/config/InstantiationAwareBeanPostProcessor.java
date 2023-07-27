package com.meteor.beans.factory.config;

import com.meteor.beans.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
