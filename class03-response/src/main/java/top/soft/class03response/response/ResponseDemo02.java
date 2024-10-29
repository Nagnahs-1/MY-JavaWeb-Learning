package top.soft.class03response.response;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.class03response.HelloServlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
@WebServlet("/ResponseDemo02")
public class ResponseDemo02 extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
//1.获取字节输出流
        ServletOutputStream out = resp.getOutputStream();
//2.输出数据
        out.write("你好".getBytes(StandardCharsets.UTF_8));
    }
}
