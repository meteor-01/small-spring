package com.meteor.beans.factory.config;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.BeanFactory;

/*
    自动化处理 Bean 工厂配置
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}