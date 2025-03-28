import java.io.Serializable;

public class Admin extends User implements Serializable {

    public Admin() {
        this.userName = "admin";
        this.PIN = "0000";
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
        // This method is intentionally left blank. The Bank class handles admin interactions.
    }

    @Override
    public String getReport() {
        return "Admin: " + userName + ", PIN: " + PIN;
    }
}
