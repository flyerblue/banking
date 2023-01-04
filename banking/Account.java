package banking;

public class Account {
    double balance ;
    public Account(double init_balance) {
        this.balance = init_balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double amt){
        this.balance += amt;
    }
    public void withdraw(double amt){
        //判断余额是否足够
        if (this.balance-amt>0) {
            this.balance -= amt;
        }else {
            System.out.println("余额不足");
        }
    }
}
