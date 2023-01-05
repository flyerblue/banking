package banking;

public class Account {
    private double balance ;
    public Account(double init_balance) {
        this.balance = init_balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public boolean deposit(double amt){
        this.balance += amt;
        return true;
    }
    public boolean withdraw(double amt){
        //判断余额是否足够
        if (this.balance>amt) {
            this.balance -= amt;
            return true;
        }else {
            System.out.println("余额不足");
            return false;
        }
    }
}
