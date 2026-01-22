/**
 * Topic: UNARY AND RELATIONAL OPERATORS
 * Concept: Evaluating boolean expressions and variable state changes.
 */
public class LogicalOperatorsDemo {
    public static void main(String[] args) {
        
        // 1. Unary Operators: Act on a single operand
        int number = 10;
        int negated = -number; // Arithmetic negation
        
        boolean isJavaFun = true;
        // Logical Complement: Flips the bit (True becomes False)
        boolean isSad = !isJavaFun; 

        System.out.println("--- Unary Results ---");
        System.out.println("Original: " + number);
        System.out.println("Negated:  " + negated);
        System.out.println("Is it sad? " + isSad);

        // 2. Increment/Decrement (Unary)
        // Note for BSCS: Be aware of Pre-increment (++i) vs Post-increment (i++)
        int count = 5;
        count++; // Incremented to 6
        
        // 3. Relational/Comparison Operators
        int a = 5;
        int b = 6;

        

        System.out.println("\n--- Comparison Results ---");
        // != is the 'Not Equal To' operator
        if (a != b) { 
            System.out.println("Status: Not Equal"); 
        } else {
            System.out.println("Status: Equal");
        }
        
        // 4. Ternary (Conditional) Operator
        // Syntax: (condition) ? value_if_true : value_if_false
        String result = (a > b) ? "A is bigger" : "B is bigger or equal";
        
        System.out.println("Ternary Result: " + result);
    }
}