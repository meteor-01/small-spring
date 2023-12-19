package com.meteor.factory.config;

/*
 * author: meteor_01
 * date: 2023/10/30
 * desc: Bean 定义相关信息，存储创建 Bean 的基本数据
 **/
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
