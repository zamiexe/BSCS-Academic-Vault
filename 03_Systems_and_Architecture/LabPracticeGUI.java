import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LabPracticeGUI extends JFrame {
  public static void main(String[] args) {
    new LabPracticeGUI();
  }

  LabPracticeGUI() {
    JLabel lblheader = new JLabel("Customer Type");
    add(lblheader).setBounds(50, 30, 94, 24);
    JTextField txtName = new JTextField();
    add(txtName).setBounds(200, 30, 188, 27);

    JLabel lblheader1 = new JLabel("Consumption");
    add(lblheader1).setBounds(50, 60, 94, 24);
    JTextField txtPass = new JTextField();
    add(txtPass).setBounds(200, 60, 188, 27);

    JLabel lblheader2 = new JLabel("Total Bill");
    add(lblheader2).setBounds(50, 90, 94, 24);
    JTextField bill = new JTextField();
    add(bill).setBounds(200, 90, 188, 27);

    JButton btnAdd = new JButton("Add");
    add(btnAdd).setBounds(50, 130, 94, 24);

    JButton btnUpdate = new JButton("Update");
    add(btnUpdate).setBounds(175, 130, 94, 24);

    JButton btnDelete = new JButton("Delete");
    add(btnDelete).setBounds(295, 130, 94, 24);

    setLayout(null);
    setTitle("Vehicle Rental System");
    setSize(461, 252);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}