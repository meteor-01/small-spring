package com.meteor;

/*
 * @author meteor_01
 * @date 2023/9/21
 * @description Bean定义信息，存储创建Bean的基本数据
 **/
public class BeanDefinition {
    private final Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
