package top.soft.brandlist.servlet;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.brandlist.entity.Brand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从HTTP请求中获取名为 id 的参数值
        String idStr = req.getParameter("id");
//        将获取到的字符串 idStr 转换为整数 id
        int id = Integer.parseInt(idStr);
        // 获取或初始化brands列表
//        从 ServletContext 中获取名为 brands 的属性
        List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");
//        如果 brands 为 null，说明还没有初始化或者没有设置该属性
        if (brands == null) {
            //            初始化一个新的 ArrayList 并将其设置为 ServletContext 中的 brands 属性
            brands = new ArrayList<>();
            req.getServletContext().setAttribute("brands", brands);
        }
        // 查找并移除指定ID的品牌
        boolean removed = false;
//        使用 for 循环遍历 brands 列表。
//对于每个品牌，检查其 id 是否与要删除的 id 相等。
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getId() == id) {
                brands.remove(i);
                removed = true;
                break; // 找到并移除后退出循环
            }
        }
        // 更新ServletContext中的brands列表,将更新后的 brands 列表重新设置回 ServletContext 中
        req.getServletContext().setAttribute("brands", brands);
    }
}
