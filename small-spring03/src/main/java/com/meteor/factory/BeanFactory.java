package com.meteor.factory;

import com.meteor.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    Object getBean(String name, Object... args) throws BeansException;
}
