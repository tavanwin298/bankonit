import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    protected String userName;
    protected String PIN;
    protected transient Scanner input = new Scanner(System.in);

    public boolean login() {
        System.out.print("User name: ");
        String name = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();
        return login(name, pin);
    }

    public boolean login(String userName, String PIN) {
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public abstract String getReport();
}
