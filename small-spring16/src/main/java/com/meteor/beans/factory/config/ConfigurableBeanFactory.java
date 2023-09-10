package com.meteor.beans.factory.config;

import com.meteor.beans.factory.HierarchicalBeanFactory;
import com.meteor.utils.StringValueResolver;

/*
    可获取 BeanPostProcessor、BeanClassLoader 等的配置化接口
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    /*
    * @author meteor_01
    * @date 2023/8/31
    * @description 添加字符串解析用以注解属性值注入
    **/
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /*
    * @author meteor_01
    * @date 2023/8/31
    * @description 处理提供的注解属性值
    **/
    String resolveEmbeddedValue(String value);
}
