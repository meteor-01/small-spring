package com.meteor.factory.support;

import com.meteor.BeansException;
import com.meteor.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/*
 * author: meteor_01
 * date: 2023/10/31
 * desc: 利用cglib实例化对象，实际是利用传入的BeanDefinition中的Class对象创建子类
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 创建 Enhancer 类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // 对父类中的方法的拦截操作，NoOp表示无操作
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 根据有无参数调用不同的方法
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
