import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //获取ServletConfig对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象：" + application);
    }
}
