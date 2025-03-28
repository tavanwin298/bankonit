public class Admin extends User {
    public Admin() {
        super("admin", "0000"); // Default credentials
    }

    @Override
    public String menu() {
        return "\nAdmin Menu\n" +
               "0) Exit this menu\n" +
               "1) Full customer report\n" +
               "2) Add user\n" +
               "3) Apply interest to savings accounts\n";
    }

    @Override
    public void start() {
        // Empty as per instructions
    }

    public String getReport() {
        return "Admin: " + getUserName();
    }
}
