package departmentstore;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author PAVITHRA
 */
public class InsProd extends JFrame implements ActionListener {
JLabel Product,Unitprice,qty;
JTextField t1,t2,t3;
JButton b1,b2,b3;

    InsProd() {
        setTitle("Manage A Product");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Product=new JLabel("Product");
        Product.setBounds(470,100,200,30);
        Product.setFont(new Font("serif",Font.BOLD,30));
        Product.setForeground(Color.blue);
        Unitprice=new JLabel("UnitPrice");
        Unitprice.setBounds(470,170,200,30);
        Unitprice.setFont(new Font("serif",Font.BOLD,30));
        Unitprice.setForeground(Color.blue);
        qty=new JLabel("Qty");
        qty.setBounds(470,250,200,40);
        qty.setFont(new Font("serif",Font.BOLD,30));
        qty.setForeground(Color.blue);           
        t1 = new JTextField();
        t1.setBounds(700,100,120,30);
        t2 = new JTextField();
        t2.setBounds(700,170,120,30);
        t3=new JTextField();
        t3.setBounds(700,250,120,30);
        b1=new JButton("INSERT");
        b1.setBounds(300,420,150,50);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b2=new JButton("DELETE");
        b2.setBounds(500,420,150,50);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b3=new JButton("HOME");
        b3.setBounds(700,420,150,50);
        b3.setFont(new Font("serif",Font.BOLD,20));
        b3.addActionListener(this);
        b3.setActionCommand("HOME");
        add(Product);
        add(Unitprice);
        add(qty);
        add(t1);
        add(t2);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b1.setActionCommand("INSERT");
        b2.addActionListener(this);
        b2.setActionCommand("DELETE");
        setVisible(true);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("INSERT".equals(e.getActionCommand()))
            try {
                action1();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if("DELETE".equals(e.getActionCommand()))
            try {
                action2();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
            new DepartmentStore();
     //To change body of generated methods, choose Tools | Templates.
    }

    private void action1() throws ClassNotFoundException  {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cnt;
            cnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","HR");
            Statement st=cnt.createStatement();
            String s1=t1.getText();
            String s2=t2.getText();
            st.executeUpdate("insert into inven(product,qty)values('"+s1+"','"+s2+"')");
        }
        catch(SQLException e)
        {
          JOptionPane.showMessageDialog(this, t1);
        }

    }

    private void action2() throws ClassNotFoundException 
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cnt;
            cnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","HR");
            Statement st=cnt.createStatement();
            String s1=t1.getText();
            String s2=t2.getText();
            st.executeUpdate("Delete from inven where product=('"+s1+"')");
        
         //To change body of generated methods, choose Tools | Templates.
       }
        catch(SQLException e)
        {
          JOptionPane.showMessageDialog(this, t1);
        }
    }}
