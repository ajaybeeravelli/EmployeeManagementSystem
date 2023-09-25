
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    JButton add,view,delete,edit;
   public Home(){
       setLayout(null);
       
       JLabel heading = new JLabel("Employee Management System");
       heading.setBounds(650,30,400,40);
       heading.setFont(new Font("RaleWay",Font.BOLD,25));
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel jimg= new JLabel(i3);
       jimg.setBounds(0, 0, 1120, 630);
       
        add= new JButton("Add Employee");
       add.setBounds(650,90,150,25);
       add.setForeground(Color.WHITE);
       add.setBackground(Color.BLACK);
       add.addActionListener(this);
       jimg.add(add);
        view= new JButton("View Employee");
       view.setBounds(850,90,150,25);
       view.setForeground(Color.WHITE);
       view.setBackground(Color.BLACK);
       view.addActionListener(this);
       jimg.add(view);
       delete= new JButton("Delete Employee");
       delete.setBounds(650,130,150,25);
       delete.setForeground(Color.WHITE);
       delete.setBackground(Color.BLACK);
       delete.addActionListener(this);
       jimg.add(delete);
       edit= new JButton("Edit Employee");
       edit.setBounds(850,130,150,25);
       edit.setForeground(Color.WHITE);
       edit.setBackground(Color.BLACK);
       edit.addActionListener(this);
       jimg.add(edit);
       
       jimg.add(heading);
       add(jimg);
       
       setSize(1130,640);
       setLocation(60,40);
       setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new View();
        }
        else if (ae.getSource()==delete){
            new Delete();
        }
        else{
            setVisible(false);
            new View();
        }
    }
    public static void main(String args[]){
        new Home();
    }
}
