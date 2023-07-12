package com.meteor.beans.factory;

import com.meteor.beans.BeansException;

/*
感知到所属的BeanFactory
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
