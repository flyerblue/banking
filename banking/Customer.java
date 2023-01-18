package banking;
import banking.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int accountNumber;
    private int password;
    private ArrayList<Account> accounts= new ArrayList<>();

    public Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public Customer(String firstName, String lastName, Integer accountNumber, Integer password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setAccount(Account account) {
        accounts.add(account);
    }
    public Account getAccount(int index) {
        return accounts.get(index);
    }
    public int getNumberOfAccount() {
        return accounts.size();
    }
}
