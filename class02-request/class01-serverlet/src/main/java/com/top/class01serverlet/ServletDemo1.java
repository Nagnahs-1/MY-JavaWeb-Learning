package com.top.class01serverlet;


import jakarta.servlet.*;

import java.io.IOException;
//实现了 Servlet 接口
public class ServletDemo1 implements Servlet {
//    当servlet被Web容器加载并准备服务时，这个方法会被调用。在这个实现中，它简单地打印了一条消息到控制台，表明servlet已经被初始化。
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo1 初始化");

    }

    /**
     * 获取Servlet 配置
     */
    @Override
//    获取Servlet配置方法 返回封装了servlet初始化参数的 ServletConfig 对象
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务得方法
     *
     * @param servletRequest  请求参数
     * @param servletResponse 响应参数
     * @throws ServletException
     * @throws IOException
     */
    @Override
//    首先设置了响应的字符编码为UTF-8，然后使用 getWriter 方法获取一个 PrintWriter 对象，并写入“ServletDemo1 Service 方法”字符串作为响应内容
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write("ServletDemo1 Service 方法");

    }

    /***
     * 获取 Servlet信息
     */
    @Override
//获取Servlet信息方法
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     */
    @Override
//    这个方法提供了释放servlet所占用的资源的机会。在这个实现中，它简单地打印了一条消息到控制台，表明servlet已经被销毁
    public void destroy() {
        System.out.println("Servlet 销毁");
    }
}
