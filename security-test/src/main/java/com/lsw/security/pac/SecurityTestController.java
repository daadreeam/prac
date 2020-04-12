package com.lsw.security.pac;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityTestController {
    @GetMapping("/test/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_admin')")
//    @PostAuthorize("hasRole('admin')")
    public String test(){
        System.out.println("admin");
        return "spring securtiy only admin";
    }

    @GetMapping("/test/test")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_test')")
    public String test2(){
        System.out.println("test");
        return "spring securtiy only test";
    }

    @GetMapping("/test/noAuth")
//    @PreAuthorize("hasAuthority('test')")
    @PreAuthorize("hasAuthority('admin')")
    @ResponseBody
//    @PreAuthorize("hasRole('test')")
    public String test3(){
        System.out.println("/test/noAuth");
        return "@PreAuthorize(\"hasAuthority('admin')\")";
    }
    @GetMapping("/test/noAuth2")
//    @PreAuthorize("hasAuthority('test')")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    @ResponseBody
//    @PreAuthorize("hasRole('test')")
    public String test4(){
        System.out.println("/test/noAuth");
        return "@PreAuthorize(\"hasAuthority('ROLE_admin')\")";
    }

    @GetMapping("/test/login")
    public String login(){
        System.out.println("login");
        return "/login.html";
    }
    @GetMapping("/who")
    @ResponseBody
    public Object who(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
