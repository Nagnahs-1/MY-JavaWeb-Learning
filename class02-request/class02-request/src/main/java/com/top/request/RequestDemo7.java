package com.top.request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    获取域对象
//        System.out.println("attribute 值"+req.getAttribute("msg"));
//        删除域对象
//        req.removeAttribute("msg");
        ServletContext context = req.getServletContext();
        String info = String.valueOf(context.getAttribute("info"));
        System.out.println("info"+info);
    }
}
