
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField jfusername,jfpassword;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(50,30,100,30);
        add(jlusername);
        //text field for input
        jfusername = new JTextField();
        jfusername.setBounds(160, 30, 150, 30);
        jfusername.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfusername);
        
        JLabel jlpassword = new JLabel("Password");
        jlpassword.setBounds(50,70,100,30);
        add(jlpassword);
        //input for password
        jfpassword = new JTextField();
        jfpassword.setBounds(160,70,150,30);
        jfpassword.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jfpassword);
        
        JButton jblogin= new JButton("Login");
        jblogin.setBounds(150,120,100,30);
        jblogin.setBackground(Color.BLUE);
        jblogin.setForeground(Color.white);
        jblogin.addActionListener(this);
        add(jblogin);
        
        setSize(500,250);
        setLocation(400,200);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            String username=jfusername.getText();
            String password=jfpassword.getText();
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            Conn c=new Conn();
            
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid login details");
                setVisible(false);
            }
            
            
        }catch(Exception ex){}
            
    }
    public static void main(String[] args){
        new Login();
    }
}
