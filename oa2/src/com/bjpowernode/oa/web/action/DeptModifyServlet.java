package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DButil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决请求体的中文乱码问题
        req.setCharacterEncoding("utf-8");
        //获取表单中的数据
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        //连接数据库，执行更新语句
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DButil.getConnection();
            String url = "update dept set dname=?,loc=? where deptno=?";
            ps = conn.prepareStatement(url);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.getUpdateCount();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.close(conn, ps, null);
        }
        if (count == 1) {
            //更新成功
            //跳转到部门列表页面（部门列表页面是通过java程序自动生成的，所以还需要执行另一个Service
            req.getRequestDispatcher("/dept/list").forward(req, resp);
        }else {
            //更新失败
            req.getRequestDispatcher("/error.html").forward(req, resp);
        }
    }
}
