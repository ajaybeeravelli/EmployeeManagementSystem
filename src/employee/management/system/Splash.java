package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    public Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(200,10,1200,60);
        heading.setForeground(Color.red);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        add(heading);
        
        //adding image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(50,80,1050,500);
        add(image);
        
        JButton click= new JButton("Click here to continue");
        click.setBounds(400,400,300,70);
        click.setForeground(Color.WHITE);
        click.setBackground(Color.black);
        click.addActionListener(this);
        image.add(click);
       
        setSize(1170,630);
        setVisible(true);
        setLocation(80,15);
        //for blinking the heading of the splash screen
         while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            } 
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
        new Splash();
    }
}
