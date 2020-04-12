package com.lsw.prac;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/*")
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2过滤器 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("2服务器响应前");
//        System.out.println("servletRequest.getLocalName() = " + servletRequest.getLocalName());
//        System.out.println("servletRequest.getServerName() = " + servletRequest.getServerName());
//        ServletContext servletContext = servletRequest.getServletContext();
//        System.out.println("servletContext.getRealPath() = " + servletContext.getRealPath("s"));
        // 分界线为是否调用了chain.doFilter(),执行该方法之前，即对用户请求进行预处理；执行该方法之后，即对服务器响应进行后处理。
        filterChain.doFilter(servletRequest,servletResponse);
        // 服务器响应后处理
        System.out.println("2服务器响应了");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器2 destroy");
    }
}
