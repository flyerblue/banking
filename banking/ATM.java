package banking;

import banking.domain.OverdraftException;
import java.util.Scanner;

import java.util.ArrayList;

public class ATM {
    public static void main(String[] args) {
         ArrayList<Bank> banks = new ArrayList<>();
         Customer customer;
         Account account;
         Scanner input = new Scanner(System.in);
         boolean exita = true;
         int bankid;
         int customerid  = 0;
         int accountid = 0;
         banks.add(new Bank("中国农业银行"));
        banks.add(new Bank("中国工商银行"));
        banks.add(new Bank("中国建设银行"));

         while (exita) {
             System.out.println("----------主界面---------------");
             System.out.println("-------1.注册-------");
             System.out.println("-------2.登录----------------");
             System.out.println("-------0.退出----------------");

             switch (input.nextInt()) {
                 case 0:
                     exita = false;
                     break;
                 case 1:
                     customerid  = 0;
                     System.out.println();
                     System.out.println();
                     System.out.println("注册界面");
                     System.out.println("============================================================");
                     for (int i = 0; i < banks.size(); i++) {
                         System.out.println("银行： "+banks.get(i).getNameBank()+"  "+"id:"+i);
                     }
                     System.out.println("选择银行");
                     bankid = input.nextInt();
                     if(bankid >= banks.size()){
                         System.out.println("不在范围内");
                         bankid = -1;
                     }
                     if(bankid == -1){
                         System.out.println("返回主界面...");
                         break;
                     }else {
                         boolean exitb = false;
                         System.out.println("银行： "+banks.get(bankid).getNameBank());
                         System.out.println("输入账户名（姓氏和名） 账号 密码");
                         customer = new Customer(input.next(), input.next(),input.nextInt(),input.nextInt());
                         Integer accountNumber = customer.getAccountNumber();
                         for (int i = 0; i < banks.get(bankid).getNumberOfCustomers(); i++) {
                             if(banks.get(bankid).getCustomers(i).getAccountNumber().intValue() == accountNumber){
                                 customer = banks.get(bankid).getCustomers(i);
                                 System.out.println("账号重复");
                                 System.out.println("返回主界面...");
                                 exitb = true;
                             }
                         }
                         if(exitb){
                             break;
                         }
                         banks.get(bankid).addcustomers(customer);
                         customer = banks.get(bankid).getCustomers(customerid);
                         while (exita) {
                             System.out.println("----------添加银行卡界面---------------");
                             System.out.println("============================================================");
                             System.out.println("-------1.添加储蓄卡-------");
                             System.out.println("-------2.添加信用卡----------------");
                             System.out.println("-------0.退出----------------");
                             switch (input.nextInt()) {
                                 case 0:
                                     exita = false;
                                     break;
                                 case 1:
                                     System.out.println("存款账户");
                                     System.out.println("输入账户余额和利息");
                                     customer.setAccount(new SavingAccount(input.nextDouble(), input.nextDouble()));
                                     accountid = banks.get(bankid).getCustomers(customerid).getNumberOfAccount() - 1;
                                     break;
                                 case 2:
                                     System.out.println("信用账户");
                                     System.out.println("输入账户余额和透支额度");
                                     customer.setAccount(new CheckingAccount(input.nextDouble(), input.nextDouble()));
                                     accountid = banks.get(bankid).getCustomers(customerid).getNumberOfAccount() - 1;
                                     break;
                                 default:
                                     System.out.println("重新选择");
                                     break;
                             }
                         }
                         exita = true;
                         customerid = banks.get(bankid).getNumberOfCustomers() - 1;
                     }

                     break;
                 case 2:
                     System.out.println();
                     System.out.println();
                     System.out.println("登录界面");
                     System.out.println("============================================================");
                     for (int i = 0; i < banks.size(); i++) {
                         System.out.println("银行： "+banks.get(i).getNameBank()+"  "+"id:"+i);
                     }
                     System.out.println("选择银行");
                     bankid = input.nextInt();
                     if(bankid >= banks.size()){
                         System.out.println("不在范围内");
                         System.out.println("返回主界面...");
                     }else {
                         boolean exitc = true;
                         System.out.println(""+banks.get(bankid).getNameBank());
                         System.out.println("============================================================");
                         System.out.println("输入客户账户密码");
                         int accountNumber = input.nextInt();
                         int password = input.nextInt();
                         for (int i = 0; i < banks.get(bankid).getNumberOfCustomers(); i++) {
                             if(banks.get(bankid).getCustomers(i).getPassword() == password && banks.get(bankid).getCustomers(i).getAccountNumber() == accountNumber){
                                 System.out.println("匹配成功");
                                 customerid = i;
                                 exitc = false;
                                 break;
                             }
                         }
                         if(exitc){
                             System.out.println("匹配失败");
                             System.out.println("返回主界面...");
                             break;
                         }
                         customer = banks.get(bankid).getCustomers(customerid);
                         boolean tip = false;
                         while (exita) {
                             if(!tip) {
                                 System.out.println("银行卡");
                                 for (int j = 0; j < customer.getNumberOfAccount(); j++) {
                                     System.out.println(customer.getFirstName()+" "+customer.getLastName()+"  "+"id:"+j);
                                     if(customer.getAccount(j) instanceof CheckingAccount){
                                         System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((CheckingAccount) customer.getAccount(j)).getOverdraftProtection()+"透支额");
                                     }
                                     if(customer.getAccount(j) instanceof SavingAccount){
                                         System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((SavingAccount) customer.getAccount(j)).getInterestRate() * 100+"% 利息");
                                     }
                                 }
                                 tip = true;
                                 System.out.println("选择银行卡");
                                 accountid = input.nextInt();
                             }
                             if(accountid > customer.getNumberOfAccount()&&accountid>=0){
                                 System.out.println("超出");
                                 System.out.println("返回主界面...");
                                 accountid = 0;
                                 break;
                             }
                             account = customer.getAccount(accountid);
                             System.out.println("----------菜单---------------");
                             System.out.println("-------1.查看当前银行卡余额-------");
                             System.out.println("-------2.取钱----------------");
                             System.out.println("-------3.存钱----------------");
                             System.out.println("-------4.添加银行卡----------------");
                             System.out.println("-------5.切换银行卡----------------");
                             System.out.println("-------7.输出交易记录----------------");
                             System.out.println("-------0.退出----------------");
                             System.out.print("请输入功能（1-4）：");

                             switch (input.nextInt()) {
                                 case 0:
                                     exita = false;
                                     break;
                                 case 1:
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
                                     while (exita) {
                                         System.out.println("----------添加银行卡界面---------------");
                                         System.out.println("============================================================");
                                         System.out.println("-------1.添加储蓄卡-------");
                                         System.out.println("-------2.添加信用卡----------------");
                                         System.out.println("-------0.退出----------------");
                                         switch (input.nextInt()) {
                                             case 0:
                                                 exita = false;
                                             case 1:
                                                 System.out.println("存款账户");
                                                 System.out.println("输入账户余额和利息");
                                                 customer.setAccount(new SavingAccount(input.nextDouble(), input.nextDouble()));
                                                 accountid = banks.get(bankid).getCustomers(customerid).getNumberOfAccount() - 1;
                                                 break;
                                             case 2:
                                                 System.out.println("信用账户");
                                                 System.out.println("输入账户余额和透支额度");
                                                 customer.setAccount(new CheckingAccount(input.nextDouble(), input.nextDouble()));
                                                 accountid = banks.get(bankid).getCustomers(customerid).getNumberOfAccount() - 1;
                                                 break;
                                             default:
                                                 System.out.println("重新选择");
                                                 break;
                                         }
                                     }
                                     exita = true;
                                     customerid = banks.get(bankid).getNumberOfCustomers() - 1;
                                     break;
                                 case 5:


                                     System.out.println(customer.getFirstName()+" "+customer.getLastName());
                                     for (int j = 0; j < customer.getNumberOfAccount(); j++) {
                                         if(customer.getAccount(j) instanceof CheckingAccount){
                                             System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((CheckingAccount) customer.getAccount(j)).getOverdraftProtection()+"透支额");
                                         }
                                         if(customer.getAccount(j) instanceof SavingAccount){
                                             System.out.println("账户余额：" + customer.getAccount(j).getBalance()+"有"+((SavingAccount) customer.getAccount(j)).getInterestRate() * 100+"% 利息");
                                         }
                                         System.out.println("id: "+j);
                                     }
                                     accountid = input.nextInt();
                                     break;
                                 case 7:
                                     for (int j = 0; j < customer.getNumberOfAccount(); j++) {
                                         System.out.println("银行卡 "+j);
                                         customer.getAccount(j).gettransactions();
                                     }
                                     break;
                                 default:
                                     System.out.println("重新输入");
                                     break;
                             }
                         }

                     }
                     break;
                 default:
                     System.out.println("重新输入");
                     break;
             }
         }
    }

}
