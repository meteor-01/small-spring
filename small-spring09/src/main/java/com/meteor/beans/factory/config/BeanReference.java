package com.meteor.beans.factory.config;

/*
    bean引用信息，递归此对象用以处理属性填充问题
 */
public class BeanReference {
    private final String beanName;
    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
