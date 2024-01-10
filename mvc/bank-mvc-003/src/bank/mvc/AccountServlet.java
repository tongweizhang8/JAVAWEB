package com.bjpowernode.bank.mvc;

import com.bjpowernode.bank.exceptions.AppException;
import com.bjpowernode.bank.exceptions.MoneyNotEnoughException;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formAction = req.getParameter("formAction");
        String toAction = req.getParameter("toAction");
        double money = Double.parseDouble(req.getParameter("money"));
        AccountService accountService = new AccountService();
        try {
            accountService.transfer(formAction,toAction,money);
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        } catch (MoneyNotEnoughException e) {
            resp.sendRedirect(req.getContextPath() + "/moneyNotEnough.jsp");
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
