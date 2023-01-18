package banking;

public class Transaction {
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public String toSting(){
        return "交易类型:" + type + "  发生额：" + amount + "  余额：" + balance + "    备注:" + description;
    }
}
