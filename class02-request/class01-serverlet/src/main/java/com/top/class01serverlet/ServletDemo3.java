package com.top.class01serverlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

//这个 @WebServlet 注解用于将 ServletDemo3 类声明为一个 Servlet，并指定了它的几个关键属性：
@WebServlet(name = "servletDemo3", //指定了 Servlet 的名称为 servletDemo3
        value = "/servlet3",//指定了访问该 Servlet 的 URL 模式为 /servlet3。客户端可以通过这个 URL 来请求 Servlet。
        loadOnStartup = 2//指定了 Servlet 的加载顺序。
)
public class ServletDemo3 implements Servlet {

    /**
     * Servlet 初始化
     * 初始化方法，只调用一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    //这是 Servlet 接口的 init 方法的实现。当 Servlet 被 Web 容器加载并准备服务时，这个方法会被调用一次
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo3 初始化");

    }

    /**
     * 获取Servlet 配置
     */
    @Override
    //这个方法应该返回封装了 Servlet 初始化参数的 ServletConfig 对象。
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
    //service 方法是 Servlet 的核心，负责处理所有进入的请求。
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("ServletDemo3 Service");

    }

    /***
     * 获取 Servlet信息
     */
    @Override
    //这个方法应该返回一个描述 Servlet 的字符串
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     */
    @Override
    //destroy 方法在 Servlet 不再需要，并且服务器决定卸载它时调用
    public void destroy() {
        System.out.println("ServletDemo3 销毁");
    }
}
