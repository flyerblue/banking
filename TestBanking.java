
import java.util.Scanner;
import banking.Account;

public class TestBanking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入初始余额");
        Account account = new Account(input.nextInt());
        boolean bool = true;
        while (bool) {
            System.out.println("----------菜单---------------");
            System.out.println("-------1.查看当前账户余额-------");
            System.out.println("-------2.取钱----------------");
            System.out.println("-------3.存钱----------------");
            System.out.println("-------4.退出----------------");
            System.out.print("请输入功能（1-4）：");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("账户余额：" + account.getBalance());
                    break;
                case 2:
                    System.out.print("输入取出金额：");
                    account.withdraw(input.nextDouble());
                    System.out.println("当前账户余额：" + account.getBalance());
                    break;
                case 3:
                    System.out.print("输入存入金额：");
                    account.deposit(input.nextDouble());
                    System.out.println("当前账户余额：" + account.getBalance());
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
