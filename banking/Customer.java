package banking;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setAccount(double balance) {
        Account account1 = new Account(balance);
         this.account = account1;
    }
    public Account getAccount() {
        return account;
    }
}
