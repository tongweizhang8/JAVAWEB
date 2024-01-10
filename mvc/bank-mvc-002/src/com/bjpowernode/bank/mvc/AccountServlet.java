package com.bjpowernode.bank.mvc;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formAction = req.getParameter("formAction");
        String toAction = req.getParameter("toAction");
        double money = Double.parseDouble(req.getParameter("money"));
        AccountService accountService = new AccountService();
        
    }
}
