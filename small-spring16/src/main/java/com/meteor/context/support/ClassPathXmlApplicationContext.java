package com.meteor.context.support;

import com.meteor.beans.BeansException;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    private String[] configLocations;
    public ClassPathXmlApplicationContext(){

    }
    /*
    从XML中加载BeanDefinition，并刷新上下文
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException{
        this(new String[]{configLocations});
    }
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException{
        this.configLocations = configLocations;
        refresh();
    }
    protected String[] getConfigLocations(){
        return configLocations;
    }
}
