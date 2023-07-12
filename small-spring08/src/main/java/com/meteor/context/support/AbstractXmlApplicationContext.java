package com.meteor.context.support;

import com.meteor.beans.factory.support.DefaultListableBeanFactory;
import com.meteor.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(null!=configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
    protected abstract String[] getConfigLocations();
}
