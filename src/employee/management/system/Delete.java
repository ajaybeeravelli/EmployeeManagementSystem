
package employee.management.system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Delete extends JFrame implements ActionListener{
    Choice cempid;
    JButton delete,back;
    JLabel jlname,jphone,jlmail;
    Delete() {
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //employeeid
        JLabel employeeID= new JLabel("EmployeeID");
        employeeID.setBounds(50,50,100,20);
        add(employeeID);
        
        cempid= new Choice();
        cempid.setBounds(180,50,150,20);
        add(cempid);
        
        try{
            Conn c= new Conn();
            ResultSet rs =c.s.executeQuery("select employeeid from employee");
            while(rs.next())  cempid.add(rs.getString("employeeid")); 
        }catch(Exception e){e.printStackTrace();}
        //lables of name,phone
         JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(80,90,100,20);
        add(jlusername);
        //text field for input
         jlname = new JLabel();
        jlname.setBounds(200, 90, 150, 20);
        //jlname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jlname);
        //phone
         JLabel jlphone = new JLabel("phone no");
        jlphone.setBounds(80,130,100,20);
        add(jlphone);
        //text field for input
         jphone = new JLabel();
        jphone.setBounds(200, 130, 150, 20);
        //jlname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jphone);
        //email
        JLabel mail = new JLabel("phone no");
        mail.setBounds(80,180,100,20);
        add(mail);
        //text field for input
         jlmail = new JLabel();
        jlmail.setBounds(200, 180, 150, 20);
        //jlname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jlmail);
        
        try{
            Conn c= new Conn();
            ResultSet rs =c.s.executeQuery("select * from employee where employeeid='"+cempid.getSelectedItem()+"' ");
            while(rs.next()) {
                jlname.setText(rs.getString("username"));
                jphone.setText(rs.getString("phone"));
                jlmail.setText(rs.getString("email"));
            } 
        }catch(Exception e){e.printStackTrace();}
        
        cempid.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c= new Conn();
            ResultSet rs =c.s.executeQuery("select * from employee where employeeid='"+cempid.getSelectedItem()+"' ");
            while(rs.next()) {
                jlname.setText(rs.getString("username"));
                jphone.setText(rs.getString("phone"));
                jlmail.setText(rs.getString("email"));
            } 
        }catch(Exception e){e.printStackTrace();}
            }
        });
        //adding buttons
        delete= new JButton("Delete Employee");
        delete.setBounds(80,230,150,30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.black);
        delete.addActionListener(this);
        add(delete);
        back= new JButton("back<-");
        back.setBounds(250,230,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);
        
        setSize(700,500);
        setLocation(200,50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==back){
           setVisible(false);
           new Home();
       }
       else{
           try{
                Conn c= new Conn();
                String query="delete from employee where employeeid='"+cempid.getSelectedItem()+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee deleted successfully");
                setVisible(false);
           }catch(Exception e){
               e.printStackTrace();
           } 
       }
        
    }
    public static void main(String[] args){
        new Delete();
    }
}
