package com.meteor.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/*
    根据Url提供输入流
 */
public class UrlResource implements Resource{
    private final URL url;
    public UrlResource(URL url){
        assert url!=null:"URL must not be null";
        this.url = url;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try{
            return con.getInputStream();
        }
        catch (IOException e){
            if(con instanceof HttpURLConnection){
                ((HttpURLConnection)con).disconnect();
            }
            throw e;
        }
    }
}
