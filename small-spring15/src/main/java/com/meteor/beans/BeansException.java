package com.meteor.beans;

/*
    提供统一的异常处理
 */
public class BeansException extends RuntimeException {
    public BeansException(String message){
        super(message);
    }
    public BeansException(String message, Throwable e) {
        super(message, e);
    }
}
