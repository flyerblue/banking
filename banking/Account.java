package banking;

import banking.domain.OverdraftException;

import java.util.ArrayList;

public class Account {
    protected double balance ;
    private int id;
    public ArrayList<Transaction> transactions = new ArrayList<>();
    public Account(double init_balance) {
        this.balance = init_balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double amt){
        this.balance += amt;
        transactions.add(new Transaction('D',amt,this.balance,"存款"));
    }
    public void withdraw(double amt) throws OverdraftException{
        //判断余额是否足够
        if (this.balance>amt) {
            this.balance -= amt;
            transactions.add(new Transaction('W',amt,this.balance,"取现"));
        }else {
            throw new OverdraftException("余额不足",amt - balance);
        }
    }
    public void gettransactions(){
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).toSting());
        }
    }
}
