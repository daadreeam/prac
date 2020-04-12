package com.lsw.prac.test1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.crypto.SecureUtil;

import java.io.File;
import java.io.IOException;

public class FileutilTest {
    public static void main(String[] args) throws IOException {

        System.out.println("FileUtil.isWindows() = " + FileUtil.isWindows());
//        String path = "C:\\Users\\daadreeam\\Desktop\\诉讼需求";
        String path = "/Users/daadreeam/Documents/quicklyun/远程办公/诉讼需求";
        long userId = 189377L;
        long formId = 35322L;
        String dirName = SecureUtil.md5(userId + "#@#" + formId);
        File[] files = FileUtil.ls(path + CharUtil.BACKSLASH +dirName);
        for (File file : files) {
            String fileName = file.getName();
            System.out.println("----------------------------------------");
            System.out.println("file.getName() = " + fileName);
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
            System.out.println("file.isFile() = " + file.isFile());
            if (fileName.contains("借款协议") || fileName.contains("借款合同")) {
                System.out.println("资金方借款合同匹配成功 路径为:" +file.getAbsolutePath());
            }
            if (fileName.contains("借款咨询与服务协议.pdf")) {
                System.out.println("极速云借款合同匹配成功 路径为:" +file.getAbsolutePath());
            }

        }
        System.out.println("FileUtil.getTmpDirPath() = " + FileUtil.getTmpDirPath());
        System.out.println("FileUtil.getUserHomeDir() = " + FileUtil.getUserHomeDir());
        String reg;
        System.out.println("SecureUtil.md5(\"189377#@#35322\") = " + SecureUtil.md5("189377#@#35322"));
    }

    public String getDirNameByMd5(Long userId, Long formId){
        return SecureUtil.md5(userId + "#@#" +formId);
    }
}
