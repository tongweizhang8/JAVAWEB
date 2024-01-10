package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DButil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取部门的信息
        //注意乱码问题
        req.setCharacterEncoding("utf-8");
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        //连接数据库执行insert
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DButil.getConnection();
            String url = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(url);
            ps.setString(1, dname);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(conn, ps, null);
        }
        if (count == 1) {
            //保存成功跳转到列表页面
            req.getRequestDispatcher("/dept/list").forward(req, resp);
        }else {
            //保存失败跳转到错误页面
            req.getRequestDispatcher("/error.html").forward(req, resp);
        }
    }
}
