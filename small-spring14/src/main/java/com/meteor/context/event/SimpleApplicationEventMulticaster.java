package com.meteor.context.event;

import com.meteor.beans.factory.BeanFactory;
import com.meteor.context.ApplicationEvent;
import com.meteor.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for(final ApplicationListener listener: getApplicationListeners(event)){
            listener.onApplicationEvent(event);
        }
    }
}
