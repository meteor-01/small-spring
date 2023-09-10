package com.meteor.beans.factory;

import com.meteor.beans.BeansException;

public interface ObjectFactory<T> {
    T getObject() throws BeansException;

}
