import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext
 * 1.ServletContext是什么？
 *  ServletContext是接口，是Servlet规范中的一员
 * 2.ServletContext是谁实现的？
 *  Tomcat服务器（web服务器）实现了ServletContext接口
 * 3.ServletContext对象是什么时候创建的？在什么时候创建的？
 *  ServletContext对象是在web服务器启动的时候创建的
 *  ServletContext对象是在web服务器创建的
 *  对于一个webapp来说，ServletContext对象是唯一的
 *  ServletContext对象在服务器关闭时候销毁
 * 4.Context是什么意思？
 *  Servlet对象的环境对象（Servlet对象的上下文对象）
 *  ServletContext对象其实对应的就是整个webapp.xml文件
 *  放在ServletContext对象当中的数据，所有Servlet一定是共享的
 *  Tomcat是一个容器，一个容器可以放多个webapp，一个webapp对应一个ServletContext对象
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //获取ServletConfig对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象：" + application);
        //获取上下文的初始化信息
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print("<br/>" + name + "=" + value);
        }
    }
}