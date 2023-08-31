package com.meteor.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.meteor.beans.BeansException;
import com.meteor.beans.PropertyValues;
import com.meteor.beans.factory.BeanFactory;
import com.meteor.beans.factory.BeanFactoryAware;
import com.meteor.beans.factory.ConfigurableListableBeanFactory;
import com.meteor.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.meteor.utils.ClassUtils;

import java.lang.reflect.Field;

public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException{
        // 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass():clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for(Field field: declaredFields){
            Value valueAnnotation = field.getAnnotation(Value.class);
            if(null!=valueAnnotation){
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        //处理注解 @Autowired
        for(Field field: declaredFields){
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if(null!=autowiredAnnotation){
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if(null!=qualifierAnnotation){
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                }
                else{
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //返回null会影响代理对象的创建
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }
}
