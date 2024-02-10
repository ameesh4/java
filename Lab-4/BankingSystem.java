abstract class BankAccount{
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    abstract void PerformAccountMaintanance();
}

interface Transaction{
    double deposit(double amount);
    double withdraw(double amount);
}

class SavingAccount extends BankAccount implements Transaction{
    private double interestRate;

    public SavingAccount(String accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    @Override
    public double withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
        else {
            System.out.println("Insufficient funds");
        }
        return balance;
    }

    public void applyInterest(){
        double interest = balance * interestRate / 100;
        deposit(interest);
    }

    public void PerformAccountMaintanance(){
        System.out.println("Maintaining Saving Account");
    }
}

public class BankingSystem{
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("12345", 1000, 5);
        savingAccount.displayAccountInfo();
        savingAccount.deposit(500);
        savingAccount.displayAccountInfo();
        savingAccount.withdraw(200);
        savingAccount.displayAccountInfo();
        savingAccount.applyInterest();
        savingAccount.displayAccountInfo();
        savingAccount.PerformAccountMaintanance();
    }
}