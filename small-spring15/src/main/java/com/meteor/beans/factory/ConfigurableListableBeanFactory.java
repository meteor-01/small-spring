package com.meteor.beans.factory;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.config.AutowireCapableBeanFactory;
import com.meteor.beans.factory.config.BeanDefinition;
import com.meteor.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    void preInstantiateSingletons() throws BeansException;
}
