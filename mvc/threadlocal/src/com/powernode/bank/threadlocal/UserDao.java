package com.powernode.threadlocal;

public class UserDao {
    public void insert(){
        Thread thread = Thread.currentThread();
        Connection connection = DButil.getConnection();
        System.out.println(connection);
        System.out.println(thread);
        System.out.println("insert");
    }
}
