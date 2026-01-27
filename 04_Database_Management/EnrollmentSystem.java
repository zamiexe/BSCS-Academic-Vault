import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class EnrollmentSystem extends JFrame {
  static String name, address, course, ageStr, lastSchool;
  static JTextField txtName, txtAdd, txtCourse, txtAge, txtSchool;

  public static void main(String[] args) throws IOException {
    new EnrollmentSystem();
  }

  EnrollmentSystem() {
    JLabel lblName = new JLabel("Student Name");
    add(lblName).setBounds(40, 30, 94, 24);
    txtName = new JTextField();
    add(txtName).setBounds(40, 55, 170, 25);

    JLabel lblAdd = new JLabel("Address");
    add(lblAdd).setBounds(40, 90, 94, 24);
    txtAdd = new JTextField();
    add(txtAdd).setBounds(40, 115, 170, 25);

    JLabel lblCourse = new JLabel("Course");
    add(lblCourse).setBounds(40, 150, 94, 24);
    txtCourse = new JTextField();
    add(txtCourse).setBounds(40, 175, 170, 25);

    JLabel lblAge = new JLabel("Age");
    add(lblAge).setBounds(40, 210, 94, 24);
    txtAge = new JTextField();
    add(txtAge).setBounds(40, 235, 170, 25);

    JLabel lblSchool = new JLabel("Last School Attended");
    add(lblSchool).setBounds(40, 270, 150, 24);
    txtSchool = new JTextField();
    add(txtSchool).setBounds(40, 295, 170, 25);

    JButton btnEnroll = new JButton("Enroll Student");
    add(btnEnroll).setBounds(65, 340, 113, 30);

    btnEnroll.addActionListener(e -> {
      name = txtName.getText();
      address = txtAdd.getText();
      course = txtCourse.getText();
      ageStr = txtAge.getText();
      lastSchool = txtSchool.getText();

      try {
        saveToFile();
        clearFields();
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error saving data");
      }
    });

    setLayout(null);
    setTitle("Enrollment System");
    setSize(300, 450);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void saveToFile() throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("StudentsEnrolled.txt", true))) {
      bw.write("Student Enrolled\nName: " + name + "\nAddress: " + address + 
               "\nCourse: " + course + "\nAge: " + ageStr + 
               "\nLast School Attended: " + lastSchool + "\n\n");
      JOptionPane.showMessageDialog(null, "Saved Successfully");
    }
  }

  public void clearFields() {
    txtName.setText("");
    txtAdd.setText("");
    txtCourse.setText("");
    txtAge.setText("");
    txtSchool.setText("");
  }
}