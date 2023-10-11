package com.meteor;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: 自定义异常处理
 **/
public class BeansException extends Throwable {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable e) {
        super(message, e);
    }
}
