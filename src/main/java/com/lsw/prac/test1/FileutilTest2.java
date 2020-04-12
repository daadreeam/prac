package com.lsw.prac.test1;

import java.net.Inet4Address;
import java.net.InetAddress;

public class FileutilTest2 {
    public static void main(String[] args) throws Exception {
//        System.out.println("FileUtil.isWindows() = " + FileUtil.isWindows());
//        String path = "root@120.132.14.104:/data/file/contract/94d87a219b11af371af62d971e5007a1";
//        File[] files = FileUtil.ls(path);
//        for (File file : files) {
//            String fileName = file.getName();
//            System.out.println("----------------------------------------");
//            System.out.println("file.getName() = " + fileName);
//            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
//            System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
//            System.out.println("file.isFile() = " + file.isFile());
//            if (fileName.contains("借款协议") || fileName.contains("借款合同")) {
//                System.out.println("借款合同匹配成功 路径为:" +file.getAbsolutePath());
//            }
//
//        }
//        System.out.println("FileUtil.getTmpDirPath() = " + FileUtil.getTmpDirPath());
//        System.out.println("FileUtil.getUserHomeDir() = " + FileUtil.getUserHomeDir());
//        String reg;
//        System.out.println("SecureUtil.md5(\"189377#@#35322\") = " + SecureUtil.md5("189377#@#35322"));
        InetAddress localHost = Inet4Address.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);
    }
}
