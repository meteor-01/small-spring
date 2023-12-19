package com.meteor.factory.support;

import com.meteor.BeansException;
import com.meteor.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
* author: meteor_01
* date: 2023/10/31
* desc: 利用反射实例化对象
**/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if(null!=ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }
            else{
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate ["+clazz.getName()+"]",e);
        }
    }
}
