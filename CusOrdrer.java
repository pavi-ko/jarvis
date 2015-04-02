
package departmentstore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author PAVITHRA
 */
public class CusOrdrer extends JFrame implements ActionListener {
    JLabel a,b,c;
    JTextField t1,t2,t3;   
    JButton b1,b2;
    CusOrdrer()
    {
     setTitle("CUSTOMER ORDER");
     setSize(1365,770);
     setBackground(Color.red);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     a=new JLabel("Product Name");
     a.setBounds(470,150,300,30);
     a.setFont(new Font("serif",Font.BOLD,20));
     a.setForeground(Color.red);
     b=new JLabel("QTY");
     b.setBounds(470,250,200,30);
     b.setFont(new Font("serif",Font.BOLD,20));
     b.setForeground(Color.red);
     b1=new JButton("Check and Order");
     b1.setBounds(470,320,200,30);
     b1.setFont(new Font("serif",Font.BOLD,20));
     b1.setActionCommand("check");
     add(b1);
     b1.addActionListener(this);
     b2=new JButton("Home");
     b2.setBounds(870,320,200,30);
     b2.setFont(new Font("serif",Font.BOLD,20));
     b2.setActionCommand("Home");
     add(b2);
     b2.addActionListener(this);
     t1=new JTextField();
     t1.setBounds(700,150,120,30);
     t2=new JTextField();
     t2.setBounds(700,250,120,30);
     add(a);
     add(b);
     add(t1);
     add(t2);
     setVisible(true);
     }
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand()=="check") 
                new Inventory();
      else if(e.getActionCommand()=="Home")
               new DepartmentStore();
      else
                new CusOrder();
        }
    }

    

