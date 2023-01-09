import banking.*;

import java.util.Scanner;

public class TestBanking2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入客户名（姓氏和名）");
        Customer customer = new Customer(input.next(), input.next());
        System.out.println("输入账户余额");
        customer.setAccount(new Account(input.nextDouble()));
        System.out.println("客户"+customer.getFirstName()+" "+customer.getLastName()+"初始化了"+customer.getAccount().getBalance()+"余额");
        boolean bool = true;
        while (bool) {
            System.out.println("----------菜单---------------");
            System.out.println("-------1.查看账号户信息-------");
            System.out.println("-------2.取钱----------------");
            System.out.println("-------3.存钱----------------");
            System.out.println("-------4.退出----------------");
            System.out.print("请输入功能（1-4）：");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("客户"+customer.getLastName()+customer.getLastName()+" "+"账户余额：" + customer.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("输入取出金额：");
                    customer.getAccount().withdraw(input.nextDouble());
                    break;
                case 3:
                    System.out.print("输入存入金额：");
                    customer.getAccount().deposit(input.nextDouble());
                    break;
                case 4:
                    bool = false;
                    break;
                default:
                    System.out.println("重新输入");
                    break;
            }
        }
    }
}
