
package employee.management.system;

import java.awt.*;
//import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class View extends JFrame implements ActionListener{
    JTable table;
    JButton search,print,back,update;
    //JTextField jfsid ;
     Choice jcsid;
    public View(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel jlsid= new JLabel("search by employee Id");
        jlsid.setBounds(20,20,150,20);
        add(jlsid);
        
        jcsid= new Choice();
        jcsid.setBounds(190, 20, 150, 20);
        //jcsid.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jcsid);
        //search button
        search = new JButton("search");
        search .setBounds(30,60,100,20);
        search .setBackground(Color.BLUE);
        search .setForeground(Color.WHITE);
        search .addActionListener(this);
        add(search );
        //print
        print = new JButton("print");
        print .setBounds(150,60,100,20);
        print .setBackground(Color.BLUE);
        print .setForeground(Color.WHITE);
        print .addActionListener(this);
        add(print );
        //update
       back = new JButton("back");
       back.setBounds(270,60,100,20);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back );
        //back
        update = new JButton("update");
       update.setBounds(390,60,100,20);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update );
        
        table = new JTable();
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from employee");
            while(rs.next()){
                jcsid.add(rs.getString("employeeid"));
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20,100,860,460);
        add(jsp);
        
        setSize(900,600);
        setLocation(200,30);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String eid=jcsid.getSelectedItem();
           
            try{
                Conn c= new Conn();
                ResultSet rs=c.s.executeQuery("select * from employee where employeeid='"+eid+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }catch(Exception e){
             e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Home();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new Update(jcsid.getSelectedItem());
        }
        else{
            try{
                table.print();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        
    }
    public static void main(String[] args){
        new View();
    }
}
