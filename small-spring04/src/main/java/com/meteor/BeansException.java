package com.meteor;

public class BeansException extends RuntimeException {
    public BeansException(String message){
        super(message);
    }
    public BeansException(String instantiation_of_bean_failed, Throwable e) {
        super(instantiation_of_bean_failed, e);
    }
}
