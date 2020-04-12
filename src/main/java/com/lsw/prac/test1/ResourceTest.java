package com.lsw.prac.test1;

import cn.hutool.core.io.IoUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("priv-key-real.pri");
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = IoUtil.readBytes(inputStream);
        System.out.println("bytes = " + bytes);
//        String path = resource.getFile().getPath();
//        System.out.println("path = " + path);
    }
}
