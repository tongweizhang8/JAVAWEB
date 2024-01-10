package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DButil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeptListServlet extends HttpServlet {
    //处理doPost请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取应用的根路径
        String contextPath = req.getContextPath();
        //设置响应的内容类型以及字符集，防止中文乱码问题
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门列表界面</title>");
        out.print("<script type='text/javascript'>");
        out.print("    function del(deptno) {");
        out.print("        if(window.confirm('Are you sure to delete this department?')) {");
        out.print("           document.location.href = 'oa/dept/delete?deptno='+deptno;");
        out.print("        }");
        out.print("    }");
        out.print("</script>");
        out.print("    </head>");
        out.print("    <bady>");
        out.print("        <h1>部门列表</h1>");
        out.print("        <hr>");
        out.print("        <table border='1px' align='center' width='50%'>");
        out.print("            <tr>");
        out.print("                <th>序号</th>");
        out.print("                <th>部门编号</th>");
        out.print("                <th>部门名称</th>");
        out.print("                <th>操作</th>");
        out.print("            </tr>");
        //上面一部分是死的
        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取链接
            conn = DButil.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果及
            int i = 0;
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("                <tr>");
                out.print("                <th>"+(++i)+"</th>");
                out.print("                <th>"+deptno+"</th>");
                out.print("                <th>"+dname+"</th>");
                out.print("                <td>");
                out.print("                    <a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                out.print("                    <a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
                out.print("                    <a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.print("                </td>");
                out.print("            </tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DButil.close(conn,ps, rs);
        }
        //下面一部分是死的
        out.print("        </table>");
        out.print("        <hr>");
        out.print("        <a href='"+contextPath+"/add.html'>添加部门</a>");
        out.print("    </bady>");
        out.print("</html>");
    }
}
