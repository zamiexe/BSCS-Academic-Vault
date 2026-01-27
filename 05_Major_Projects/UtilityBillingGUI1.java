import javax.swing.*;

public class UtilityBillingGUI1 {
    public static void main(String[] args) {
        try {
            // Collecting User Data
            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            if (name == null) return;

            String unitInput = JOptionPane.showInputDialog("Enter kWh Consumed:");
            if (unitInput == null) return;
            
            double units = Double.parseDouble(unitInput);

            // Pricing Logic
            double ratePerKwh = 9.08; 
            double generationCharge = units * ratePerKwh;
            
            // Local Billing Logic: Surcharge for high usage (>400 kWh)
            double surcharge = (generationCharge > 400) ? (generationCharge * 0.15) : 0;
            
            // Adding a mock 5% Franchise Tax for realism
            double franchiseTax = generationCharge * 0.05;
            double grandTotal = generationCharge + surcharge + franchiseTax;

            String PHP = "\u20B1"; // Peso Symbol

            // GUI Presentation with Davao Light Branding
            String summary = "<html>" +
                "<body style='width: 280px; font-family: sans-serif; padding: 10px;'>" +
                "<h2 style='text-align: center; color: #E65100;'>DAVAO LIGHT</h2>" +
                "<p style='text-align: center; font-size: 9px;'>An Aboitiz Company</p>" +
                "<hr>" +
                "<b>Customer:</b> " + name.toUpperCase() + "<br>" +
                "<b>Billing Period:</b> Jan 2026<br>" +
                "<hr>" +
                "<table style='width: 100%;'>" +
                "<tr><td>Total Consumption:</td><td style='text-align: right;'>" + String.format("%.2f", units) + " kWh</td></tr>" +
                "<tr><td>Rate per kWh:</td><td style='text-align: right;'>" + PHP + String.format("%.2f", ratePerKwh) + "</td></tr>" +
                "<tr><td colspan='2'><hr></td></tr>" +
                "<tr><td>Generation Charge:</td><td style='text-align: right;'>" + PHP + String.format("%.2f", generationCharge) + "</td></tr>" +
                "<tr><td>Surcharge (15%):</td><td style='text-align: right;'>" + PHP + String.format("%.2f", surcharge) + "</td></tr>" +
                "<tr><td>Franchise Tax (5%):</td><td style='text-align: right;'>" + PHP + String.format("%.2f", franchiseTax) + "</td></tr>" +
                "<tr><td style='padding-top:10px;'><b>TOTAL AMOUNT DUE:</b></td>" +
                "<td style='padding-top:10px; text-align: right; color: #D84315;'><b>" + PHP + String.format("%.2f", grandTotal) + "</b></td></tr>" +
                "</table>" +
                "<br><p style='font-size: 8px; text-align: center; color: gray;'>This is a programming exercise output.</p>" +
                "</body></html>";

            JOptionPane.showMessageDialog(null, summary, "Davao Light E-Bill", JOptionPane.PLAIN_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Input must be a number.", "Billing Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}