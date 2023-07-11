package com.meteor.beans.factory.config;

/*
    可获取 BeanPostProcessor、BeanClassLoader 等的配置化接口
 */
public interface ConfigurableBeanFactory {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
}
