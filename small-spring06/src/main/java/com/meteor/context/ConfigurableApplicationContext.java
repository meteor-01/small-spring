package com.meteor.context;

import com.meteor.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{
    /*
    刷新容器
     */
    void refresh() throws BeansException;
}
