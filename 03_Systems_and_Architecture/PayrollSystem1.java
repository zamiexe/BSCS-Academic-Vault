import java.awt.*;
import java.awt.event.*; 
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class PayrollSystem1 extends JFrame {

    static DefaultTableModel model;
    static JTable table;
    static ArrayList<String> lines;
    static JScrollPane scrollPane;
    static JTextField txtName, txthr, txtwork;

    // Global variables
    static String name;
    static double rit, hrw, tax, gp, np;
    static boolean dataReady = false;

    public static void main(String[] args) {
        new PayrollSystem1();
    }

    PayrollSystem1() {
        Color newBlue = new Color(51, 204, 255);
        
        // UI 
        JLabel empName = new JLabel("Employee Name");
        add(empName).setBounds(40, 30, 150, 24);
        txtName = new JTextField();
        add(txtName).setBounds(40, 55, 170, 25);

        JLabel hrrate = new JLabel("Hourly Rate");
        add(hrrate).setBounds(40, 90, 150, 24);
        txthr = new JTextField();
        add(txthr).setBounds(40, 115, 170, 25);

        JLabel workRate = new JLabel("Hours Worked");
        add(workRate).setBounds(40, 150, 150, 24);
        txtwork = new JTextField();
        add(txtwork).setBounds(40, 175, 170, 25);

        // BUTTONS
        JButton btnSal = new JButton("Calculate Salary");
        add(btnSal).setBounds(40, 220, 170, 30);

        JButton btnAdd2table = new JButton("Add to Table");
        add(btnAdd2table).setBounds(40, 260, 170, 30);

        JButton btnClear = new JButton("Clear Fields");
        add(btnClear).setBounds(40, 300, 170, 30);

        JButton btnUpd = new JButton("Update");
        add(btnUpd).setBounds(40, 340, 170, 30);

        JButton btnDel = new JButton("Delete");
        add(btnDel).setBounds(40, 380, 170, 30);

        // TABLE
        String[] columns = {"Emp. Name", "Rate", "Hours", "Gross Pay", "Tax (12%)", "Net Pay"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.getTableHeader().setBackground(newBlue);
        scrollPane = new JScrollPane(table);
        add(scrollPane).setBounds(250, 40, 550, 372);
        
        refreshTable();

        // MOUSE LISTENER 
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    txtName.setText(model.getValueAt(row, 0).toString());
                    txthr.setText(model.getValueAt(row, 1).toString());
                    txtwork.setText(model.getValueAt(row, 2).toString());
                    dataReady = false; 
                }
            }
        });

        // CALCULATE
        btnSal.addActionListener(e -> {
            try {
                rit = Double.parseDouble(txthr.getText().trim());
                hrw = Double.parseDouble(txtwork.getText().trim());

                if (hrw <= 40) {
                    gp = rit * hrw;
                } else {
                    gp = (40 * rit) + ((hrw - 40) * (rit * 1.5));
                }

                tax = gp * 0.12;
                np = gp - tax;
                dataReady = true;

                JOptionPane.showMessageDialog(this, "Calculations \nGross: " + gp + "\nTax: " + tax + "\nNet: " + np);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numbers");
            }
        });

        // ADD TO TABLE
        btnAdd2table.addActionListener(e -> {
            name = txtName.getText().trim();
            if (name.isEmpty() || !dataReady) {
                JOptionPane.showMessageDialog(this, "Calculate first");
                return;
            }

            try {
                savetoFile();
                refreshTable();
                setFieldEmpty();
                dataReady = false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnClear.addActionListener(e -> setFieldEmpty());

        // DELETE
        btnDel.addActionListener(e -> delete());

        // UPDATE
        btnUpd.addActionListener(e -> Update());

        // Frame
        setLayout(null);
        setTitle("Payroll System");
        setSize(850, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.BLUE);
    }

    // File
    public static void savetoFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Payroll.txt", true))) {
            bw.write(name + "#" + rit + "#" + hrw + "#" + gp + "#" + tax + "#" + np);
            bw.newLine();
        }
    }

    // REFRESH
    public static void refreshTable() {
        model.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("Payroll.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                model.addRow(line.split("#"));
            }
        } catch (IOException e) {}
    }

    // EMPTY FIELD
    public static void setFieldEmpty() {
        txtName.setText("");
        txthr.setText("");
        txtwork.setText("");
        dataReady = false;
    }

    // DELETE
    public static void delete() {
        int selectrow = table.getSelectedRow();
        if (selectrow == -1) {
            JOptionPane.showMessageDialog(null, "Select record to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Payroll.txt"))) {
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                if (rowIndex != selectrow) lines.add(line);
                rowIndex++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Payroll.txt"))) {
            for (String record : lines) {
                bw.write(record);
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving file " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Record deleted.");
        setFieldEmpty();
        refreshTable();
    }

    // UPDATE 
    public static void Update() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Select a record to update.");
            return;
        }

        if (!dataReady || txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter details and click 'Calculate Salary' before updating.");
            return;
        }

        lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Payroll.txt"))) {
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                if (rowIndex == selectedRow) {
                    // Maintained all 6 columns for the database structure
                    String updatedRecord = txtName.getText().trim() + "#" +
                                           rit + "#" +
                                           hrw + "#" +
                                           gp + "#" +
                                           tax + "#" +
                                           np;
                    lines.add(updatedRecord);
                } else {
                    lines.add(line);
                }
                rowIndex++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Payroll.txt"))) {
            for (String record : lines) {
                bw.write(record);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating file: " + e.getMessage());
        }

        setFieldEmpty();
        refreshTable();
    }
}
