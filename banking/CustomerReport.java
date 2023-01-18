package banking;
import banking.*;

public class CustomerReport {
    public static void generateReport(Bank bank){
        Customer customer;
        System.out.println("用户报表");
        System.out.println("+++++++++++++");
        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            customer = bank.getCustomers(i);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+"  账号"+ customer.getAccountNumber());
            for (int j = 0; j < customer.getNumberOfAccount(); j++) {
                if(customer.getAccount(j) instanceof CheckingAccount){
                    System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((CheckingAccount) customer.getAccount(j)).getOverdraftProtection()+"透支额");
                }
                if(customer.getAccount(j) instanceof SavingAccount){
                    System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((SavingAccount) customer.getAccount(j)).getInterestRate() * 100+"% 利息");
                }
            }
        }
    }

}
