package com.powernode.bank.bank.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * jdbc工具类
 */
public class DButil {
    private DButil(){}

    private static ResourceBundle bundle = ResourceBundle.getBundle(("resource/jdbc"));
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ThreadLocal<Connection> local = new ThreadLocal<>();
    public static Connection getConnection() throws SQLException {
        Connection conn = local.get();
        if (conn == null) {
            conn = DriverManager.getConnection(url,username,password);
            local.remove();
        }
     return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null){
            try {
                conn.close();
                //为什么connection关闭,还要从Map中移除呢?
                //根本原因是:Tomcat服务器是支持线程池的,也就是说,一个人用过了t1线程,还会被其他用户使用
                local.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
