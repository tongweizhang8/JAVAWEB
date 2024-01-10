package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {

    //无参数构造方法
    public AServlet(){
        System.out.println("AServlet的无参数构造方法");
    }
//    //程序员手动提供AServlet的有参数构造方法，会怎样
//    public AServlet(String s){
//
//    }
    //init被翻译成初始化
    //init方法只执行一次
    //在AServlet对象第一次被创建之后被执行
    //init方法通常是完成初始化操作的
    //init方法在执行时时候AServlet对象已经被创建了
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet的init方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service方法：是处理用户请求的核心方法
    //只要用户发送一次请求，service方法必然执行一次
    //发送100次请求，service方法就执行100次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet的service方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //destory方法也执行一次
    //Tomcat服务器在销毁AServlet对象之前，会先调用AServlet的destory方法
    //destory方法在执行的时候，AServlet对象的内存还没有被销毁，即将被销毁
    //destory方法中可以编写销毁前的准备
    //比如说，服务器关闭的时候，AServlet对象开启了一些资源，这些资源可能是流，可能是数据库连结
    //那么，关闭服务器的时候，要关闭这些流，关闭这些数据库连结，那么这些关闭资源的代码就可以写到destory方法
    @Override
    public void destroy() {
        System.out.println("AServlet的destroy方法");
    }
}
