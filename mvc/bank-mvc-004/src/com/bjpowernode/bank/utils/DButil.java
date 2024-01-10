package bank.utils;

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

    public static Connection getConnection() throws SQLException {
     Connection conn = DriverManager.getConnection(url,username,password);
     return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null){
            rs.close();
        }
        if (stmt != null){
            stmt.close();
        }
        if (conn != null){
            conn.close();
        }
    }

}
