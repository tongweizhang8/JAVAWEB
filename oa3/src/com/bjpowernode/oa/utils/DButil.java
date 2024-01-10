package com.bjpowernode.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

/*
jdbc的工具类
 */
public class DButil {
    //静态变量，在类加载时执行，
    //有顺序，自上而下
    //属性资源文件绑定
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    //根据属性配置文件key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");
    static{
        //注册驱动
        //注册驱动只注册一次，放在静态代码块中，DBUtils类加载时候执行。
        try {
            //"com.mysql.jdbc.Driver"是连接数据的驱动，不能写死，因为以后可能会链接Oracle，SQLServer等其他数据库
            //如果连结Oracle数据库的时候，还需要修改Java代码，显然违背ocp原则
            //ocp开闭原则：对扩展开放，对修改关闭。（什么是符合ocp？在进行功能扩展的时候，不要修改源代码）
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *获取数据库连接对象
     * @return Connection 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        //获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 释放资源
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
