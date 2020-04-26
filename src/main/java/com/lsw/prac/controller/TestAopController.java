package com.lsw.prac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testAop")
@RestController
public class TestAopController {

    @RequestMapping("/test")
    public String testAop(){
        System.out.println("target方法体 执行了 com.lsw.prac.controller.TestAopController.testAop()");
        return "当前的时间戳是：" + System.currentTimeMillis();
    }
}
