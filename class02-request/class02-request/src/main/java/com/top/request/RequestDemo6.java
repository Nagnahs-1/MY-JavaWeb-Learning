package com.top.request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("RequestDemo6 被请求");
       resp.getWriter().write("RequestDemo6");
       req.setAttribute("msg", "hello");
       ServletContext context = req.getServletContext();
       getServletContext().setAttribute("info", "hello");
    }
}
