package com.meteor.beans.factory;

import com.meteor.beans.BeansException;
import com.meteor.beans.PropertyValue;
import com.meteor.beans.PropertyValues;
import com.meteor.beans.factory.config.BeanDefinition;
import com.meteor.beans.factory.config.BeanFactoryPostProcessor;
import com.meteor.core.io.DefaultResourceLoader;
import com.meteor.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    /*
    * @author meteor_01
    * @date 2023/8/17
    * @description 默认占位符前缀
    **/
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    /*
    * @author meteor_01
    * @date 2023/8/17
    * @description 默认占位符后缀
    **/
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try{
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitonNames = beanFactory.getBeanDefinitionNames();
            for(String beanName: beanDefinitonNames){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for(PropertyValue propertyValue: propertyValues.getPropertyValues()){
                    Object value = propertyValue.getValue();
                    if(!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder buffer = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if(startIdx!=-1 && stopIdx!=-1 && startIdx<stopIdx){
                        String propKey = strVal.substring(startIdx+2, stopIdx);
                        String propVal = properties.getProperty(propKey);
                        buffer.replace(startIdx, stopIdx+1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));
                    }
                }
            }
        } catch (IOException e){
            throw new BeansException("Could not load properties", e);
        }
    }
    public void setLocation(String location){
        this.location = location;
    }
}
