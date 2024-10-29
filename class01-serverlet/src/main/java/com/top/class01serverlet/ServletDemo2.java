package com.top.class01serverlet;


import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo2 implements Servlet {

    /**
     * Servlet 初始化
     * 初始化方法，只调用一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
//    Servlet 接口的 init 方法的实现。当servlet被Web容器加载并准备服务时，
//    这个方法会被调用一次。在这个实现中，它简单地打印了一条消息到控制台，表明servlet已经被初始化
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo2 初始化");

    }

    /**
     * 获取Servlet 配置
     *
     * @return
     */
    @Override
//    这个方法应该返回封装了servlet初始化参数的 ServletConfig 对象。
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
//    service 方法是servlet的核心，负责处理所有进入的请求。
//    在这个实现中，它使用 getWriter 方法获取一个 PrintWriter 对象，并写入“ServletDemo2 Service”字符串作为响应内容。
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("ServletDemo2 Service");

    }

    /***
     * 获取 Servlet信息
     * @return
     */
    @Override
//返回一个描述servlet的字符串
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     */
    @Override
//    destroy 方法在servlet不再需要，并且服务器决定卸载它时调用。
    public void destroy() {
        System.out.println("ServletDemo2 销毁");
    }
}
