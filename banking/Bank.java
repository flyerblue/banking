package banking;
import banking.*;
public class Bank {
    private Customer[] customers;
    private int numberOfCustomers = 0;
    public Bank() {
        this.customers = new Customer[20];
    }
    public void addcustomers(String f,String l){
        Customer customer = new Customer(f,l);
        customers[numberOfCustomers++] = customer;
    }
    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
    public Customer getCustomers(int index) {
        return customers[index];
    }
}
