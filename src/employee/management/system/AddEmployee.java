
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener{
    JTextField jfusername,jffather,jfsalary,jfaddr,jfphone,jfemail,jfdesignation,jfaadhar;
    Random rand= new Random();
    JButton back,add;
    JDateChooser dcdob;
    JLabel jlemployeeID;
    JComboBox jbceducation;
    int number = rand.nextInt(999999);
    public AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel(" Add Employee");
        heading.setBounds(300,30,1000,50);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("serif",Font.PLAIN,40));
        add(heading);
        //adding the text field input areas
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(160,120,150,30);
        add(jlusername);
        //text field for input
        jfusername = new JTextField();
        jfusername.setBounds(270, 120, 150, 30);
        jfusername.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfusername);
        //adding father name section
         JLabel jlfather = new JLabel("Father name");
        jlfather.setBounds(470,120,150,30);
        add(jlfather);
        //text field for input
        jffather = new JTextField();
        jffather.setBounds(570, 120, 150, 30);
        jffather.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jffather);
        
        JLabel jldob = new JLabel("Date of birth");
        jldob.setBounds(160,170,150,30);
        add(jldob);
        
         dcdob= new JDateChooser();
        //dcdob.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        dcdob.setBounds(270,170,150,30);
        add(dcdob);
        //salary
         JLabel jlsalary = new JLabel("Salary");
        jlsalary.setBounds(470,170,150,30);
        add(jlsalary);
        //text field for input
        jfsalary = new JTextField();
        jfsalary.setBounds(570, 170, 150, 30);
        jfsalary.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfsalary);
        //address,
        JLabel jladdress = new JLabel("address");
        jladdress.setBounds(160,220,150,30);
        add(jladdress);
        
        jfaddr = new JTextField();
        jfaddr.setBounds(270, 220, 150, 30);
        jfaddr.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfaddr);
        //phone
        JLabel jlphone = new JLabel("phone no");
        jlphone.setBounds(470,220,150,30);
        add(jlphone);
        //text field for input
        jfphone = new JTextField();
        jfphone.setBounds(570, 220, 150, 30);
         jfphone.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfphone);
        //email
        JLabel jlemail = new JLabel("Email");
        jlemail.setBounds(160,270,150,30);
        add(jlemail);
        
        jfemail = new JTextField();
        jfemail.setBounds(270, 270, 150, 30);
        jfemail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfemail);
        //eductaion
        JLabel jleucation = new JLabel("Education");
        jleucation.setBounds(470,270,150,30);
        add(jleucation);
        //text field for input
        String courses[]={"BE","ME","MBA","MCA","BA","BCOM"};
         jbceducation=new JComboBox(courses);
        jbceducation.setBounds(570, 270, 150, 30);
        jbceducation.setBackground(Color.WHITE);
         //jfphone.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jbceducation);
        //designation and aadhar
        JLabel jldesignation = new JLabel("Designation");
        jldesignation.setBounds(160,320,150,30);
        add(jldesignation);
        
        jfdesignation = new JTextField();
        jfdesignation.setBounds(270, 320, 150, 30);
        jfdesignation.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfdesignation);
        //eductaion
        JLabel jlaadhar = new JLabel("Aadhar");
        jlaadhar .setBounds(470,320,150,30);
        add(jlaadhar );
        //text field for input
        
        jfaadhar = new JTextField();
        jfaadhar.setBounds(570, 320, 150, 30);
        jfaadhar.setBackground(Color.WHITE);
        jfaadhar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfaadhar);
        //employeeID
         JLabel jlempid = new JLabel("Employee Id");
        jlempid.setBounds(160,370,150,30);
        add(jlempid);
        
         jlemployeeID = new JLabel(""+number);
        jlemployeeID.setBounds(270,370,150,30);
        add(jlemployeeID);
        
        //adding button
        add= new JButton("add Employee");
        add.setBounds(260,420,150,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(this);
        add(add);
        back= new JButton("back<-");
        back.setBounds(470,420,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);
       
        setSize(1000,630);
        setVisible(true);
        setLocation(80,15);
        //for blinking the heading of the splash screen
         
    }
     
   
    @Override
    public void actionPerformed(ActionEvent ae){
        
            if(ae.getSource()==back){
                setVisible(false);
                new Home();
            }
            else{
                String name=jfusername.getText();
                String father=jffather.getText();
                String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
                String salary=jfsalary.getText();
                String phone=jfphone.getText();
                String email=jfemail.getText();
                String address=jfaddr.getText();
                String education= (String)jbceducation.getSelectedItem();
                String designation=jfdesignation.getText();
                String aadhar=jfaadhar.getText();
                String empid=jlemployeeID.getText();
                //query
                try{
                  String query ="insert into employee values('"+name+"','"+father+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"');";
                  Conn cn= new Conn();
                  cn.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"Successfully added employee details");
                   setVisible(false);
                   new Home();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}

