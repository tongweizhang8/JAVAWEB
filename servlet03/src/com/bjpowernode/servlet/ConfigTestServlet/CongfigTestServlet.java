package com.bjpowernode.servlet.ConfigTestServlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/*
ServletConfig是什么？
    1.jakatrta.servlet.ServletConfig
      显然ServletConfig是Servlet规范中的一员
      ServletConfig是一个接口（jakarta.servlet.ServletConfig是一个接口）
    2.谁去实现这个接口？
        public class GenericServlet implements Servlet, ServletConfig, Serializable{}
        结论：Tomcat服务器实现了ServletConfig接口
        思考：如果把Tomcat服务器换成jetty服务器，输出ServletConfig对象的时候，还是这个结果吗
             不一定一样，包名类型可能和Tomcat不一样，但是他们都实现了ServletConfig这个规范
 */
public class CongfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        //输出该对象
        out.print("ServletConfig对象：" + config);
    }
}
