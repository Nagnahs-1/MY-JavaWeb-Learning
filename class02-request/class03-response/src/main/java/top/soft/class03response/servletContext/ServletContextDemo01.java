package top.soft.class03response.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/servletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取serveletContext对象
        ServletContext servletContext = req.getServletContext();
//        获取文件文件名
        String filename = "hello.pdf";
//        获取资源文件类型
        String mimeType=servletContext.getMimeType(filename);
        System.out.println(mimeType);
    }
}
