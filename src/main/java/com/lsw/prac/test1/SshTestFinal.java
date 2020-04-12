//package com.lsw.prac.test1;
//
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.core.io.IoUtil;
//import cn.hutool.core.util.CharUtil;
//import cn.hutool.crypto.SecureUtil;
//import com.jcraft.jsch.ChannelExec;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ClassPathResource;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//@Slf4j
//public class SshTestFinal {
//
//
//    public static void main(String[] args) throws JSchException, IOException {
//
//        // 1. 连接远程服务器 jsch
//        // 2. 读取文件，匹配文件
//
//        RemoteData remoteData = new RemoteData();
//        String string = FileUtil.readString(remoteData.getIdentity(), "UTF-8");
//        System.out.println(string);
//        Session session = getSession(remoteData);
//        try {
//            session.connect( 30 * 1000);
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }
//        if (session.isConnected()) {
//            System.out.println("Host({"+ remoteData.getHost() +"}) connected.");
//        }
//
//        //---------------------------------------------------------------
//
//        remoteExecute(session, "pwd");
//        List<String> list = remoteExecute(session, "ls /data/file/contract/94d87a219b11af371af62d971e5007a1");
////        list.forEach(s -> {
////            if (s.endsWith(".pdf") && (s.contains("借款合同") || s.contains("借款协议") || s.contains("借款咨询和服务协议"))) {
////                System.out.println(s);
////            }
////        });
//        List<String> resultList = new ArrayList<>();
//        List<String> collect = list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                if (s.endsWith(".pdf") && (s.contains("借款合同") || s.contains("借款协议") || s.contains("借款咨询与服务协议"))) {
//                    String ss = "CONTRACT_DIR_PATH" + CharUtil.SLASH + SecureUtil.md5(1L + "#@#" + 2L) + CharUtil.SLASH + s;
//                    resultList.add(ss);
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }).collect(Collectors.toList());
//
//        resultList.forEach(System.out::println);
//        //---------------------------------------------------------------
//
//        session.disconnect();
//
//    }
//
//    // 通用执行linux命令的方法
//    public static List<String> remoteExecute(Session session, String command) throws JSchException {
//        log.debug(">> {}", command);
//        List<String> resultLines = new ArrayList<>();
//        ChannelExec channel = null;
//        try{
//            channel = (ChannelExec) session.openChannel("exec");
//            channel.setCommand(command);
//            InputStream input = channel.getInputStream();
//            channel.connect(10 * 1000);
//            try {
//                BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
//                String inputLine = null;
//                while((inputLine = inputReader.readLine()) != null) {
//                    log.debug("  << {}", inputLine);
//                    resultLines.add(inputLine);
//                }
//            } finally {
//                if (input != null) {
//                    try {
//                        input.close();
//                    } catch (Exception e) {
//                        log.error("JSch inputStream close error:", e);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            log.error("IOcxecption:", e);
//        } finally {
//            if (channel != null) {
//                try {
//                    channel.disconnect();
//                } catch (Exception e) {
//                    log.error("JSch channel disconnect error:", e);
//                }
//            }
//        }
//        return resultLines;
//    }
//
//    public static Session getSession(RemoteData remote) throws JSchException, IOException {
//        JSch jSch = new JSch();
//        if (Files.exists(Paths.get(remote.getIdentity()))) {
////            jSch.addIdentity(remote.getIdentity());
//            ClassPathResource resource = new ClassPathResource("priv-key-real.pri");
//            InputStream inputStream = resource.getInputStream();
//            byte[] bytes = IoUtil.readBytes(inputStream);
//            System.out.println("bytes = " + bytes);
//            jSch.addIdentity("priv-key-real.pri",bytes,null,null);
////            jSch.addIdentity(remote.getIdentity(), remote.getPassphrase());
////            jSch.addIdentity(key, remote.getPassphrase());
//        }
//        Session session = jSch.getSession(remote.getUser(), remote.getHost(),remote.getPort());
//        session.setPassword(remote.getPassword());
//        //Missing code
//        java.util.Properties config = new java.util.Properties();
//        config.put("StrictHostKeyChecking", "no");
//        session.setConfig(config);
//
////        session.setConfig("StrictHostKeyChecking", "no");
//        return session;
//    }
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class RemoteData{
//
//    private String user = "root";
////    private String host = "49.93.198.65";
//    private String host = "120.132.14.104";
////    private String host = "120.132.48.121";
//    private int port = 22;
//    private String password = "";
////    private String password = "Lsw19960917";
////    private String identity = "";
//    private String identity = "/Users/daadreeam/Downloads/priv-key-real";
////    private String identity = "/Users/daadreeam/Downloads/id_rsa_w";
////    private String identity = "/Users/daadreeam/.ssh/id_rsa";
//    private String passphrase = "";
//}
