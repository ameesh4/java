class BankAccount{
    private String name;
    private double balance;
    private int accountNumber;

    public BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
        else {
            System.out.println("Insufficient funds");
        }
    }
    public double getBalance(){
        return this.balance;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }

    public String getName(){
        return this.name;
    }

    void displayBalance(){
        System.out.println("Account balance: " + balance);
    }
}

class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String name, double balance, double interestRate){
        super(name, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = getBalance() * interestRate / 100;
        super.deposit(interest);
    }
}

class CheckingAccount extends BankAccount{
    private double overdraft;

    public CheckingAccount(String name, double balance, double overdraft){
        super(name, balance);
        this.overdraft = overdraft;
    }
    @Override
    public void withdraw(double amount){
        if(getBalance() + overdraft >= amount){
            super.withdraw(amount);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayBalance(){
        System.out.println("Account balance: " + getBalance() + " Overdraft: " + overdraft);
    }
}

class Banks{
    public static void main (String[] args){
        BankAccount account = new BankAccount("John Doe", 1000);
        account.deposit(500);
        account.withdraw(200);
        account.displayBalance();

        SavingsAccount savings = new SavingsAccount("Jane Doe", 2000, 5);
        savings.addInterest();
        savings.displayBalance();

        CheckingAccount checking = new CheckingAccount("John Smith", 1000, 500);
        checking.withdraw(2000);
        checking.displayBalance();
    }
}

