package bank.mvc;

import java.util.Objects;

public class Account {
    private Long id;
    private String actno;

    public Account() {
        
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    private Double balance;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(actno, account.actno) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actno, balance);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(String actno) {
        this.actno = actno;
    }

    public Account(Long id, String name, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }
}
