package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/getCaptchaImage")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 45;
//        1.创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        2.美化图片 创建画笔对象
        Graphics g = image.getGraphics();
//        3设置画笔颜色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        String str = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

//        生成随机角标
        Random random = new Random();
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i <= 3; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            stringbuilder.append(ch);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            Font font = new Font("Dialog", Font.BOLD, 20);
            g.setFont(font);
            g.drawString(ch + " ", width / 4 * i, height / 2);
        }
//        生成干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }
        // 将验证码文本保存到session
        HttpSession session = req.getSession();
        session.setAttribute("captcha", stringbuilder.toString());
//        将验证码图片展现到页面上
        ImageIO.write(image, "jpg", resp.getOutputStream());
//        g.dispose();
    }
    }

