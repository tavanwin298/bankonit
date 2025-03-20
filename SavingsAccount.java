public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = 0.01; // default 1%
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void calcInterest() {
        double interest = balance * interestRate;
        balance += interest;
    }

    public void setInterestRate() {
        System.out.print("Enter new interest rate (as decimal, e.g., 0.02): ");
        interestRate = getDouble();
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.start();
    }
}
