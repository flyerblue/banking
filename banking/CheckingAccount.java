package banking;

import banking.domain.OverdraftException;

public class CheckingAccount extends Account{
    private double overdraftProtection;
    public CheckingAccount(double init_balance, double overdraftProtection) {
        super(init_balance);
        this.overdraftProtection = overdraftProtection;
    }

    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    @Override
    public void withdraw(double amt) throws OverdraftException{
        if(balance - amt >= 0){
            balance -= amt;
            transactions.add(new Transaction('W',amt,this.balance,"取现"));
        } else if (balance + overdraftProtection - amt >= 0) {
            balance -= amt;
            transactions.add(new Transaction('W',amt,this.balance,"取现"));
        }else {
            throw new OverdraftException("透支额不足",amt);
        }
    }
}
