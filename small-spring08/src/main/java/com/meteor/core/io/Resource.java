package com.meteor.core.io;

import java.io.IOException;
import java.io.InputStream;

/*
    资源接口：提供统一的获取输入流的接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
