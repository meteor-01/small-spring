package com.meteor.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.meteor.beans.BeansException;
import com.meteor.beans.PropertyValue;
import com.meteor.beans.PropertyValues;
import com.meteor.beans.factory.config.AutowireCapableBeanFactory;
import com.meteor.beans.factory.config.BeanDefinition;
import com.meteor.beans.factory.config.BeanPostProcessor;
import com.meteor.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/*
    实现了创造bean的功能，包括根据不同的实例化策略（jdk、cglib）实例化对象和属性填充
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try{
            //创建bean
            bean = createBeanInstance(beanDefinition, beanName, args);
            //给bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            //执行 Bean的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //将bean加入到单例map中
        addSingleton(beanName, bean);
        return bean;
    }
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for(Constructor ctor: declaredConstructors){
            if(null!=args && ctor.getParameterTypes().length==args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /*
    bean属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try{
            PropertyValues propertyValues = beanDefinition.getPropertryValues();
            for(PropertyValue propertyValue: propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充，利用hutool工具包
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e){
            throw new BeansException("Error setting property values: "+beanName);
        }
    }
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition){
        //1. 执行 BeanPostProcessor Before处理
        Object wrapperBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        // 待完成
        invokeInitMethods(beanName, wrapperBean, beanDefinition);

        //2. 执行 BeanPostProcessor After 处理
        wrapperBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrapperBean;
    }
    private void invokeInitMethods(String beanName, Object wrapperBean, BeanDefinition beanDefinition){

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor processor: getBeanPostProcessors()){
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if(null==current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor processor: getBeanPostProcessors()){
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if(null == current) return result;
            result = current;
        }
        return result;
    }
}
