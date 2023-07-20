package com.meteor.context;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.Aware;

/*
感知应用上下文
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
