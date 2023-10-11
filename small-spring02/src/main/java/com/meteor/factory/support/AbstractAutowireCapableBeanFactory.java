package com.meteor.factory.support;

import com.meteor.BeansException;
import com.meteor.factory.config.BeanDefinition;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: 提供创建 Bean 的功能，供父类 AbstractBeanFactory 使用
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
