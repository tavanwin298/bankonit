public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        this("Alice", "0000");
    }

    public Customer(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
        this.checking = new CheckingAccount();
        this.savings = new SavingsAccount();
    }

    @Override
    public String menu() {
        return "\nCustomer Menu\n0) Exit\n1) Manage Checking Account\n2) Manage Savings Account\n3) Change PIN\n";
    }

    @Override
    public void start() {
        if (!login()) {
            System.out.println("Login Failed");
            return;
        }
        System.out.println("Login Successful");

        int action;
        do {
            System.out.print(menu() + "Action (0-3): ");
            action = Integer.parseInt(input.nextLine());
            switch (action) {
                case 1 -> {
                    System.out.println("Checking Account");
                    checking.start();
                }
                case 2 -> {
                    System.out.println("Savings Account");
                    savings.start();
                }
                case 3 -> changePin();
            }
        } while (action != 0);
    }

    public void changePin() {
        System.out.print("Enter new PIN: ");
        this.PIN = input.nextLine();
        System.out.println("PIN successfully changed.");
    }

    @Override
    public String getReport() {
        return "Customer: " + userName + "\nChecking balance: " + checking.getBalanceString() +
                "\nSavings balance: " + savings.getBalanceString();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.start();
    }
}
