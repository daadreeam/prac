package com.lsw.prac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class MyTask {

    //3.添加定时任务
    @Scheduled(cron = "0 0/2 * * * ?") // 这里是每一分钟
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        log.info("task 现在时间 执行静态定时任务时间: " + LocalDateTime.now());
    }

    //3.添加定时任务
    @Scheduled(cron = "0 0/3 * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks2() {
        log.info("假设一个场景，我们Rabbitmq服务器有上万条未处理的消息，我们随便打开一个消费者客户端，会出现这种情况：巨量的消息瞬间全部推送过来，但是我们单个客户端无法同时处理这么多数据!此时很有可能导致服务器崩溃，严重的可能导致线上的故障。");
    }

    //3.添加定时任务
    @Scheduled(cron = "0 0/5 * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks3() {
        try {
            throw new RuntimeException("加上filebeat第3次模拟系统出错了啊 最外层 日志信息的格式怎么解决啊 -》 使用filebeat的正则+multiline来解决这个问题");
        } catch (RuntimeException e) {
//            String s = "";
//            StackTraceElement[] stackTrace = e.getStackTrace();
//            for (StackTraceElement stackTraceElement : stackTrace) {
//                s = s + " at " + stackTraceElement.toString();
//            }
            log.error("错误信息 " + e.getMessage());
            e.printStackTrace();
        }
    }


}
