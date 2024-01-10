package com.powernode.bank.web;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.service.AccountService;
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
