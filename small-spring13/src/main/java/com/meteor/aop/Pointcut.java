package com.meteor.aop;

public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMathcher();
}
