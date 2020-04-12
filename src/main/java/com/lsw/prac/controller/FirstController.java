package com.lsw.prac.controller;

import cn.hutool.core.date.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping("/test")
    public String test(@RequestParam(value = "param",required = false) String paramStr){
        String str = "修改2 hello aliyun 当前时间：" + DateTime.now() + " 请求的参数是: " + paramStr;
        System.out.println(str);
        return str;
    }
}
