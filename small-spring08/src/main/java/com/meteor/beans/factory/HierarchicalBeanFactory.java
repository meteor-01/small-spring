package com.meteor.beans.factory;

/*
扩展了BeanFactory的功能，提供了层次结构的父子关系，子类可以使用、扩展父类工厂，父类工厂不能使用子类工厂
 */
public interface HierarchicalBeanFactory extends BeanFactory{
}
