
import java.util.Scanner;
import banking.*;

public class TestBanking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank= new Bank();
        boolean onoff = true;
        int index =- -1;
        while (onoff) {
            if(index == -1){
                System.out.println("请先添加账户");
            }
            System.out.println("----------菜单---------------");
            System.out.println("-------1.查看当前账户余额-------");
            System.out.println("-------2.取钱----------------");
            System.out.println("-------3.存钱----------------");
            System.out.println("-------4.添加账户----------------");
            System.out.println("-------5.切换账户----------------");
            System.out.println("-------6.输出账户列表----------------");
            System.out.println("-------0.退出----------------");
            System.out.print("请输入功能（1-4）：");
            Customer customer = bank.getCustomers(index-1);
            switch (input.nextInt()) {
                case 0:
                onoff = false;
                break;
                case 1:
                    System.out.println("账户余额：" + customer.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("输入取出金额：");
                    if(customer.getAccount().withdraw(input.nextDouble())){
                        System.out.println("true");
                    }else {
                        System.out.println("false");
                    }
                    System.out.println("当前账户余额：" + customer.getAccount().getBalance());
                    break;
                case 3:
                    System.out.print("输入存入金额：");
                    if(customer.getAccount().deposit(input.nextDouble())){
                        System.out.println("true");
                    }else {
                        System.out.println("false");
                    }
                    System.out.println("当前账户余额：" + customer.getAccount().getBalance());
                    break;
                case 4:
                    System.out.println("输入账户名（姓氏和名）");
                    bank.addcustomers(input.next(), input.next());
                    index = bank.getNumberOfCustomers();
                    System.out.println("输入账户余额");
                    bank.getCustomers(index-1).setAccount(new Account(input.nextDouble()));
                    break;
                case 5:
                    index = input.nextInt();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("重新输入");
                    break;
            }
        }
    }
}
