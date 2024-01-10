package com.bjpowernode.bank.mvc;

import com.bjpowernode.bank.exceptions.AppException;
import com.bjpowernode.bank.exceptions.MoneyNotEnoughException;

import java.sql.SQLException;

public class AccountService {
    private AccountDao accountDao = new AccountDao();
    public void transfer(String formActno,String toActno,Double money) throws MoneyNotEnoughException, SQLException, AppException {
        Account formAct = accountDao.selectByActno(formActno);
        if (formAct.getBalance() > money) {
            throw new MoneyNotEnoughException("余额不足");
        }
        Account toAct = accountDao.selectByActno(toActno);
        formAct.setBalance(formAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.update(formAct);
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new AppException("转账失败");
        }
    }
}
