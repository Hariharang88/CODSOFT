import java.util.Scanner;

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Welcome to the ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice :");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose from the available options.");
            }
        } while (option != 4);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        double amount;

        System.out.println("Enter the amount you want to withdraw:");
        amount = scanner.nextDouble();

        if (amount > bankAccount.getBalance()) {
            System.out.println("Insufficient funds. Please enter a smaller amount.");
        } else {
            bankAccount.withdraw(amount);
            System.out.println("You have withdrawn $" + amount + ".");
            System.out.println("Your new balance is $" + bankAccount.getBalance() + ".");
        }
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        double amount;

        System.out.println("Enter the amount you want to deposit:");
        amount = scanner.nextDouble();

        bankAccount.deposit(amount);
        System.out.println("You have deposited $" + amount + ".");
        System.out.println("Your new balance is $" + bankAccount.getBalance() + ".");
    }

    private void checkBalance() {
        System.out.println("Your current balance is $" + bankAccount.getBalance() + ".");
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class Atm_Interface {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.00);
        ATM atm = new ATM(bankAccount);
        atm.start();
    }
}