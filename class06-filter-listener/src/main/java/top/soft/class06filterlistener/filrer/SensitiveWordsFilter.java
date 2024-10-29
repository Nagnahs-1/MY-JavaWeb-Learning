package top.soft.class06filterlistener.filrer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
//    敏感词集合
    private final List<String> list = new ArrayList<>();
//
    private final String methodName = "getParameter";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine())!= null){
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    response.setContentType("text/html;charset=utf-8");
// 通过代理 增强方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             if(methodName.equals(method.getName())){
                 String value = (String) method.invoke(request, args);
//                 Object invoke = (String)method.invoke(request, args);
                 if (value != null){
                     for(String s : list){
                         if(value.contains(s)){
                             value = value.replaceAll(s,"****");
                         }
                     }
                 }
                 return value;
             }

                return method.invoke(request, args);
            }

        });
        chain.doFilter(proxyReq, response);
    }
}
