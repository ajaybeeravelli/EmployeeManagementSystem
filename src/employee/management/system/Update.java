
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener{
    JTextField tfeducation,jffather,jfsalary,jfaddr,jfphone,jfemail,jfdesignation,jfaadhar;
    JButton back,add;
    JLabel jlemployeeID, dcdob,jlname;
    String empid;
    public Update(String empid){
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel(" Update Employee");
        heading.setBounds(300,30,1000,50);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("serif",Font.PLAIN,40));
        add(heading);
        //adding the text field input areas
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(160,120,150,30);
        add(jlusername);
        //text field for input
         jlname = new JLabel();
        jlname.setBounds(270, 120, 150, 30);
        //jlname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jlname);
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
        
        // dcdob= new JDateChooser();
          dcdob=new JLabel();
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
       
         tfeducation=new JTextField();
        tfeducation.setBounds(570, 270, 150, 30);
        tfeducation.setBackground(Color.WHITE);
         tfeducation.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(tfeducation);
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
        
         jlemployeeID = new JLabel();
        jlemployeeID.setBounds(270,370,150,30);
        add(jlemployeeID);
        try{
            Conn c = new Conn();
            String query="select * from employee where employeeid='"+empid+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                jlname.setText(rs.getString("username"));
                jffather.setText(rs.getString("fathername"));
                dcdob.setText(rs.getString("dob"));
                jfsalary.setText(rs.getString("salary"));
                jfaddr.setText(rs.getString("address"));
                jfphone.setText(rs.getString("phone"));
                jfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                jfdesignation.setText(rs.getString("designation"));
                jfaadhar.setText(rs.getString("aadhar"));
                jlemployeeID.setText(rs.getString("employeeid"));
            }
        }catch(Exception e ){e.printStackTrace();}
        
        //adding button
        add= new JButton("update Employee");
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
                String name=jlname.getText();
                String father=jffather.getText();
                String dob=dcdob.getText();
                String salary=jfsalary.getText();
                String phone=jfphone.getText();
                String email=jfemail.getText();
                String address=jfaddr.getText();
                String education= tfeducation.getText();
                String designation=jfdesignation.getText();
                String aadhar=jfaadhar.getText();
                String empid=jlemployeeID.getText();
                //query
                try{
                  String query ="update employee set fathername='"+father+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where employeeid='"+empid+"';";
                  Conn cn= new Conn();
                  cn.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"Successfully updated employee details");
                   setVisible(false);
                   new Home();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        
    }
    public static void main(String[] args){
        new Update("");
    }
}

