import javax.swing.*;

/**
 * Topic: GRAPHICAL USER INTERFACE (GUI) & EXCEPTION HANDLING
 * Concept: Using Swing components to create an event-driven billing system.
 */
public class UtilityBillingGUI {
    public static void main(String[] args) {
        // The 'try' block handles potential runtime errors like non-numeric inputs
        try {
    
            String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
            if (customerId == null) return; 

            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            if (name == null) return;

            String unitInput = JOptionPane.showInputDialog("Enter Unit Consumed (kWh):");
            if (unitInput == null) return;
            double units = Double.parseDouble(unitInput); // Potential Exception Point

            // Pricing Logic: Multi-way Selection Structure
            double cpu;
            if (units <= 199) cpu = 1.20;
            else if (units <= 399) cpu = 1.50;
            else if (units <= 599) cpu = 1.80;
            else cpu = 2.00;

            double total = units * cpu;
            
            // Ternary Operator
            double surcharge = (total > 400) ? (total * 0.15) : 0;
            double grandTotal = total + surcharge;

            String PHP = "\u20B1"; 

            // GUI Presentation: Using HTML to bypass Swing's text limitations
            String summary = "<html>" +
                "<body style='width: 250px; font-family: sans-serif;'>" +
                "<h2 style='text-align: center; color: #2e7d32;'>Meralco Billing</h2>" +
                "<p style='text-align: center;'>Official Receipt</p>" +
                "<hr>" +
                "<b>ID:</b> " + customerId + "<br>" +
                "<b>Name:</b> " + name.toUpperCase() + "<br>" +
                "<hr>" +
                "<table style='width: 100%;'>" +
                "<tr><td>Units:</td><td style='text-align: right;'>" + String.format("%.2f", units) + " kWh</td></tr>" +
                "<tr><td>Rate/Unit:</td><td style='text-align: right;'>" + PHP + String.format("%.2f", cpu) + "</td></tr>" +
                "<tr><td colspan='2'><hr></td></tr>" +
                "<tr><td><b>Subtotal:</b></td><td style='text-align: right;'><b>" + PHP + String.format("%.2f", total) + "</b></td></tr>" +
                "<tr><td>Surcharge (15%):</td><td style='text-align: right;'>" + PHP + String.format("%.2f", surcharge) + "</td></tr>" +
                "<tr><td style='padding-top:10px;'><b>GRAND TOTAL:</b></td>" +
                "<td style='padding-top:10px; text-align: right; color: #d32f2f;'><b>" + PHP + String.format("%.2f", grandTotal) + "</b></td></tr>" +
                "</table>" +
                "<br><p style='font-size: 8px; text-align: center;'>Zami Health Tech | Thank you!</p>" +
                "</body></html>";

            JOptionPane.showMessageDialog(null, summary, "Electricity Bill", JOptionPane.PLAIN_MESSAGE);

        } catch (NumberFormatException e) {
            // Error Handling: Preventing the program from crashing
            JOptionPane.showMessageDialog(null, "Critical Error: Unit input must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}