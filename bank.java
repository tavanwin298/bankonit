import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank implements HasMenu {
    private Admin admin;
    private ArrayList<Customer> customers;
    private Scanner scanner;

    public Bank() {
        admin = new Admin();
        customers = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Uncomment the next two lines to reset data
        // loadSampleCustomers();
        // saveCustomers();

        loadCustomers();
        start();
        saveCustomers();
    }

    @Override
    public String menu() {
        return "\nBank Menu\n" +
               "0) Exit system\n" +
               "1) Login as admin\n" +
               "2) Login as customer\n";
    }

    @Override
    public void start() {
        while (true) {
            System.out.println(menu());
            System.out.print("Action: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("Exiting system...");
                    return;
                case "1":
                    adminLogin();
                    break;
                case "2":
                    customerLogin();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Admin PIN: ");
        String pin = scanner.nextLine();

        if (admin.login(username, pin)) {
            startAdmin();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private void startAdmin() {
        while (true) {
            System.out.println(admin.menu());
            System.out.print("Action: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    return;
                case "1":
                    fullCustomerReport();
                    break;
                case "2":
                    addUser();
                    break;
                case "3":
                    applyInterest();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void fullCustomerReport() {
        System.out.println("Full Customer Report:");
        for (Customer customer : customers) {
            System.out.println(customer.getReport());
        }
    }

    private void addUser() {
        System.out.print("Enter new customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new customer PIN: ");
        String pin = scanner.nextLine();

        customers.add(new Customer(name, pin));
        System.out.println("Customer added successfully.");
    }

    private void applyInterest() {
        for (Customer customer : customers) {
            customer.applyInterest();
        }
        System.out.println("Interest applied to all savings accounts.");
    }

    private void customerLogin() {
        System.out.print("Customer Username: ");
        String username = scanner.nextLine();
        System.out.print("Customer PIN: ");
        String pin = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.login(username, pin)) {
                customer.start();
                return;
            }
        }
        System.out.println("Invalid customer credentials.");
    }

    private void saveCustomers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
            out.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    private void loadCustomers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.dat"))) {
            customers = (ArrayList<Customer>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing customer data found. Starting fresh.");
            customers = new ArrayList<>();
        }
    }

    private void loadSampleCustomers() {
        customers.add(new Customer("Alice", "1234"));
        customers.add(new Customer("Bob", "5678"));
        customers.add(new Customer("Cindy", "9876"));
    }
}
