package com.meteor;

public class BeansException extends Throwable {
    public BeansException(String message){
        super(message);
    }
    public BeansException(String message, Throwable e) {
        super(message, e);
    }
}
