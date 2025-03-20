# bankonit

### **Step 1: Initialize Project Setup**
1. Create a project folder named `ATMProject`.
2. Set up a `git` repository for version control.
3. Create the following Java files based on the UML:
   - `HasMenu.java` (Interface)
   - `CheckingAccount.java`
   - `SavingsAccount.java`
   - `User.java` (Abstract class)
   - `Customer.java`
4. Create a `Makefile` for easy compilation and testing.

### **Step 2: Implement `HasMenu` Interface**
1. Define the following methods:
   - `String menu()`
   - `void start()`
2. This interface will be implemented by:
   - `CheckingAccount`
   - `SavingsAccount`
   - `Customer`

### **Step 3: Implement `CheckingAccount` Class**
1. **Attributes:**
   - `double balance`
2. **Constructors:**
   - Default constructor initializes `balance = 0`.
   - Constructor with parameter `double balance`.
3. **Methods:**
   - `menu()`: Display options for checking account operations.
   - `start()`: Loop for processing menu choices.
   - `double getBalance()`
   - `String getBalanceString()`: Return balance formatted as currency.
   - `void setBalance(double balance)`
   - `void checkBalance()`: Display current balance.
   - `void makeDeposit()`: Accept amount and add to balance.
   - `void makeWithdrawal()`: Accept amount and subtract from balance.
   - `double getDouble()`: Utility to handle user input safely.

### **Step 4: Implement `SavingsAccount` Class (Extend `CheckingAccount`)**
1. **Additional Attribute:**
   - `double interestRate`
2. **Methods:**
   - Inherit all `CheckingAccount` methods.
   - `double getInterestRate()`
   - `void setInterestRate()`
   - `void calcInterest()`: Calculate interest and add it to the balance.

### **Step 5: Implement `User` Abstract Class**
1. **Attributes:**
   - `String userName`
   - `String PIN`
2. **Methods:**
   - `boolean login()`: Prompt user for credentials.
   - `boolean login(String userName, String PIN)`: Validate credentials.
   - `void setUserName(String userName)`
   - `String getUserName()`
   - `void setPIN(String PIN)`
   - `String getPIN()`
   - `abstract String getReport()`
   - Implement `HasMenu` interface.

### **Step 6: Implement `Customer` Class (Extend `User`)**
1. **Attributes:**
   - `CheckingAccount checking`
   - `SavingsAccount savings`
2. **Constructors:**
   - Default constructor
   - Parameterized constructor (`String userName`, `String PIN`)
3. **Methods:**
   - `start()`: Customer main loop/menu
   - `menu()`: Display customer menu (Manage checking, savings, change PIN)
   - `void changePin()`: Change customer's PIN
   - `String getReport()`: Summary report of balances

**Step 7: Testing**
1. Create a default customer:
   - Username: **Alice**
   - PIN: **0000**
2. Implement a `main()` method in `Customer` class to test:
   - Login functionality
   - Checking account operations (deposit, withdrawal, balance check)
   - Savings account operations
   - Change PIN feature
3. Use `make testCustomer`, `make testChecking`, `make testSavings` for testing.

**Step 8: Final Review & Iteration**
1. Ensure:
   - All classes compile.
   - Menu loops work as intended.
   - Basic error handling is done (optional advanced validation).
2. Commit changes to Git after each successful milestone.

