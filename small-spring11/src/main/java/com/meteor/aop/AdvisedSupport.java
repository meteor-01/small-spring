package com.meteor.aop;

import org.aopalliance.intercept.MethodInterceptor;

/*
* @author meteor_01
* @date 2023/7/24
* @description 包装切面通知信息，即把入参包装为一个类
*/
public class AdvisedSupport {

    // 被代理的目标对象
    private TargetSource targetSource;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    // 方法拦截器
    private MethodInterceptor methodInterceptor;

    // 方法匹配器(检查目标方法是否符合通知条件)
    private MethodMatcher methodMatcher;
}
