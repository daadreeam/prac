package com.lsw.prac;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

//@Configuration
public class MyFilterConfig {

//    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        MyFilter myFilter = new MyFilter();
        registrationBean.setFilter(myFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
