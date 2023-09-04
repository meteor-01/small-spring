package com.meteor.aop;

public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
