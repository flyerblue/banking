package banking;

public class CheckingAccount extends Account{
    private double overdraftProtection;
    public CheckingAccount(double init_balance, double overdraftProtection) {
        super(init_balance);
        this.overdraftProtection = overdraftProtection;
    }
    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    @Override
    public boolean withdraw(double amt) {
        if(balance - amt >= 0){
            balance -= amt;
            return true;
        } else if (balance + overdraftProtection - amt >= 0) {
            balance -= amt;
            return true;
        }else {
            return false;
        }
    }
}
