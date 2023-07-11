package com.meteor.beans.factory.config;

import com.meteor.beans.factory.HierarchicalBeanFactory;

/*
    可获取 BeanPostProcessor、BeanClassLoader 等的配置化接口
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
