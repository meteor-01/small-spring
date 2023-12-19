package com.meteor.factory.support;

import com.meteor.BeansException;
import com.meteor.factory.BeanFactory;
import com.meteor.factory.config.BeanDefinition;

/*
 * author: meteor_01
 * date: 2023/10/30
 * desc: 抽象工厂类，Bean 工厂的第一个实现类，实现了模板模式，自己实现了获取 Bean 的方法，但具体的细节抽象成 protected 方法由子类实现，
 * 同时继承了 DefaultSingletonBeanRegistry，具备了获取单例 Bean 的能力，因此在实际获取 Bean 时，会先尝试获取单例 Bean，如果没有才会去
 * 执行创建过程
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
