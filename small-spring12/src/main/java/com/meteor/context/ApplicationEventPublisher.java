package com.meteor.context;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
