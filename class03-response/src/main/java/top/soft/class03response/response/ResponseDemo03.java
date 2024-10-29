package top.soft.class03response.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/responseType")
public class ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "img":
                getImage(req, resp);
                break;
            case "pdf":
                 getPdf(req, resp);
                 break;
            case "json":
                getJson(req, resp);
                break;
            case "html":
                getHtml(req, resp);
                break;

            default:
                break;
        }
    }

    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath+"/img/image.png");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath+"/pdf/pdftest.pdf");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath+"/json/jsontest.json");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }
    private void getHtml(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath+"/html/htmltest.html");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }
}
