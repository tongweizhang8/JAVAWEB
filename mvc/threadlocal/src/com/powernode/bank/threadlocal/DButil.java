package com.powernode.threadlocal;

public class DButil {
    private static MyThreadLocal<Connection> myThreadLocal = new MyThreadLocal<>();

    /**
     * 每一次都调用这个方法来获取Connection对象
     * @return
     */
    public static Connection getConnection() {
        Connection connection = myThreadLocal.get();
        if (connection == null) {
            //第一次调用getConnection()方法的时候,connection一定是空的
            //空的就new一次
            connection = new Connection();
            //将new的connection对象绑定到Map集合中
            myThreadLocal.set(connection);
        }
        return connection;
    }
}
