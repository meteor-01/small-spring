package com.meteor.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
   根据文件或路径提供输入流
 */
public class FileSystemResource implements Resource {
    private final File file;

    private final String path;

    public FileSystemResource(File file){
        this.file = file;
        path = file.getPath();
    }
    public FileSystemResource(String path){
        this.file = new File(path);
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
    public final String getPath(){
        return this.path;
    }
}
