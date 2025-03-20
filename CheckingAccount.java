import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    protected double balance;
    protected Scanner input = new Scanner(System.in);

    public CheckingAccount() {
        balance = 0.0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double getDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to 0.");
            return 0.0;
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + getBalanceString());
    }

    public void makeDeposit() {
        System.out.print("How much to deposit? ");
        double amount = getDouble();
        balance += amount;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal() {
        System.out.print("How much to withdraw? ");
        double amount = getDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("New balance: " + getBalanceString());
        }
    }

    @Override
    public String menu() {
        return "\nAccount Menu\n0) quit\n1) check balance\n2) make a deposit\n3) make a withdrawal\n";
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.print(menu() + "\nPlease enter 0-3: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> makeDeposit();
                case 3 -> makeWithdrawal();
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();
        account.start();
    }
}
