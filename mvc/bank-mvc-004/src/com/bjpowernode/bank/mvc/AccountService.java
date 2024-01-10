package bank.mvc;

import bank.utils.DButil;
import com.bjpowernode.bank.exceptions.AppException;
import com.bjpowernode.bank.exceptions.MoneyNotEnoughException;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    private AccountDao accountDao = new AccountDao();
    public void transfer(String formActno,String toActno,Double money) throws MoneyNotEnoughException, SQLException, AppException {
        try (Connection connection = DButil.getConnection()) {
            connection.setAutoCommit(false);
            Account formAct = accountDao.selectByActno(formActno,connection);
            if (formAct.getBalance() > money) {
                throw new MoneyNotEnoughException("余额不足");
            }
            Account toAct = accountDao.selectByActno(toActno,connection);
            formAct.setBalance(formAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);
            int count = accountDao.update(formAct,connection);
            count += accountDao.update(toAct,connection);
            if (count != 2) {
                throw new AppException("转账失败");
            }
            connection.commit();
        } catch (SQLException e) {
            throw new AppException("转账失败");
        }
    }
}
