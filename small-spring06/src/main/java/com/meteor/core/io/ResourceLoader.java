package com.meteor.core.io;

/*
    定义统一的资源加载接口和类路径前缀
 */
public interface ResourceLoader {
    /*
    伪URL前缀：从类路径：“classpath:”加载
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
