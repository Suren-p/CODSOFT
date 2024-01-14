import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        } else {
            System.out.println("Insufficient funds for withdrawal. Current balance: " + balance);
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public double checkBalance() {
        return bankAccount.getBalance();
    }
}

public class ATMApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount(1000.0);


        ATM atm = new ATM(bankAccount);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleDeposit(atm, scanner);
                    break;
                case 2:
                    handleWithdraw(atm, scanner);
                    break;
                case 3:
                    handleCheckBalance(atm);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void handleDeposit(ATM atm, Scanner scanner) {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        atm.deposit(amount);
    }

    private static void handleWithdraw(ATM atm, Scanner scanner) {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        atm.withdraw(amount);
    }

    private static void handleCheckBalance(ATM atm) {
        System.out.println("Current balance: " + atm.checkBalance());
    }
}
