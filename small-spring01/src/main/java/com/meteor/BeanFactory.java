package com.meteor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @author meteor_01
 * @date 2023/9/21
 * @description Bean工厂，存储Bean定义信息，并在获取Bean时利用Bean定义信息创建Bean，目前比较简单
 **/
public class BeanFactory {
    //存储Bean定义信息
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
