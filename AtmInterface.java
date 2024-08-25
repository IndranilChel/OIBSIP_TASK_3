package oasis_infobyte.intern;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double Initial_Balance) {
        this.balance = Initial_Balance;
    }
    public void deposit(double Amount) {
        if (Amount > 0) {
            balance += Amount;
            System.out.println("Deposit Successful. Current balance: $ " + balance);
        } else {
            System.out.println("Invalid deposit Amount");
        }
    }

    public boolean withdraw(double Amount) {
        if (Amount > 0 && Amount <= balance) {
            balance -= Amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
            return true;
        } else if (Amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount");
            return false;
        }
    }
    public void check_Balance() {
        System.out.println("Current Balance: $" + balance);
    }
}
 class ATM {
    private BankAccount account;
    public Scanner S1;

    public ATM(BankAccount account) {
        this.account = account;
        this.S1 = new Scanner(System.in);
    }
    public void start() {
        int choice;
        do {
            Menu();
            choice = S1.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. please try again.");
            }
        } while (choice != 4);
    }

    private void Menu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("Enter your Choice: ");
    }

    private void deposit() {
        System.out.println("Enter the amount to deposit: ");
        double Amount = S1.nextDouble();
        account.deposit(Amount);
    }

    public void withdraw() {
        System.out.println("Enter the amount to withdraw: ");
        double Amount = S1.nextDouble();
        account.withdraw(Amount);
    }

    private void checkBalance() {
        account.check_Balance();
    }
}
public class AtmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM machine = new ATM(account);
        machine.start();
    }

}
