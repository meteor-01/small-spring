package com.meteor.factory;

import com.meteor.BeansException;

public interface BeanFactory {
    public Object getBean(String name) throws BeansException;
}
