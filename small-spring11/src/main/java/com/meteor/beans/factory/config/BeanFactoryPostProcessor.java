package com.meteor.beans.factory.config;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    /*
    在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修
改 BeanDefinition 属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
