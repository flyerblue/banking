package banking;
import banking.*;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();
    private String nameBank;

    public Bank() {
        customers = new ArrayList<>();
    }

    public Bank( String nameBank) {
        this.nameBank = nameBank;
    }


    private static Bank bankInstance= null;
    public void addcustomers(Customer customer){
        customers.add(customer);
    }
    public static Bank getBank() {
        if(bankInstance==null){
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public String getNameBank() {
        return nameBank;
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }
    public Customer getCustomers(int index) {
        return customers.get(index);
    }
}
