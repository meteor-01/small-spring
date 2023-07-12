package com.meteor.beans.factory;

/*
感知所属的ClassLoader
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
