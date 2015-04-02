package departmentstore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author PAVITHRA
 */
public class DepartmentStore extends JFrame implements ActionListener
{
    JLabel a;
JButton order,create,delete,inventory;
DepartmentStore()
{
    setTitle("DEPARTMENT STORE");
    setSize(1365,770);
    setBackground(Color.blue);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a=new JLabel("Shop Management System");
    a.setBounds(350,200,500,60);
    a.setFont(new Font("serif",Font.BOLD,40));
    a.setForeground(Color.MAGENTA);
    add(a);
    order=new JButton("Order");
    order.setBounds(200,420,100,50);
    order.setActionCommand("order");
    order.setFont(new Font("serif",Font.BOLD,20));
    order.addActionListener(this);
    add(order);
    create=new JButton("Create");
    create.setBounds(450,420,100,50);
    create.setActionCommand("create");
    create.setFont(new Font("serif",Font.BOLD,20));
    create.addActionListener(this);
    add(create);
    delete=new JButton("delete");
    delete.setBounds(700,420,100,50);
    delete.setActionCommand("delete");
    delete.setFont(new Font("serif",Font.BOLD,20));
    add(delete);
    delete.addActionListener(this);
    inventory=new JButton("inventory");
    inventory.setBounds(900,420,150,50);
    inventory.setActionCommand("inventory");
    inventory.setFont(new Font("serif",Font.BOLD,20));
    add(inventory);
    inventory.addActionListener(this);
    setVisible(true);
}

        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DepartmentStore();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="order")
            new CusOrdrer();
        else if(e.getActionCommand()=="create")
            new InsProd();
        else if(e.getActionCommand()=="delete")
            new InsProd();
        else
            new Inventory();
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    

