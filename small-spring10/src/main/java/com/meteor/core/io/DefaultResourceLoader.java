package com.meteor.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/*
    默认的资源加载器
 */
public class DefaultResourceLoader implements ResourceLoader {
    /*
        根据路径选择对应的资源，然后就能获取资源的输入流
     */
    @Override
    public Resource getResource(String location) {
        assert location != null : "Location must not be null";
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else{
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
