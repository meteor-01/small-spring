package com.meteor.context.event;

import com.meteor.context.ApplicationContext;
import com.meteor.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source){
        super(source);
    }
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
