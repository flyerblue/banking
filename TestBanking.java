/*

import java.util.Scanner;
import banking.*;
import banking.domain.OverdraftException;

public class TestBanking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = Bank.getBank();
        boolean onoff = true;
        int index = -1;
        while (onoff) {
            if(index == -1){
                index = 0;
                System.out.println("请先添加账户");
                System.out.println("输入账户名（姓氏和名）");
                bank.addcustomers(input.next(), input.next());
                Customer customer = bank.getCustomers(index);

                System.out.println("存款账户");
                System.out.println("输入账户余额和利息");
                customer.setAccount(new SavingAccount(input.nextDouble(),input.nextDouble()));
                System.out.println("信用账户");
                System.out.println("输入账户余额和透支额度");
                customer.setAccount(new CheckingAccount(input.nextDouble(),input.nextDouble()));
                index = bank.getNumberOfCustomers() - 1;
            }
            Customer customer = bank.getCustomers(index);
            System.out.println("选择账户");
            System.out.println("0.存款账户");
            System.out.println("1.透支账户");
            Account account = customer.getAccount(input.nextInt());
            System.out.println("----------菜单---------------");
            System.out.println("-------1.查看当前账户余额-------");
            System.out.println("-------2.取钱----------------");
            System.out.println("-------3.存钱----------------");
            System.out.println("-------4.添加用户----------------");
            System.out.println("-------5.切换用户----------------");
            System.out.println("-------6.输出用户列表----------------");
            System.out.println("-------7.输出交易记录----------------");
            System.out.println("-------0.退出----------------");
            System.out.print("请输入功能（1-4）：");

            switch (input.nextInt()) {
                case 0:
                onoff = false;
                break;
                case 1:
                    customer = bank.getCustomers(index);
                    System.out.println(customer.getFirstName()+" "+customer.getLastName());
                        if(account instanceof CheckingAccount){
                            System.out.println("账户余额：" + account.getBalance()+"有"+((CheckingAccount) account).getOverdraftProtection()+"透支额");
                        }
                        if(account instanceof SavingAccount){
                            System.out.println("账户余额：" + account.getBalance()+"有"+((SavingAccount) account).getInterestRate() * 100+"% 利息");
                        }
                    break;
                case 2:
                    System.out.print("输入取出金额：");
                    try {
                        account.withdraw(input.nextDouble());
                    } catch (OverdraftException e) {
                        System.out.println("异常 : "+e.getMessage());
                    }

                    System.out.println("当前账户余额：" + account.getBalance());
                    break;
                case 3:
                    System.out.print("输入存入金额：");
                    account.deposit(input.nextDouble());
                    System.out.println("当前账户余额：" + account.getBalance());
                    break;
                case 4:
                    System.out.println("请先添加账户");
                    System.out.println("输入账户名（姓氏和名）");
                    bank.addcustomers(input.next(), input.next());
                    index = bank.getNumberOfCustomers() - 1;
                    customer = bank.getCustomers(index);
                    System.out.println("存款账户");
                    System.out.println("输入账户余额和利息");
                    customer.setAccount(new SavingAccount(input.nextDouble(),input.nextDouble()));
                    System.out.println("信用账户");
                    System.out.println("输入账户余额和透支额度");
                    customer.setAccount(new CheckingAccount(input.nextDouble(),input.nextDouble()));

                    break;
                case 5:
                    index = input.nextInt() - 1;
                    break;
                case 6:
                    CustomerReport.generateReport();
                    break;
                case 7:
                    customer.getAccount(0).gettransactions();
                    customer.getAccount(1).gettransactions();
                    break;
                default:
                    System.out.println("重新输入");
                    break;
            }
        }
    }
}
*/
