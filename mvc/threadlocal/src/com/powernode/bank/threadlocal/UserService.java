package com.powernode.threadlocal;

import org.w3c.dom.ls.LSOutput;

public class UserService {
    private UserDao userDao = new UserDao();
    public void save(){
        Thread thread = Thread.currentThread();
        Connection connection = DButil.getConnection();
        System.out.println(connection);
        System.out.println(thread);
        userDao.insert();
    }
}
