import java.util.Scanner;

/**
 * Topic: STATE MANAGEMENT & AUTHENTICATION LOGIC
 * Demonstrates: Static persistence, switch-case menus, and conditional validation.
 */
public class UserAuthSystem { 

    // Static variables persist in memory while the program is running
    private static String userReg; 
    private static String passReg; 

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        boolean isRunning = true; 

        while (isRunning) { 
            System.out.println("\n===== SECURITY PORTAL =====");
            System.out.println("1. Register Account");
            System.out.println("2. User Login");
            System.out.println("3. Termination (Exit)");
            System.out.print("Action Selection: ");

            // Input validation for menu choice
            if (!sc.hasNextInt()) {
                System.out.println("Error: Numeric input required.");
                sc.next(); 
                continue;
            }

            int choice = sc.nextInt(); 
            sc.nextLine(); // Buffer clear

            switch (choice) { 
                case 1: 
                    register(sc); 
                    break; 
                
                case 2: 
                    login(sc); 
                    break; 
                    
                case 3: 
                    System.out.println("Terminating session... Goodbye.");
                    isRunning = false; 
                    break; 

                default: 
                    System.out.println("System Alert: Invalid selection.");
                    break; 
            }     
        } 
        sc.close(); 
    } 

    private static void register(Scanner sc) { 
        System.out.println("\n--- ACCOUNT REGISTRATION ---");
        System.out.print("Enter First Name: "); 
        String firstName = sc.nextLine(); 
        
        System.out.print("Set Username: "); 
        userReg = sc.nextLine(); 

        System.out.print("Set Password: "); 
        passReg = sc.nextLine(); 

        // Validation Logic: Ensuring data integrity
        if (userReg.isEmpty() || passReg.isEmpty()) {
            System.out.println("Error: Fields cannot be null or empty.");
        } else {
            System.out.println("Success: Welcome to the system, " + firstName + "!"); 
        } 
    }
    
    private static void login(Scanner sc) { 
        System.out.println("\n--- USER LOGIN ---");
        
        // Security check: Verify if an account exists first
        if (userReg == null) {
            System.out.println("Failure: No account registered on this system.");
            return;
        }

        System.out.print("Username: "); 
        String userLog = sc.nextLine(); 

        System.out.print("Password: "); 
        String passLog = sc.nextLine(); 

        // Boolean Logic: Comparing stored state with user input
        if (userLog.equals(userReg) && passLog.equals(passReg)) {
            System.out.println("Access Granted: Authentication successful.");
        } else {
            System.out.println("Access Denied: Credentials do not match.");
        }
    }
}