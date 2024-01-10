package bank.mvc;

import com.bjpowernode.bank.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public int insert(Account act,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        int count = 0;
        try {
            String sql = "insert into t_act (actno,balance) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,act.getActno());
            ps.setDouble(2,act.getBalance());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(null,ps,null);

        }
        return 0;
    }
    public int update(Account act,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        int count = 0;
        try {
            String sql = "update t_act set balance = ? , actno = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,act.getBalance());
            ps.setString(2,act.getActno());
            ps.setLong(3,act.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(null,ps,null);

        }
        return 0;
    }
    public int deleteById(Long id,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        int count = 0;
        try {
            String sql = "delete from t_act where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(null,ps,null);

        }
        return 0;
    }
    public Account selectByActno(String actno,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account act = null;
        try {
            String sql = "select id , balance from t_act where actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,actno);
            rs = ps.executeQuery();
            if (rs.next()){
                Long id = rs.getLong("id");
                Double balance = rs.getDouble("balance");
                act = new Account();
                act.setId(id);
                act.setBalance(balance);
                act.setActno(actno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DButil.close(null,ps,rs);
        }
        return null;
    }
    public List<Account> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            String sql = "select id , balance , actno from t_act";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                Double balance = rs.getDouble("balance");
                String actno = rs.getString("actno");
                Account act = new Account();
                act.setId(id);
                act.setActno(actno);
                act.setBalance(balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DButil.close(conn,ps,rs);
        }
        return null;
    }
}
