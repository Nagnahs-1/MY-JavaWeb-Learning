package top.soft.class03response.pratice;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/DownloadSer")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     获取文件名
       String filename = req.getParameter("filename");
//       获取ServletContext 对象
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("/img/"+filename);
//        用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
//        获取文件的媒体类型
        String mimeType = context.getMimeType(filename);
//        设置响应的Content-type
        resp.setContentType(mimeType);
//        设置响应头打开方式
        resp.setHeader("Content-Disposition", "attachment; filename="+filename);
//    将输入流
        ServletOutputStream out = resp.getOutputStream();
    byte[] buffer = new byte[1024*8];
    int len = 0;
    while ((len = fis.read(buffer)) != -1) {
        out.write(buffer, 0, len);
    }
    fis.close();

    }
}
