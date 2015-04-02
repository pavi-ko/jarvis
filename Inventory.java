package departmentstore;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.Statement;
/**
 *
 * @author PAVITHRA
 */
class Inventory extends JFrame implements ActionListener {
    JLabel PID,Product,Category,qty,Unitprice;
    JTextField t1,t2,t3;
JButton b1,b2;

    public Inventory() {
        setTitle("INVENTORY");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PID=new JLabel("PID");
        PID.setBounds(470,100,200,30);
        PID.setFont(new Font("serif",Font.BOLD,30));
        PID.setForeground(Color.blue);
        Category=new JLabel("CATEGORY");
        Category.setBounds(470,300,200,30);
        Category.setFont(new Font("serif",Font.BOLD,30));
        Category.setForeground(Color.blue);
        Product=new JLabel("PRODUCT");
        Product.setBounds(470,200,200,30);
        Product.setFont(new Font("serif",Font.BOLD,30));
        Product.setForeground(Color.blue);
       
        /*qty=new JLabel("Qty");
        qty.setBounds(470,400,200,30);
        qty.setFont(new Font("serif",Font.BOLD,30));
        qty.setForeground(Color.blue); */          
        t1 = new JTextField();
        t1.setBounds(700,100,120,30);
        t2 = new JTextField();
        t2.setBounds(700,200,120,30);
        t3=new JTextField();
        t3.setBounds(700,300,120,30);
        add(PID);
        add(Category);
         add(Product);
        add(t1);
        add(t2);
        add(t3);
        b1=new JButton("VIEW");
        b1.setBounds(400,420,150,50);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.addActionListener(this);
        b1.setActionCommand("VIEW");
        b2=new JButton("HOME");
        b2.setBounds(600,420,150,50);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.addActionListener(this);
        b2.setActionCommand("HOME");
        add(b1);
        add(b2);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="VIEW")
            action();
        else if(e.getActionCommand()=="order")
            new CusOrdrer();
        else
            new DepartmentStore();
         //To change body of generated methods, choose Tools | Templates.
    }

    public void action() {
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cnt;
            cnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","HR");
            Statement st=cnt.createStatement();
            JFrame f1=new JFrame();
            f1.setSize(1300,800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            f1.setVisible(true);
            String s1,s2,s3;
            int i1,i2,i3;
            JButton b3=new JButton("Order");
            b3.setFont(new Font("serif",Font.BOLD,20));
            b3.setBounds(400,420,150,50);
            b3.addActionListener(this);
            b3.setActionCommand("order");
            JButton b4=new JButton("HOME");
            b4.setBounds(600,420,150,50);
            b4.setFont(new Font("serif",Font.BOLD,20));
            b4.addActionListener(this);
            b4.setActionCommand("HOME");
            JTextArea textArea;
            textArea = new JTextArea(80, 80); 
            textArea.setEditable(false);
            textArea.setFont(new Font("Serif", Font.ITALIC, 16));
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setVisible(true);
            
            ResultSet r=st.executeQuery("select * from INVENTORY");
            while(r.next())
            {
                
              s1=r.getString("PNAME");
              s2=r.getString("CATEGORY");
              i1 =r.getInt("PID");
              i2=r.getInt("QTY");
              i3=r.getInt("UNITPRICE");
              textArea.append(i1+"   "+s2+"   "+s1+"   "+i2+"   "+i3+"\n");
              add(textArea,BorderLayout.CENTER);
              f1.add(b3);
              f1.add(b4);
              f1.add(textArea);
             
            }
            f1.setVisible(true);
            cnt.close();
        }    

        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
            System.out.println("Error"+e);
        }
        
    }
    
}
