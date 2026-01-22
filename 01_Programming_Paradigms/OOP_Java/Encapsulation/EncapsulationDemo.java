/**
 * Topic: ENCAPSULATION (The 1st Pillar of OOP)
 * Concept: Data Hiding & Access Control
 */
class Employee {
    // 1. Data Hiding: Restricting direct access using 'private'
    private int empNum;
    private String name;

    // 2. Constructor: Enforcing object state at instantiation
    public Employee(int empNum, String name) {
        this.empNum = empNum;
        this.name = name;
    }

    // 3. Accessor (Getter): Providing read-only access
    public int getEmpNum() {
        return empNum;
    }

    // 4. Mutator (Setter): Providing controlled write access with 'Validation'
    public void setEmpNum(int empNum) {
        // Business Logic: Ensuring the ID is never a negative value
        if (empNum > 0) {
            this.empNum = empNum;
        } else {
            System.out.println("Error: Invalid ID input.");
        }
    }

    public String getName() {
        return name;
    }
}