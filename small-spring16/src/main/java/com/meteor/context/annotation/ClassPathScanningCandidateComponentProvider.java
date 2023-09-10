package com.meteor.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.meteor.beans.factory.config.BeanDefinition;
import com.meteor.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for(Class<?> clazz: classes){
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}