import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EnrollmentSystem extends JFrame {

 static String name, add1, course1, last, age1;
 static JTextField txtName, add, course, age, skewl;

 public static void main(String[] args) throws IOException {
  new EnrollmentSystem();

 }

 EnrollmentSystem(){

 JLabel lblheader = new JLabel("Student Name");
 add(lblheader).setBounds(40,30,94,24);
 txtName = new JTextField("  "); // 1st field
 add(txtName).setBounds(40, 55,170,25);


 JLabel lblheader1 = new JLabel("Address");
 add(lblheader1).setBounds(40,90,94,24);
 add = new JTextField("  "); // 2nd field
 add(add).setBounds(40,115,170,25);


 JLabel lblheader2 = new JLabel("Course");
 add(lblheader2).setBounds(40,150,94,24);
 course = new JTextField("  "); // 3rd field
 add(course).setBounds(40,175,170,25);


 JLabel lblheader3 = new JLabel("Age");
 add(lblheader3).setBounds(40,210,94,24);
 age = new JTextField("  "); // 4th field
 add(age).setBounds(40,235,170,25);


 JLabel lblheader4 = new JLabel("Last School Attended");
 add(lblheader4).setBounds(40,270,150,24);
 skewl = new JTextField("  "); // 5th field


 add(skewl).setBounds(40,295,170,25);
    JButton btnEnroll = new JButton("Enroll Student");
    add(btnEnroll).setBounds(65,340,113,30);

    btnEnroll.addActionListener(e->{
      name = txtName.getText();
      add1 = add.getText();
      course1 = course.getText();
      age1 = age.getText();
      last = skewl.getText();

   try {
     savetoFile();
     setFieldEmpty();
   } catch (IOException ex) {
     JOptionPane.showMessageDialog(null, "Error");
   }
    });


 setLayout(null);
 setTitle("Enrollment System");
 setSize(750,500);
 setUndecorated(false);
 setVisible(true);
 setResizable(true);
 setLocationRelativeTo(null);
 setDefaultCloseOperation(EXIT_ON_CLOSE);

 }

 public static void savetoFile()throws IOException{
  FileWriter fw = new FileWriter("StudentsEnrolled.txt", true);
  BufferedWriter bw = new BufferedWriter(fw);

  bw.write("Student Enrolled\n\nName: "+ name + "\nAddress: " + add1+ "\nCourse: " +course1+ "\nAge" +age1 + "\nLast School Attended: " +last);
  bw.write("\n");
  bw.close();

  JOptionPane.showMessageDialog(null, "Saved Successfully");

 }

 public static void setFieldEmpty() {
 txtName.setText("");
 add.setText("");
 course.setText("");
 age.setText("");
 skewl.setText("");

 }
}
