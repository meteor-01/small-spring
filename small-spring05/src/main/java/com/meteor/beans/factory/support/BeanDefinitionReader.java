package com.meteor.beans.factory.support;

import com.meteor.beans.BeansException;
import com.meteor.core.io.Resource;
import com.meteor.core.io.ResourceLoader;

/*
    提供从不同资源读取bean定义的功能
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
}
