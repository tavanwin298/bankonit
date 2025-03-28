public class Customer extends User implements Serializable {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer(String name, String pin) {
        super(name, pin);
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    }

    @Override
    public String getReport() {
        return "User: " + getUserName() +
               ", Checking: $" + checking.getBalance() +
               ", Savings: $" + savings.getBalance();
    }

    public void applyInterest() {
        savings.calcInterest();
    }

    @Override
    public void start() {
        // Implement customer-specific menu (Deposit, Withdraw, etc.)
    }
}

