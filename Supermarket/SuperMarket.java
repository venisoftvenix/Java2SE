import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import javax.swing.table.*;

public class SuperMarket
{
  String body[]=new String[10];
  String temp1,name="";
  String Month1[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
  String Year1[]=new String[99];
  int tempi,tempj,tempk,templ,tempx,v,h,minY,minM,minD,DD,MM,YYYY,m=1,y=2001,m1=1,y1=2001,minHo,minMi,minSe,d1,d2,enable;
  float amount,sum=0,tempf,tempfi,so,pu;
  
  static JFrame f1;
  static JPanel p1,p2;
  static Container c;
  static ImageIcon ii1,ii2,ii3,ii4,ii5,ii6,ii7,ii8,ii9,ii10,ii11,ii12,ii13,ii14,ii15,ii16,ii17,ii18,ii19,ii20,ii21;
  static Image i1;
  static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
  static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
  static JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
  static JPasswordField pf1,pf2,pf3,pf4;
  static JTable t1,t2,t3,t4,t5,t6;
  static JComboBox cb1,cb2,cb3,cb4;
  static JCheckBox chkb1;
  static JFileChooser chooser;
  static DefaultTableModel dtm1,dtm2,dtm3,dtm4,dtm5,dtm6;

  static Connection con;
  static Statement st;
  static PreparedStatement pst;
  static ResultSet rs;
  
  static JScrollPane jsp,jsp1,jsp2,jsp3,jsp4,jsp5;
  
  static Calendar cal; 

  public SuperMarket() throws Exception
  {
    f1=new JFrame("Venisoft : Super Market");
    
    p1=new JPanel();
    p1.setLayout(null);
    p2=new JPanel();
    p2.setLayout(null);
      
    cal=new GregorianCalendar();
    
    c=f1.getContentPane();
    c.setLayout(null);
    
    chooser=new JFileChooser();
    
    chkb1=new JCheckBox("PId Reports");
    
    ii1=new ImageIcon("images/title.png");
    ii2=new ImageIcon("images/side.png");
    ii3=new ImageIcon("images/printer.png");
    ii4=new ImageIcon("images/home1.png");
    ii5=new ImageIcon("images/database.png");
    ii6=new ImageIcon("images/edit.png");
    ii7=new ImageIcon("images/distributer.png");
    ii8=new ImageIcon("images/delete.png");
    ii9=new ImageIcon("images/horizontal.png");
    ii10=new ImageIcon("images/vertical.png");
    ii11=new ImageIcon("images/horizontal2.png");
    ii12=new ImageIcon("images/vertical2.png");
    ii13=new ImageIcon("images/X1.png");
    ii14=new ImageIcon("images/X2.png");
    ii15=new ImageIcon("images/_1.png");
    ii16=new ImageIcon("images/_2.png");
    ii17=new ImageIcon("images/150X20 1.png");
    ii18=new ImageIcon("images/150X20 2.png");
    ii19=new ImageIcon("images/Middle.png");
    ii20=new ImageIcon("images/Background.png");
    ii21=new ImageIcon("images/Report.jpg");
    
    l1=new JLabel();
    l1.setIcon(ii4);
    l2=new JLabel();
    l2.setIcon(ii2);
    l3=new JLabel("",JLabel.RIGHT);
    l4=new JLabel("",JLabel.RIGHT);
    l5=new JLabel("",JLabel.RIGHT);
    l6=new JLabel("",JLabel.RIGHT);
    l7=new JLabel("",JLabel.RIGHT);
    l8=new JLabel("",JLabel.CENTER);
    l9=new JLabel();
    l9.setIcon(ii6);
    l10=new JLabel();
    l10.setIcon(ii8);
    l11=new JLabel("",JLabel.CENTER);
    l12=new JLabel("",JLabel.CENTER);
    l13=new JLabel();
    l13.setIcon(ii9);
    l14=new JLabel();
    l14.setIcon(ii10);
    l15=new JLabel();
    l15.setIcon(ii11);
    l16=new JLabel();
    l16.setIcon(ii12);
    l17=new JLabel("",JLabel.RIGHT);
    l18=new JLabel(ii20);
    
    b1=new JButton();
    b2=new JButton();
    b3=new JButton();
    b4=new JButton();
    b5=new JButton();
    b6=new JButton();
    b7=new JButton();
    b5.setText("Continue");
    b7.setText("Back");
    b5.setToolTipText("Click to CONTINUE ...");
    b8=new JButton(ii13);
    b8.setRolloverIcon(ii14);
    b8.setToolTipText("Close");
    b9=new JButton(ii15);
    b9.setRolloverIcon(ii16);
    b9.setToolTipText("Minimize");
    b10=new JButton();
    b11=new JButton();
    
    b1.setIcon(ii17);b1.setRolloverIcon(ii18);b1.setHorizontalTextPosition(JLabel.CENTER);b1.setForeground(Color.YELLOW);
    b2.setIcon(ii17);b2.setRolloverIcon(ii18);b2.setHorizontalTextPosition(JLabel.CENTER);b2.setForeground(Color.YELLOW);
    b3.setIcon(ii17);b3.setRolloverIcon(ii18);b3.setHorizontalTextPosition(JLabel.CENTER);b3.setForeground(Color.YELLOW);
    b4.setIcon(ii17);b4.setRolloverIcon(ii18);b4.setHorizontalTextPosition(JLabel.CENTER);b4.setForeground(Color.YELLOW);
    b5.setIcon(ii17);b5.setRolloverIcon(ii18);b5.setHorizontalTextPosition(JLabel.CENTER);b5.setForeground(Color.YELLOW);
    b6.setIcon(ii17);b6.setRolloverIcon(ii18);b6.setHorizontalTextPosition(JLabel.CENTER);b6.setForeground(Color.YELLOW);
    
    for(tempi=0;tempi<99;tempi++)
      if(tempi<9) Year1[tempi]="200"+Integer.toString(tempi+1);
      else Year1[tempi]="20"+Integer.toString(tempi+1);
    
    tf1=new JTextField();
    tf2=new JTextField();
    tf3=new JTextField();
    tf4=new JTextField();
    tf5=new JTextField();
    tf6=new JTextField();
    tf7=new JTextField();
    tf8=new JTextField();
    tf9=new JTextField();
    
    pf1=new JPasswordField();
    pf2=new JPasswordField();
    pf3=new JPasswordField();
    pf4=new JPasswordField();
    
    cb1=new JComboBox(Month1);
    cb2=new JComboBox(Year1);
    cb3=new JComboBox(Month1);
    cb4=new JComboBox(Year1);
    
    dtm1=new DefaultTableModel();     //Billing
    dtm2=new DefaultTableModel();     //Products
    dtm3=new DefaultTableModel();     //Distributers
    dtm4=new DefaultTableModel();
    dtm5=new DefaultTableModel();
    dtm6=new DefaultTableModel();
    
    t1=new JTable(dtm1);
    t2=new JTable(dtm2)
    {
      public boolean isCellEditable(int rowIndex, int colIndex) 
      {
        if(colIndex==0||colIndex==3)
          return false;   //Disallow the editing of any cell
        return true;
      }
    };
    t3=new JTable(dtm3)
    {
      public boolean isCellEditable(int rowIndex, int colIndex) 
      {
        return false;   //Disallow the editing of any cell
      }
    };
    t4=new JTable(dtm4)
    {
      public boolean isCellEditable(int rowIndex, int colIndex) 
      {
        return false;   //Disallow the editing of any cell
      }
    };
    t5=new JTable(dtm5)
    {
      public boolean isCellEditable(int rowIndex, int colIndex) 
      {
        return false;   //Disallow the editing of any cell
      }
    };
    t6=new JTable(dtm6)
    {
      public boolean isCellEditable(int rowIndex, int colIndex) 
      {
        return false;   //Disallow the editing of any cell
      }
    };
    
    dtm1.addColumn("PID");
    dtm1.addColumn("Product Name");
    dtm1.addColumn("Price");
    dtm1.addColumn("Quantity");
    dtm1.addColumn("Amount");
    
    dtm2.addColumn("PID");
    dtm2.addColumn("Product Name");
    dtm2.addColumn("Price");
    dtm2.addColumn("Quantity");
    
    dtm3.addColumn("DID");
    dtm3.addColumn("Distributer Name");
    dtm3.addColumn("PID");
    dtm3.addColumn("Price");
    dtm3.addColumn("Quantity");
    dtm3.addColumn("Amount");
    dtm3.addColumn("Paid");
    dtm3.addColumn("Balance");
    dtm3.addColumn("Date");
    
    dtm4.addColumn("S");
    dtm4.addColumn("M");
    dtm4.addColumn("T");
    dtm4.addColumn("W");
    dtm4.addColumn("T");
    dtm4.addColumn("F");
    dtm4.addColumn("S");
    
    dtm5.addColumn("S");
    dtm5.addColumn("M");
    dtm5.addColumn("T");
    dtm5.addColumn("W");
    dtm5.addColumn("T");
    dtm5.addColumn("F");
    dtm5.addColumn("S");
    
    dtm6.addColumn("PId");
    dtm6.addColumn("Quantity");
    dtm6.addColumn("SPrice");
    dtm6.addColumn("PPrice");
    dtm6.addColumn("SValue");
    dtm6.addColumn("PValue");
    dtm6.addColumn("Date");
    
    v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    jsp=new JScrollPane(t1,v,h);
    jsp1=new JScrollPane(t2,v,h);
    jsp2=new JScrollPane(t3,v,h);
    v=ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;
    h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    jsp3=new JScrollPane(t4,v,h);
    jsp4=new JScrollPane(t5,v,h);
    v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    jsp5=new JScrollPane(t6,v,h);
    
    t4.setRowSelectionAllowed(true);
    t4.setColumnSelectionAllowed(true);
    t4.setSelectionForeground(Color.BLUE);
    t5.setRowSelectionAllowed(true);
    t5.setColumnSelectionAllowed(true);
    t5.setSelectionForeground(Color.BLUE);
    
    TableColumn column=t1.getColumnModel().getColumn(1);
    column.setPreferredWidth(150);
    column=t2.getColumnModel().getColumn(1);
    column.setPreferredWidth(150);
    column=t3.getColumnModel().getColumn(1);
    column.setPreferredWidth(150);


    ActionHandler ah=new ActionHandler();
    MouseHandler mh=new MouseHandler();
    ItemHandler ih=new ItemHandler();
    
    b1.addActionListener(ah);
    b2.addActionListener(ah);
    b3.addActionListener(ah);
    b4.addActionListener(ah);
    b5.addActionListener(ah);
    b6.addActionListener(ah);
    b7.addActionListener(ah);
    b8.addActionListener(ah);
    b9.addActionListener(ah);
    b10.addActionListener(ah);
    b11.addActionListener(ah);
    
    tf1.addActionListener(ah);
    
    cb1.addItemListener(ih);
    cb2.addItemListener(ih);
    cb3.addItemListener(ih);
    cb4.addItemListener(ih);
    
    chkb1.addItemListener(ih);
    
    f1.addMouseListener(mh);
    f1.addMouseMotionListener(mh);

    p1.setVisible(false);
    f1.add(p1);
    p2.setVisible(false);
    f1.add(p2);

    c.add(pf1);
    c.add(pf2);
    c.add(pf3);
    c.add(pf4);
    
    c.add(chkb1);chkb1.setVisible(false);
    
    b1.setBounds(250,150,150,20); c.add(b1);    b1.setVisible(false);   
    b2.setBounds(250,180,150,20); c.add(b2);    b2.setVisible(false);   
    b3.setBounds(250,210,150,20); c.add(b3);    b3.setVisible(false);   
    b4.setBounds(250,270,150,20); c.add(b4);    b4.setVisible(false);   
    b6.setBounds(600,185,140,20); c.add(b6);    b6.setVisible(false);   
    b7.setBounds(600,185,140,20); c.add(b7);    b7.setVisible(false);   
    b8.setBounds(758,2,40,16);    c.add(b8);    b8.setVisible(true);    
    b9.setBounds(721,2,36,16);    c.add(b9);    b9.setVisible(true);    
    b5.setBounds(660,520,100,30); c.add(b5);    b5.setVisible(true);
    c.add(b10);    b10.setVisible(false);
    c.add(b11);    b11.setVisible(false);

    tf1.setBounds(245,115,100,20);c.add(tf1);   tf1.setVisible(false);  
    tf2.setBounds(245,160,150,20);c.add(tf2);   tf2.setVisible(false);  
    tf3.setBounds(245,185,150,20);c.add(tf3);   tf3.setVisible(false);   
    tf4.setBounds(485,160,100,20);c.add(tf4);   tf4.setVisible(false);  
    tf5.setBounds(485,185,100,20);c.add(tf5);   tf5.setVisible(false);  
    tf6.setBounds(485,485,100,20);c.add(tf6);   tf6.setVisible(false);  
    tf7.setBounds(485,485,100,20);c.add(tf7);   tf7.setVisible(false);
    tf8.setBounds(485,485,100,20);c.add(tf8);   tf8.setVisible(false);
    c.add(tf9);   tf9.setVisible(false);
    
    cb1.setBounds(485,485,100,20);c.add(cb1);   cb1.setVisible(false);
    cb2.setBounds(485,485,100,20);c.add(cb2);   cb2.setVisible(false);
    cb3.setBounds(485,485,100,20);c.add(cb3);   cb3.setVisible(false);
    cb4.setBounds(485,485,100,20);c.add(cb4);   cb4.setVisible(false);
    
    jsp.setBounds(125,215,590,194); c.add(jsp);   jsp.setVisible(false);
    jsp1.setBounds(125,215,590,194);c.add(jsp1);  jsp1.setVisible(false);
    jsp2.setBounds(125,215,590,194);c.add(jsp2);  jsp2.setVisible(false);
    jsp3.setBounds(125,215,590,194);c.add(jsp3);  jsp3.setVisible(false);
    jsp4.setBounds(125,215,590,194);c.add(jsp4);  jsp4.setVisible(false);
    c.add(jsp5);  jsp5.setVisible(false);
    
    
    l13.setBounds(2,595,796,5);   c.add(l13);   l13.setVisible(true);   
    l14.setBounds(0,2,5,600);     c.add(l14);   l14.setVisible(true);   
    l15.setBounds(2,0,796,5);     c.add(l15);   l15.setVisible(true);   
    l16.setBounds(795,0,5,600);   c.add(l16);   l16.setVisible(true);   
    l1.setBounds(0,0,800,600);    c.add(l1);    l1.setVisible(true);    
    l2.setBounds(0,100,200,500);  c.add(l2);    l2.setVisible(false);   
    l3.setBounds(160,105,80,30);  c.add(l3);    l3.setVisible(false);
    l4.setBounds(160,150,80,30);  c.add(l4);    l4.setVisible(false);      
    l5.setBounds(140,175,100,30); c.add(l5);    l5.setVisible(false);   
    l6.setBounds(380,150,100,30); c.add(l6);    l6.setVisible(false);   
    l7.setBounds(400,175,80,30);  c.add(l7);    l7.setVisible(false);   
    l8.setBounds(400,175,80,30);  c.add(l8);    l8.setVisible(false);
    l9.setBounds(400,175,80,30);  c.add(l9);    l9.setVisible(false);
    l10.setBounds(400,175,80,30); c.add(l10);   l10.setVisible(false);
    l11.setBounds(400,175,80,30); c.add(l11);   l11.setVisible(false);
    l12.setBounds(400,175,80,30); c.add(l12);   l12.setVisible(false);
    l4.setBounds(160,150,80,30);  c.add(l4);    l4.setVisible(false);
    l17.setBounds(400,175,80,30); c.add(l17);   l17.setVisible(false);
    l18.setBounds(0,0,800,600);   c.add(l18);   l18.setVisible(false);
    
    f1.setSize(800,600);
    f1.setResizable(false);
    f1.setLocationRelativeTo(null);
    f1.setUndecorated(true);
    f1.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    f1.show();

    try
    {
      System.out.println("wait Connecting ...");
      //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      //Class.forName("com.mysql.jdbc.Driver");
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      try
      {
        //con=DriverManager.getConnection("Jdbc:Odbc:venixsri","system","manager");
		//con=DriverManager.getConnection("Jdbc:mysql://183.83.62.98:3306/medicalstore","root","venisoft");
		con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sm;user=sa;password=venisoft");
        System.out.println("Connected ...");
      }
      catch(Exception connection)
      {
        JOptionPane.showMessageDialog(null,"Data Base connection FAILED\nPlease Install/Reinstall DATABASE and then configure settings properly.\n"+connection);
        return;
      }
    }
    catch(Exception driver)
    {
      JOptionPane.showMessageDialog(null,"Data Base Driver NOT found.\nPlease Install/Reinstall DATABASE DRIVER.");
      return;
    }

    st=con.createStatement();
    
    try
    {
      rs=st.executeQuery("select * from Products");
    }
    catch(Exception products)
    {
      //st.executeUpdate("create table Products(PId varchar2(10),PName varchar2(30),PPrice float)");
      st.executeUpdate("create table Products(PId varchar(10),PName varchar(30),PPrice float)");
    }
    try
    {
      rs=st.executeQuery("select * from Distributers");
    }
    catch(Exception products)
    {
      //st.executeUpdate("create table Distributers(DId varchar2(10),DName varchar2(20),PId varchar2(10),PPrice float,PQuantity int,Paid float,MM int,YYYY int,DD int)");
      st.executeUpdate("create table Distributers(DId varchar(10),DName varchar(20),PId varchar(10),PPrice float,PQuantity int,Paid float,MM int,YYYY int,DD int)");
    }
    try
    {
      rs=st.executeQuery("select * from Stack");
    }
    catch(Exception products)
    {
      //st.executeUpdate("create table Stack(PId varchar2(10),PPrice float,PQuantity int,MM int,YYYY int,DD int,H int,M int,S int)");
      st.executeUpdate("create table Stack(PId varchar(10),PPrice float,PQuantity int,MM int,YYYY int,DD int,H int,M int,S int)");
    }
    try
    {
      rs=st.executeQuery("select * from Records");
    }
    catch(Exception products)
    {
      //st.executeUpdate("create table Records(PId varchar2(10),PQuantity int,SPrice float,PPrice float,DD int,MM int,YYYY int)");
      st.executeUpdate("create table Records(PId varchar(10),PQuantity int,SPrice float,PPrice float,DD int,MM int,YYYY int)");
    }
    try
    {
      rs=st.executeQuery("select * from VenisoftSuperMarketLogin");
    }
    catch(Exception products)
    {
      //st.executeUpdate("create table VenisoftSuperMarketLogin(Id varchar2(10),Name varchar2(20),Password varchar2(20),Type int)");
      st.executeUpdate("create table VenisoftSuperMarketLogin(Id varchar(10),Name varchar(20),Password varchar(20),Type int)");
      st.executeUpdate("insert into VenisoftSuperMarketLogin values('0000','Admin','admin',1)");
    }
    
  }
  public static void main(String args[]) throws Exception
  {
    SuperMarket sm=new SuperMarket();
  }
  public class ActionHandler implements ActionListener
  {
    Object obj;
    Object o[]=new Object[4];
    float purchage,sold;
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==b1)                                                         //b1  **************************
      {
      	if(e.getActionCommand()=="Create Cashier")
      	{
          if(tf1.getText().equals("")||tf2.getText().equals("")||pf1.getText().equals("")||pf2.getText().equals(""))
          {
            JOptionPane.showMessageDialog(null,"Error: Some fields are empty ...");
            return;
          }
          if(!pf1.getText().equals(pf2.getText()))
          {
            JOptionPane.showMessageDialog(null,"Error: Passwords not matched ...");
            return;
          }
          try
          {
            pst=con.prepareStatement("select * from VenisoftSuperMarketLogin");
            rs=pst.executeQuery();
            while(rs.next())
            {
              if(tf2.getText().equals(rs.getString(1)))
              {
                JOptionPane.showMessageDialog(null,"Error: Cashier already exists ...");
                return;
              }
            }
            pst=con.prepareStatement("insert into VenisoftSuperMarketLogin values(?,?,?,?)");
            pst.setString(1,tf2.getText());
            pst.setString(2,tf1.getText());
            pst.setString(3,pf1.getText());
            pst.setInt(4,0);
            pst.executeUpdate();
            pst=con.prepareStatement("commit");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully CASHIER account is created");
            return;
          }
          catch(Exception creation){}
      	}
        if(e.getActionCommand()=="Modify Product")
        {
          l8.setVisible(true);
          l8.setBounds(250,460,400,20);
          try
          {
            tempi=t2.getSelectedRow();
            System.out.println(tempi+":i");
            o[0]=dtm2.getValueAt(tempi,0);
            o[1]=dtm2.getValueAt(tempi,1);
            o[2]=dtm2.getValueAt(tempi,2);
          }
          catch(Exception d1)
          {
            l8.setText("No Product is SELECTED");
          }
          try
          {
            pst=con.prepareStatement("update Products set PName=?,PPrice=? where PId=?");
            pst.setString(1,o[1].toString());
            pst.setFloat(2,Float.parseFloat(o[2].toString()));
            pst.setString(3,o[0].toString());
            pst.executeUpdate();
            st.executeUpdate("commit");
            System.out.println("Committed==>>");
            l8.setText("Sucessfully MODIFIED");
          }
          catch(Exception d2)
          {
            l8.setText("Database Error");
          }
        }
        if(e.getActionCommand()=="AMD Products")
        {
          f1.add(tf3);
          f1.add(l9);
          f1.add(l10);
          
          f1.remove(l18);
          l2.setIcon(ii5);
          l2.setBounds(0,100,134,134);
          l3.setText("ADD / MODIFY / DELETE  Products");
          l3.setBounds(200,105,300,20);
          l3.setVisible(true);
          l4.setVisible(true);   //ID
          l5.setVisible(true);   //Product Name
          l6.setVisible(true);   //Price
          l7.setVisible(false);   //Quantity
          l4.setIcon(null);
          l4.setText("Product Id:");
          l5.setText("Product Name:");
          l6.setText("Price:");
          l4.setBounds(290,130,80,30); 
          l6.setBounds(270,180,100,30);
          l5.setBounds(270,155,100,30);
          l9.setBounds(20,250,134,134);
          l10.setBounds(20,400,134,134);
          l9.setText("");
          l10.setText("");
          l9.setIcon(ii6);
          l10.setIcon(ii8);
          l9.setVisible(true);
          l10.setVisible(true);
          
          
          tf2.setText("");
          tf4.setText("");
          tf3.setText("");
          tf5.setText("");
          tf2.setToolTipText("Enter Product ID");
          tf3.setToolTipText("Enter Product NAME");
          tf4.setToolTipText("Enter Product PRICE");
          tf2.setBounds(375,135,150,20);
          tf4.setBounds(375,185,150,20);
          tf3.setBounds(375,160,150,20);
          tf2.setEditable(true);
          tf3.setEditable(true);
          tf4.setEditable(true);
          tf5.setEditable(false);
          tf1.setEditable(true);
          tf2.setVisible(true);  //ID
          tf3.setVisible(true);  //Product 
          tf4.setVisible(true);  //Price
                             
          b1.setVisible(true);
          b2.setVisible(false);
          b3.setVisible(true);
          b4.setVisible(false);
          b1.setText("Modify Product");
          b1.setToolTipText("Click here to Mofify Selected Product");
          b5.setText("Add Product");
          b5.setToolTipText("Click here to add to Database");
          b5.setBounds(600,185,150,20);
          b1.setBounds(160,420,150,20);
          b5.setVisible(true);
          b7.setVisible(true);
          b7.setBounds(380,530,100,20);
          b7.setToolTipText("Click to go BACK...");
          b3.setText("Delete Product");
          b3.setBounds(600,420,150,20);
          
          b11.setVisible(true);
          b11.setText("Print");
          b11.setBounds(400,420,100,20);
          b11.setIcon(ii17);
          b11.setRolloverIcon(ii18);
          b11.setHorizontalTextPosition(JLabel.CENTER);
          b11.setForeground(Color.yellow);
          
          jsp1.setBounds(160,220,590,194);
          jsp.setVisible(false);
          jsp1.setVisible(true);
          t1.setVisible(false);
          t2.setVisible(true);
          
          f1.add(l18);
          l18.setVisible(true);
          
          for(tempi=t2.getRowCount()-1;tempi>=0;tempi--)
            dtm2.removeRow(tempi);
          Object objects[]=new Object[4];
          try
          {
            rs=st.executeQuery("select * from Products");
            while(rs.next())
            {
              objects[0]=rs.getString(1);
              objects[1]=rs.getString(2);
              objects[2]=Float.toString(rs.getFloat(3));
              objects[3]=Integer.toString(0);;
              dtm2.addRow(objects);
            }
            for(tempi=0;tempi<dtm2.getRowCount();tempi++)
            {
              rs=st.executeQuery("select * from Stack");
              while(rs.next())
              {
                if(rs.getString(1).equals(dtm2.getValueAt(tempi,0).toString()))
                {
                  dtm2.setValueAt(rs.getInt(3)+Integer.parseInt(dtm2.getValueAt(tempi,3).toString()),tempi,3);
                }
              }
            }
          }
          catch(Exception amd){}   
        }
      }
      
      if(e.getSource()==b2)                                                         //b2   **************************
      {
        if(e.getActionCommand()=="Change Password")
        {
          if(pf3.getText().equals(pf4.getText()))
          {
            try
            {
              pst=con.prepareStatement("update VenisoftSuperMarketLogin set Password=? where Name=?");
              pst.setString(1,pf3.getText());
              pst.setString(2,tf3.getText());
              pst.executeUpdate();
              pst=con.prepareStatement("commit");
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null,"Password Changed Successfully");
            }
            catch(Exception skjgfldkgh){JOptionPane.showMessageDialog(null,"Error :\nUser Name not found ...");}
          }
          else
          {
            JOptionPane.showMessageDialog(null,"Passwords Not Matched.");
          }
        }
        if(e.getActionCommand()=="Modify Payment")
        {
          l8.setText("");
          l8.setVisible(true);
          l8.setBounds(250,460,400,20);
          try
          {
            tempi=t3.getSelectedRow();
            if((Float.parseFloat(t3.getValueAt(tempi,7).toString()))>0.0)
            {
              try
              {
                tempfi=Float.parseFloat(tf6.getText());
                if(Float.parseFloat(t3.getValueAt(tempi,7).toString())>=tempfi)
                {
                  try
                  {
                    pst=con.prepareStatement("update Distributers set Paid=? where DId=? and PId=? and DD=? and MM=? and YYYY=?");
                    System.out.println("1");
                    pst.setFloat(1,tempfi+Float.parseFloat(t3.getValueAt(tempi,6).toString()));System.out.println("2");
                    pst.setString(2,dtm3.getValueAt(tempi,0).toString());System.out.println("3");
                    pst.setString(3,dtm3.getValueAt(tempi,2).toString());System.out.println("4");
                    pst.setInt(4,100+Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(0,2)));System.out.println("5");
                    pst.setInt(5,100+Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(3,5)));System.out.println("6");
                    pst.setInt(6,Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(6,10)));System.out.println("7");
                    pst.executeUpdate();System.out.println("8");
                    st.executeUpdate("commit");System.out.println("9");
                    System.out.println("Committed==>>");
                    
                    tempf=tempfi+Float.parseFloat(t3.getValueAt(tempi,6).toString());
                    t3.setValueAt(Float.toString(tempf),tempi,6);
                    tempf=Float.parseFloat(t3.getValueAt(tempi,7).toString())-tempfi;
                    t3.setValueAt(Float.toString(tempf),tempi,7);
                  }
                  catch(Exception db){l8.setText("DATABASE Error");}
                }
                else
                  l8.setText("Your Quoted BALANCE is MORE than the required payment");
              }
              catch(Exception num){l8.setText("Enter NUMBERS only");}
            }
            else
              l8.setText("You paid all the BALANCE PAYMENT");
          }
          catch(Exception row){l8.setText("You have not SELECTED any ROW");}
        }
        
        if(e.getActionCommand()=="Reports")
        {
          chkb1.setVisible(true);
          chkb1.setBounds(130,200,100,20);
          chkb1.setToolTipText("Select to get INDIVIDUVAL PRODUCT Repors");
          
          b1.setVisible(false);
          b2.setVisible(true);
          b2.setText("Submit");
          b2.setToolTipText("Click to get the Reports");
          b2.setBounds(670,269,100,20);
          b4.setVisible(false);
          b3.setVisible(false);
          b5.setVisible(false);
          b7.setVisible(true);
          b7.setBounds(380,530,100,20);
          tf6.setVisible(false);
          l4.setVisible(true);
          l4.setBounds(0,0,800,600);
          l4.setIcon(ii20);
          l2.setVisible(true);
          l2.setBounds(0,101,100,100);
          l2.setIcon(ii21);
          
          cb1.removeAllItems();
          cb1.addItem(Month1[0]);cb1.addItem(Month1[1]);cb1.addItem(Month1[2]);cb1.addItem(Month1[3]);cb1.addItem(Month1[4]);
		      cb1.addItem(Month1[5]);cb1.addItem(Month1[6]);cb1.addItem(Month1[7]);cb1.addItem(Month1[8]);cb1.addItem(Month1[9]);
		      cb1.addItem(Month1[10]);cb1.addItem(Month1[11]);
		  
	    	  cb3.removeAllItems();
          cb3.addItem(Month1[0]);cb3.addItem(Month1[1]);cb3.addItem(Month1[2]);cb3.addItem(Month1[3]);cb3.addItem(Month1[4]);
		      cb3.addItem(Month1[5]);cb3.addItem(Month1[6]);cb3.addItem(Month1[7]);cb3.addItem(Month1[8]);cb3.addItem(Month1[9]);
	    	  cb3.addItem(Month1[10]);cb3.addItem(Month1[11]);
		  
          cb1.setVisible(true);
          cb1.setBounds(300,150,70,20);
          cb2.setVisible(true);
          cb2.setBounds(380,150,70,20);
          cb3.setVisible(true);
          cb3.setBounds(500,150,70,20);
          cb4.setVisible(true);
          cb4.setBounds(580,150,70,20);
          
          jsp3.setBounds(300,175,150,115);
          jsp3.setVisible(true);
          jsp4.setBounds(500,175,150,115);
          jsp4.setVisible(true);
          
          jsp5.setBounds(120,300,650,200);
          jsp5.setVisible(true);
          
          calendarLeft(1,1,2001);
          calendarRight(1,1,2001);
        }
        
        if(e.getActionCommand()=="Submit")
        {
          int t1=1;
          try
          {
            d1=Integer.parseInt(t4.getValueAt(t4.getSelectedRow(),t4.getSelectedColumn()).toString());
            d2=Integer.parseInt(t5.getValueAt(t5.getSelectedRow(),t5.getSelectedColumn()).toString());
            if(Integer.toString(d1).equals(" ")||Integer.toString(d2).equals(" "))
            {
              t1=0;
              JOptionPane.showMessageDialog(null,"Dont select BLANK DATES");
            }
          }
          catch(Exception date)
          {
            t1=0;
            JOptionPane.showMessageDialog(null,"Error:\nSelect FROM DATE and TO DATE\nDont select BLANK DATES");
          }
          if(t1==1)
          {
            amount=0;tempf=0;
            System.out.println("d1:"+d1+" d2:"+d2);
            System.out.println("m1:"+m+" m2:"+m1);
            System.out.println("y1:"+y+" y2:"+y1);
            for(tempi=t6.getRowCount()-1;tempi>=0;tempi--)
            dtm6.removeRow(tempi);
            try
            {
              pst=con.prepareStatement("select * from Records where (DD>=? or DD<=?) and (DD>=? or DD<=?) and (MM>=? or MM<=?) and (MM>=? or MM<=?) and YYYY>=? and YYYY<=?");
              pst.setInt(1,d1);
              pst.setInt(2,d1);
              pst.setInt(3,d2);
              pst.setInt(4,d2);
              pst.setInt(5,m);
              pst.setInt(6,m);
              pst.setInt(7,m1);
              pst.setInt(8,m1);
              pst.setInt(9,y);
              pst.setInt(10,y1);
              rs=pst.executeQuery();
              Object obj[]=new Object[7];
              while(rs.next())
              {
                obj[0]=rs.getString(1);
                if(chkb1.isSelected()==true)
                {
                  if(!obj[0].toString().equals(tf9.getText()))
                  {
                    continue;
                  }
                } 
                
                obj[1]=Integer.toString(rs.getInt(2));
                obj[2]=Float.toString(rs.getFloat(3));
                obj[3]=Float.toString(rs.getFloat(4));
                obj[6]=Integer.toString(rs.getInt(5))+":"+Integer.toString(rs.getInt(6))+":"+Integer.toString(rs.getInt(7));
                
                amount+=(rs.getInt(2)*rs.getFloat(3));  //S
                obj[4]=Float.toString(amount);
                tempf+=(rs.getInt(2)*rs.getFloat(4));   //P
                obj[5]=Float.toString(tempf);
                dtm6.addRow(obj);
              }
              obj[0]="";obj[1]="";obj[2]="";obj[3]="";obj[4]="";obj[5]="";obj[6]="";dtm6.addRow(obj);
              obj[0]="";obj[1]="";obj[2]="";obj[3]="";obj[4]="";obj[5]="";obj[6]="";dtm6.addRow(obj);
              tempfi=amount-tempf;
              obj[0]="";obj[1]="";obj[2]="Total:";obj[3]="";obj[4]=Float.toString(amount);obj[5]=Float.toString(tempf);obj[6]="";dtm6.addRow(obj);
              if(tempfi>0)
              {
                obj[0]="";obj[1]="";obj[2]="";obj[3]="";obj[4]="PROFIT:";obj[5]=Float.toString(tempfi);obj[6]="";
              }
              else if(tempfi<0)
              {
                obj[0]="";obj[1]="";obj[2]="";obj[3]="";obj[4]="LOSS:";obj[5]=Float.toString(-tempfi);obj[6]="";
              }
              else if(tempfi==0)
              {
                obj[0]="";obj[1]="";obj[2]="";obj[3]="";obj[4]="NO P/L:";obj[5]=Float.toString(tempfi);obj[6]="";
              }
              dtm6.addRow(obj);
              t6.print();
            }
            catch(Exception reports){System.out.println("xxxxxxxxxxxx");}
          }
        }
        
        if(e.getActionCommand()=="Print Bill")
        {
          try
          {
            for(tempk=0;tempk<dtm1.getRowCount();tempk++)
            {
              System.out.println("0..."+dtm1.getRowCount());
              tempj=Integer.parseInt(dtm1.getValueAt(tempk,3).toString()); //Q
              tempfi=Float.parseFloat(dtm1.getValueAt(tempk,2).toString());//SV
              temp1=dtm1.getValueAt(tempk,0).toString();//PId
              System.out.println("1..."+"tempj:"+tempj+"tempfi:"+tempfi+"Pid:"+temp1);

              do
              {
              //To find MIN date	
              pst=con.prepareStatement("select S0.DD,S0.MM,S0.YYYY,S0.H,S0.M,S0.S from Stack S0 where S0.S=(select Min(S1.S) from Stack S1 where S1.M=(select Min(S2.M) from Stack S2 where S2.H=(select Min(S3.H) from Stack S3 where S3.DD=(select Min(S4.DD) from Stack S4 where S4.MM=(select Min(S5.MM) from Stack S5 where S5.YYYY=(select Min(S6.YYYY) from Stack S6 where S6.PId=?) and S5.PId=?) and S4.PId=?) and S3.PId=?) and S2.PId=?) and S1.PId=?) and S0.PId=?");
              pst.setString(1,temp1);
              pst.setString(2,temp1);
              pst.setString(3,temp1);
              pst.setString(4,temp1);
              pst.setString(5,temp1);
              pst.setString(6,temp1);
              pst.setString(7,temp1);
              rs=pst.executeQuery();
              rs.next();
              try
              {
                minD=rs.getInt(1);
                minM=rs.getInt(2);
                minY=rs.getInt(3);
                minHo=rs.getInt(4);
                minMi=rs.getInt(5);
                minSe=rs.getInt(6);
                System.out.println(minD+":"+minM+":"+minY+":"+minHo+":"+minMi+":"+minSe);
              }
              catch(Exception noproduct)
              {
                JOptionPane.showMessageDialog(null,"ERROR:Stock is quoted less.\nPlease check the stock and update immediatly.\n\nProduct Name:"+temp1+"\nQuantity NOT Processed:"+tempj);
                break;
              }
              //Read Product details
              tempi=0;tempf=0;
              pst=con.prepareStatement("select PPrice,PQuantity from Stack where Pid=? and MM=? and YYYY=? and DD=? and H=? and M=? and S=?");
              System.out.println("11");
              pst.setString(1,temp1);System.out.println("12");
              pst.setInt(2,minM);System.out.println("13");
              pst.setInt(3,minY);System.out.println("14");
              pst.setInt(4,minD);System.out.println("15");
              pst.setInt(5,minHo);System.out.println("16");
              pst.setInt(6,minMi);System.out.println("17");
              pst.setInt(7,minSe);System.out.println("18");
              rs=pst.executeQuery();System.out.println("19");
              if(rs.next()==true)
              {
                tempi=rs.getInt(rs.findColumn("PQuantity"));  System.out.println("110"); //q
                tempf=rs.getFloat(rs.findColumn("PPrice"));System.out.println("111"); //PV
              }
              else 
              {
                JOptionPane.showMessageDialog(null,"Software not updated to latest products.\n"+temp1+"Transcation is currently STOPPED.\nPlease update this product and try again.");
                System.out.println("else");
              }
              System.out.println("3..."+"tempf:"+tempf+"tempi:"+tempi);
              cal.clear();
              cal=new GregorianCalendar();
              if(tempi>=tempj) //stock >= q
              {
                tempi-=tempj;
                pst=con.prepareStatement("update Stack set PQuantity=? where Pid=? and MM=? and YYYY=? and DD=? and H=? and M=? and S=?");
                pst.setInt(1,tempi);
                pst.setString(2,temp1);
                System.out.println("4...");
                pst.setInt(3,minM);
                pst.setInt(4,minY);
                pst.setInt(5,minD);
                pst.setInt(6,minHo);
                pst.setInt(7,minMi);
                pst.setInt(8,minSe);
                pst.executeUpdate();
                pst=con.prepareStatement("commit");
                pst.executeUpdate();
                
                //so=tempfi*tempj;
                //pu=tempf*tempj;
                pst=con.prepareStatement("insert into Records values(?,?,?,?,?,?,?)");
                pst.setString(1,temp1);
                pst.setInt(2,tempj);
                pst.setFloat(3,tempfi);
                pst.setFloat(4,tempf);
                pst.setInt(5,cal.get(Calendar.DATE));  
                pst.setInt(6,cal.get(Calendar.MONTH)+1);
                pst.setInt(7,cal.get(Calendar.YEAR));
                pst.executeUpdate();
                pst=con.prepareStatement("commit");
                pst.executeUpdate();
                tempj=0;
                
                if(tempi==0)
                {
                  pst=con.prepareStatement("delete from Stack where Pid=? and MM=? and YYYY=? and DD=? and H=? and M=? and S=?");
                  pst.setString(1,temp1);
                  pst.setInt(2,minM);
                  pst.setInt(3,minY);
                  pst.setInt(4,minD);
                  pst.setInt(5,minHo);
                  pst.setInt(6,minMi);
                  pst.setInt(7,minSe);
                  pst.executeUpdate();
                  pst=con.prepareStatement("commit");
                  pst.executeUpdate();
                }
              }
              else
              {
                tempj-=tempi;
                pst=con.prepareStatement("insert into Records values(?,?,?,?,?,?,?)");
                pst.setString(1,temp1);
                pst.setInt(2,tempi);
                pst.setFloat(3,tempfi);
                pst.setFloat(4,tempf);
                pst.setInt(5,cal.get(Calendar.DATE));  
                pst.setInt(6,cal.get(Calendar.MONTH)+1);
                pst.setInt(7,cal.get(Calendar.YEAR));
                pst.executeUpdate();
                pst=con.prepareStatement("commit");
                pst.executeUpdate();
                
                pst=con.prepareStatement("delete from Stack where Pid=? and MM=? and YYYY=? and DD=? and H=? and M=? and S=?");
                pst.setString(1,temp1);
                pst.setInt(2,minM);
                pst.setInt(3,minY);
                pst.setInt(4,minD);
                pst.setInt(5,minHo);
                pst.setInt(6,minMi);
                pst.setInt(7,minSe);
                pst.executeUpdate();
                pst=con.prepareStatement("commit");
                pst.executeUpdate();
              }
              }while(tempj!=0);
            }//for
          }//try
          catch(Exception erre){System.out.println("321...123"+erre);}
          
          body[0]="";
          body[1]="";
          body[2]="";
          body[3]="";
          body[4]="";
          dtm1.addRow(body);
          body[3]="Total";
          body[4]=tf6.getText();
          dtm1.addRow(body);
          try
          {
            t1.print();
          }
          catch(Exception print){}
        }
      }
      
      if(e.getSource()==b3)                                                         //b3   **************************
      {
        if(e.getActionCommand()=="Settings")
        {
          b5.setVisible(false);

          b3.setText("Create Backup");
          b3.setBounds(620,140,150,50);

          b4.setText("Upload Backup");
          b4.setBounds(620,230,150,50);
          b4.setVisible(true);
          
          b2.setBounds(400,400,150,20);
          b7.setText("Back");
          b7.setBounds(380,530,100,20);
          b7.setVisible(true);
          l2.setIcon(new ImageIcon("images/Settings.png"));
          l2.setBounds(0,101,256,256);
          l4.setIcon(ii20);
          l4.setBounds(0,101,800,599);
          l4.setVisible(true);
          
          l5.setText("Cashier User Name:");
          l5.setIcon(null);
          l5.setBounds(0,50,150,20);
          l5.setVisible(true);
          
          l6.setText("Cashier Password :");
          l6.setIcon(null);
          l6.setBounds(0,80,150,20);
          l6.setVisible(true);
          
          l7.setText("Re-Type Password :");
          l7.setIcon(null);
          l7.setBounds(0,110,150,20);
          l7.setVisible(true);
          
          l8.setText("                            Cashier ID :");
          l8.setIcon(null);
          l8.setBounds(0,20,150,20);
          l8.setVisible(true);
          
          tf2.setText("");
          tf2.setBounds(150,53,150,20);
          tf2.setVisible(true);
          
          tf1.setText("");
          tf1.setBounds(150,23,150,20);
          tf1.setVisible(true);
          
          pf1.setText("");
          pf1.setBounds(150,83,150,20);
          pf1.setVisible(true);
          
          pf2.setText("");
          pf2.setBounds(150,113,150,20);
          pf2.setVisible(true);
          
          b1.setText("Create Cashier");
          b1.setBounds(100,143,150,20);
          b1.setVisible(true);
          
          p1.setBorder(new TitledBorder("Create Cashier Account"));
          p1.add(l8);p1.add(tf2);
          p1.add(l5);p1.add(tf1);
          p1.add(l6);p1.add(pf1);
          p1.add(l7);p1.add(pf2);
          p1.add(b1);
          
          p1.setBounds(260,120,320,180);
          p1.setVisible(true);
          
          l9.setText("User Name:");
          l9.setIcon(null);
          l9.setBounds(70,30,100,20);
          l9.setVisible(true);
          
          l10.setText("Password :");
          l10.setIcon(null);
          l10.setBounds(72,60,100,20);
          l10.setVisible(true);
          
          l11.setText("Re - Type:");
          l11.setIcon(null);
          l11.setBounds(50,90,120,20);
          l11.setVisible(true);
          
          tf3.setText("");
          tf3.setBounds(140,33,150,20);
          tf3.setVisible(true);
          
          pf3.setText("");
          pf3.setBounds(140,63,150,20);
          pf3.setVisible(true);
          
          pf4.setText("");
          pf4.setBounds(140,93,150,20);
          pf4.setVisible(true);
          
          b2.setText("Change Password");
          b2.setBounds(100,130,150,20);
          b2.setVisible(true);
          
          p2.setBorder(new TitledBorder("Change Password"));
          p2.add(l9);p2.add(l10);p2.add(l11);
          p2.add(tf3);p2.add(pf3);p2.add(pf4);
          p2.add(b2);
          
          
          p2.setBounds(260,320,320,180);
          p2.setVisible(true);
        }
        
        if(e.getActionCommand()=="Create Backup")
        {
          try
          {
            chooser.setCurrentDirectory(new File("."));
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() 
            {
              public boolean accept(File f) 
              {
                return f.getName().toLowerCase().endsWith(".vsm")||f.isDirectory();
              }
            
              public String getDescription() {
                return "Venisoft VSM Files";
              }
            });
            
            int r=chooser.showSaveDialog(new JFrame());
            if(r==JFileChooser.APPROVE_OPTION) 
            {
              name = chooser.getSelectedFile().getName();
              System.out.println(chooser.getCurrentDirectory().getPath()+"\\"+name);
            }
            else
              return;
          }
          catch(Exception filesave){}
          BufferedWriter bw1=null;
          try
          {
            if(name.endsWith(".vsm"))
              bw1=new BufferedWriter(new FileWriter(chooser.getCurrentDirectory().getPath()+"\\"+name));
            else
            {
              bw1=new BufferedWriter(new FileWriter(chooser.getCurrentDirectory().getPath()+"\\"+name+".vsm"));
              name+=".vsm";
            }
            st=con.createStatement();
            rs=st.executeQuery("select * from Products");
            while(rs.next())
            {
              bw1.write("insert into Products values(\'"+rs.getString(1)+"\',\'"+rs.getString(2)+"\',"+rs.getFloat(3)+")");
              bw1.newLine();
            }
            rs=st.executeQuery("select * from Distributers");
            while(rs.next())
            {
              bw1.write("insert into Distributers values(\'"+rs.getString(1)+"\',\'"+rs.getString(2)+"\',\'"+rs.getString(3)+"\',"+rs.getFloat(4)+","+rs.getInt(5)+","+rs.getFloat(6)+","+rs.getInt(7)+","+rs.getInt(8)+","+rs.getInt(9)+")");
              bw1.newLine();
            }
            rs=st.executeQuery("select * from Stack");
            while(rs.next())
            {
              bw1.write("insert into Stack values(\'"+rs.getString(1)+"\',"+rs.getFloat(2)+","+rs.getInt(3)+","+rs.getInt(4)+","+rs.getInt(5)+","+rs.getInt(6)+","+rs.getInt(7)+","+rs.getInt(8)+","+rs.getInt(9)+")");
              bw1.newLine();
            }
            rs=st.executeQuery("select * from Records");
            while(rs.next())
            {
              bw1.write("insert into Records values(\'"+rs.getString(1)+"\',"+rs.getInt(2)+","+rs.getFloat(3)+","+rs.getFloat(4)+","+rs.getInt(5)+","+rs.getInt(6)+","+rs.getInt(7)+")");
              bw1.newLine();
            }
            bw1.close();
            JOptionPane.showMessageDialog(null,"Backup file ("+name+") successfully created.");
          }
          catch(Exception io)
          {
            try
            {
              bw1.close();
            }
            catch(Exception skdjhgfshgdjkfgskh){}
          }
        } 
        if(e.getActionCommand()=="Delete Product")
        {
          l8.setVisible(true);
          l8.setBounds(250,460,400,20);
          try
          {
            tempi=t2.getSelectedRow();
            System.out.println(tempi);
            obj=dtm2.getValueAt(tempi,0);
            temp1=obj.toString();
          }
          catch(Exception d1)
          {
            l8.setText("No Product is SELECTED");
          }
          try
          {
            pst=con.prepareStatement("delete from Products where PId=?");
            pst.setString(1,temp1);
            pst.executeUpdate();
            System.out.println("deleted==>>"+rs);
          }
          catch(Exception d2)
          {
            l8.setText("No Product is SELECTED");
          }
          dtm2.removeRow(tempi);
        }
        
        if(e.getActionCommand()=="Delete Distributer")
        {
          l8.setText("");
          l8.setVisible(true);
          l8.setBounds(250,460,400,20);
          try
          {
            tempi=t3.getSelectedRow();
            System.out.println(tempi);
            
          }
          catch(Exception d1)
          {
            l8.setText("No Distributer is SELECTED");
          }
          try
          {
            if(Float.parseFloat(dtm3.getValueAt(tempi,7).toString())==0.0)
            {
              pst=con.prepareStatement("delete from Distributers where DId=? and PId=? and DD=? and MM=? and YYYY=?");
              pst.setString(1,dtm3.getValueAt(tempi,0).toString());
              pst.setString(2,dtm3.getValueAt(tempi,2).toString());
              pst.setInt(3,100+Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(0,2)));
              pst.setInt(4,100+Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(3,5)));
              pst.setInt(5,Integer.parseInt(dtm3.getValueAt(tempi,8).toString().substring(6,10)));
              pst.executeUpdate();System.out.println("5");
              pst=con.prepareStatement("commit");
              pst.executeUpdate();
              System.out.println("deleted==committed>>"+rs);
              dtm3.removeRow(tempi);
            }
            else
              l8.setText("You have not payed all the BALANCE");
          }
          catch(Exception d2)
          {
            l8.setText("No Product is SELECTED");
          }
        }
      }
      
      if(e.getSource()==b4)                                                         //b4   **************************
      {
        if(e.getActionCommand()=="Upload Backup")
        {
          try
          {
            if(JOptionPane.showConfirmDialog(null,"Be sure you are using this UPLOAD BACKUP for the FIRST time after your Database is NEWLY created.\n\nAll Data lost if there is data already present in database.\n\nDo you want to upload backup?")!=0)
              return;
          }
          catch(Exception shdfksfjkhkswj){}
          try
          {
            chooser.setCurrentDirectory(new File("."));
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() 
            {
              public boolean accept(File f) 
              {
                return f.getName().toLowerCase().endsWith(".vsm")||f.isDirectory();
              }
            
              public String getDescription() {
                return "Venisoft VSM Files";
              }
            });
            
            int r=chooser.showOpenDialog(new JFrame());
            if(r==JFileChooser.APPROVE_OPTION) 
            {
              name=chooser.getSelectedFile().getName();
              System.out.println(chooser.getCurrentDirectory().getPath()+"\\"+name);
            }
            else
              return;
          }
          catch(Exception filesave){}
          System.out.println("1");
          try
          {
            BufferedReader br1=null;
            System.out.println("2");
            if(name.endsWith(".vsm"))
              br1=new BufferedReader(new FileReader(chooser.getCurrentDirectory().getPath()+"\\"+name));
            String reading="";
            System.out.println("3");
            try
            {
              while(true)
              { 
                reading=br1.readLine().toString();
                System.out.println("4");
                pst=con.prepareStatement(reading);
                System.out.println("5");
                pst.executeUpdate();
                System.out.println("6");
                pst=con.prepareStatement("commit");
                System.out.println("7");
                pst.executeUpdate();
                System.out.println("8");
              }
            }
            catch(Exception sadkjfksjdfkaskjdhfjkdhs){}
            JOptionPane.showMessageDialog(null,"Backup successfully Updated.");
          }
          catch(Exception io){JOptionPane.showMessageDialog(null,"Reading error");}
        }
        if(e.getActionCommand()=="Billing")
        {
          f1.remove(l18);
          f1.add(b2);
          f1.add(tf3);
          
          l2.setIcon(ii3);
          l2.setBounds(0,100,120,120);
          l3.setVisible(true);
          l4.setVisible(true);
          l5.setVisible(true);
          l6.setVisible(true);
          l7.setVisible(true);
          l4.setIcon(null);
          l3.setText("Enter ID:");  
          l4.setText("ID:");
          l5.setText("Product Name:");
          l6.setText("Price:");
          l7.setText("Quantity:");
          l4.setBounds(160,150,80,30); 
          l5.setBounds(140,175,100,30);
          l3.setBounds(160,105,80,30);
          l6.setBounds(380,150,100,30);
          l7.setBounds(400,175,80,30); 
          l9.setVisible(false);
          l10.setVisible(false);
          l11.setText("TOTAL :");
          l11.setBounds(547,409,100,20);
          l11.setVisible(true);
          l18.setVisible(true);
          
          b1.setVisible(false);
          b2.setVisible(true);
          b3.setVisible(false);
          b4.setVisible(false);
          b5.setVisible(false);
          b7.setVisible(true);  
          b6.setVisible(true);
          b2.setText("Print Bill");
          b2.setEnabled(true);
          b2.setBounds(160,410,100,20);
          b2.setToolTipText("Click to Print Bill");
          b6.setText("Add To BILL");
          b6.setToolTipText("Click here to add to BILL");
          b7.setBounds(380,530,100,20);
          b7.setToolTipText("Click to go BACK...");
          
          tf1.setText("");
          tf2.setText("");
          tf3.setText("");
          tf4.setText("");
          tf5.setText("");
          tf6.setText("");
          tf6.setToolTipText("Total Amount purchaged");
          tf1.setVisible(true);
          tf2.setVisible(true);
          tf3.setVisible(true);
          tf4.setVisible(true);
          tf5.setVisible(true);
          tf6.setVisible(true);
          tf1.setBounds(245,115,100,20);
          tf6.setBounds(630,410,120,20);
          tf1.setBounds(245,115,100,20);
          tf2.setBounds(245,160,150,20);
          tf3.setBounds(245,185,150,20);
          tf4.setBounds(485,160,100,20);
          tf5.setBounds(485,185,100,20);
          tf6.setEditable(false);
          tf1.setEditable(true);
          tf2.setEditable(true);
          tf3.setEditable(true);
          tf4.setEditable(true);
          tf5.setEditable(true);
          tf1.setEditable(true);
          tf1.setToolTipText("Enter Product \"ID\" to bill");
          tf2.setToolTipText("You can Modify \"ID\" here");
          tf3.setToolTipText("You can Modify \"PRODUCT NAME\" here");
          tf4.setToolTipText("You can Modify \"PRICE\" here");
          tf5.setToolTipText("Enter customer requested QUANTITY");

          f1.add(l18);
          l18.setVisible(true);

          for(tempi=t1.getRowCount()-1;tempi>=0;tempi--)
            dtm1.removeRow(tempi);
          jsp.setBounds(160,215,590,194);
          jsp.setVisible(true);
          jsp1.setVisible(false);
          t2.setVisible(false);
        }
      }
      
      if(e.getSource()==b5)                                                         //b5   **************************
      {
        if(e.getActionCommand()=="AMD Distributers")
        {
          f1.remove(l18);
          f1.add(tf3);
          f1.add(b2);
          
          for(tempi=t3.getRowCount()-1;tempi>=0;tempi--)
            dtm3.removeRow(tempi);

          l2.setIcon(ii5);
          l4.setIcon(null);
          l3.setText("ADD / MODIFY / DELETE  Distributers");
          l6.setText("Distributer Name:");
          l5.setText("Product ID:");
          l4.setText("Price:");
          l7.setText("Quantity:");
          l11.setText("Distributer ID:");
          l12.setText("Paid:");
          l17.setText("Paid:");
          l3.setVisible(true);
          l4.setVisible(true);   
          l5.setVisible(true);   
          l6.setVisible(true);   
          l7.setVisible(true);   
          l9.setVisible(true);
          l10.setVisible(true);
          l11.setVisible(true);
          l12.setVisible(true);
          l17.setVisible(true);
          l17.setBounds(145,440,30,20);    
          l5.setBounds(140,153,100,30);    
          l7.setBounds(140,178,100,30);    
          l11.setBounds(150,130,100,30);   
          l6.setBounds(410,130,100,30);     
          l4.setBounds(410,150,100,30);     
          l12.setBounds(457,175,80,30);     
          l2.setBounds(0,100,134,134);
          l3.setBounds(200,105,300,20);
          l9.setBounds(20,250,134,134);
          l10.setBounds(20,400,134,134);
          l9.setText("");
          l10.setText("");
          l9.setIcon(ii6);
          l10.setIcon(ii8);

          f1.add(tf1);
          tf1.setText("");
          tf2.setText("");
          tf3.setText("");
          tf4.setText("");
          tf5.setText("");
          tf6.setText("");
          tf7.setText("");
          tf1.setToolTipText("Enter Distributer ID");
          tf2.setToolTipText("Enter Distributer NAME");
          tf3.setToolTipText("Enter Product ID");
          tf4.setToolTipText("Enter Product QUANTITY");
          tf5.setToolTipText("Enter current PAYED AMOUNT to Distributer");
          tf6.setToolTipText("Enter AMOUNT to pay to Distributer");
          tf7.setToolTipText("Enter Product COST");
          tf1.setVisible(true);  
          tf2.setVisible(true);  
          tf3.setVisible(true);  
          tf4.setVisible(true);  
          tf5.setVisible(true);  
          tf7.setVisible(true);  
          tf6.setVisible(true);  
          tf1.setEditable(true);
          tf2.setEditable(true);
          tf3.setEditable(true);
          tf4.setEditable(true);
          tf5.setEditable(true);
          tf6.setEditable(true);
          tf1.setEditable(true);
          tf1.setBounds(245,135,150,20);
          tf2.setBounds(515,135,100,20);
          tf3.setBounds(245,160,150,20);
          tf4.setBounds(245,185,150,20);
          tf7.setBounds(515,160,100,20);
          tf5.setBounds(515,185,100,20);
          tf6.setBounds(178,443,150,20);
          
                
          
          b5.setText("Add Distributer");
          b5.setToolTipText("Click here to add to Database");
          b7.setToolTipText("Click to go BACK...");
          b3.setText("Delete Distributer");
          b5.setVisible(true);
          b7.setVisible(true);
          b1.setVisible(false);
          b2.setVisible(true);
          b3.setVisible(true);
          b4.setVisible(false);
          b2.setText("Modify Payment");
          b2.setToolTipText("Click here to MODIFY the Payment of selected Distributer");
          b2.setBounds(160,470,150,20);
          b3.setBounds(600,470,150,20);
          b5.setBounds(640,185,150,20);
          b7.setBounds(380,530,100,20);
          
          b10.setText("Print");
          b10.setHorizontalTextPosition(JLabel.CENTER);
          b10.setForeground(Color.yellow);
          b10.setVisible(true);
          b10.setIcon(ii17);
          b10.setRolloverIcon(ii18);
          b10.setBounds(400,430,140,20);
          
          jsp2.setBounds(140,220,650,194);
          jsp.setVisible(false);
          jsp1.setVisible(false);
          jsp2.setVisible(true);
          t1.setVisible(false);
          t2.setVisible(false);
          t3.setVisible(true);
          
          f1.add(l18);
          l18.setVisible(true);
          
          try
          {
            rs=st.executeQuery("select * from Distributers");
            while(rs.next())
            {
              body[0]=rs.getString(1);
              body[1]=rs.getString(2);
              body[2]=rs.getString(3);
              body[3]=Float.toString(amount=rs.getFloat(4));
              body[4]=Integer.toString(tempi=rs.getInt(5));
              body[5]=Float.toString(amount*=(float)tempi);
              body[6]=Float.toString(tempf=rs.getFloat(6));
              body[7]=Float.toString((amount-tempf));
              body[8]=Integer.toString(rs.getInt(9)).substring(1,3)+":"+Integer.toString(rs.getInt(7)).substring(1,3)+":"+rs.getInt(8);
              dtm3.addRow(body);
            }
          }
          catch(Exception amd){} 
        }
        
        if(e.getActionCommand()=="Continue"||e.getActionCommand()=="Retry")
        {
          l5.setText("User Name:");
          l6.setText("Password :");
          l5.setBounds(300,270,100,20);
          l6.setBounds(300,300,100,20);
          l5.setVisible(true);
          l6.setVisible(true);
          
          l1.setIcon(ii1);
          l2.setIcon(new ImageIcon("images/login_icon.gif"));
          l2.setText("");
          l18.setIcon(ii20);
          
          l1.setBounds(0,0,800,100);
          l2.setBounds(100,250,155,155);
          l18.setBounds(0,0,800,600);
          l1.setVisible(true);
          l2.setVisible(true);
          l18.setVisible(true);
          
          
          tf1.setText("");
          pf1.setText("");
          tf1.setToolTipText("Enter your USER NAME");
          pf1.setToolTipText("Enter your PASSWORD");
          tf1.setBounds(410,273,150,20);
          pf1.setBounds(410,302,150,20);
          tf1.setVisible(true);
          pf1.setVisible(true);
          
          b5.setText("Login");
          b5.setToolTipText("Click here to Login");
          b5.setBounds(335,340,225,30);
          b5.setVisible(true);
        }
        
        if(e.getActionCommand()=="Login")
        {
          l5.setVisible(false);
          l6.setVisible(false);
          tf1.setVisible(false);
          pf1.setVisible(false);
          if(tf1.getText().equals("")||pf1.getText().equals(""))
          {
            l2.setIcon(new ImageIcon("images/fail.png"));
            l2.setBounds(100,150,550,260);
            l2.setText("Login Failed : Some text fields are BLANK.");
            l2.setHorizontalAlignment(JLabel.RIGHT);
            l2.setVerticalAlignment(JLabel.CENTER);
            
            b5.setText("Retry");
            b5.setToolTipText("Click here to RETRY Login ...");
            b5.setBounds(500,340,150,20);
          }
          else
          {
            try
            {
              pst=con.prepareStatement("select * from VenisoftSuperMarketLogin");
              rs=pst.executeQuery();
              tempi=0;
              while(rs.next())
              {
                if(rs.getString(2).equals(tf1.getText())&&rs.getString(3).equals(pf1.getText()))
                {
                  enable=rs.getInt(4);
                  l2.setIcon(new ImageIcon("images/success.jpg"));
                  l2.setBounds(100,150,650,390);
                  l2.setText("                     Login Success       ");
                  l2.setHorizontalAlignment(JLabel.RIGHT);
                  l2.setVerticalAlignment(JLabel.CENTER);
                  
                  b5.setText("Work Space");
                  b5.setToolTipText("Click here to go to WORK SPACE");
                  b5.setBounds(590,400,200,30);
                  tempi=1;
                  return;
                }
                else
                {
                  tempi=0;
                }
              }
              if(tempi==0)
              {
              	l2.setIcon(new ImageIcon("images/fail.png"));
              	l2.setBounds(100,150,550,260);
              	l2.setText("Login Failed : User Name or Password not matched ...");
              	l2.setHorizontalAlignment(JLabel.RIGHT);
              	l2.setVerticalAlignment(JLabel.CENTER);
              	
              	b5.setText("Retry");
              	b5.setToolTipText("Click here to RETRY Login ...");
              	b5.setBounds(500,340,150,20);	
              }
            }
            catch(Exception checking){}
          }
        }
        
        if(e.getActionCommand()=="Work Space")
        {
          if(enable==0)
          {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b5.setEnabled(false);
          }
          
          l1.setIcon(ii1);
          l1.setBounds(0,0,800,100);
          l2.setBounds(0,100,200,500);
          l2.setText("");
          l2.setIcon(ii2);
          l2.setVisible(true);
          l18.setVisible(false);
          l4.setVisible(true);
          l4.setIcon(ii19);
          l4.setText("");
          l4.setBounds(150,101,645,494);
          
          b1.setVisible(true);
          b2.setVisible(true);
          
          b4.setVisible(true);
          b5.setVisible(true);
          b7.setVisible(false);
          b1.setText("AMD Products");
          b2.setText("Reports");
          b3.setText("Settings");
          b3.setToolTipText("Click here to BACKUP your Data (*.SM file creates)");
          b3.setBounds(250,270,150,20);
          b3.setVisible(true);
          b4.setText("Billing");
          b5.setText("AMD Distributers");
          b5.setBounds(250,180,150,20);
          b4.setBounds(250,210,150,20);
          b2.setBounds(250,240,150,20);
          
          b5.setToolTipText("Click here to ADD,MODIFY,DELETE Distributers");
          b1.setToolTipText("Click to ADD,MODIFY,DELETE Products");
          b2.setToolTipText("Click to get Daily / Monthly Reports");
          b4.setToolTipText("Customer BILLING");
        }
        
        if(e.getActionCommand()=="Add Distributer")
        {
          l8.setBounds(250,460,400,20);
          l8.setVisible(true);
          if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf7.getText().equals(""))
          {
            l8.setText("Some Text Fields are BLANK");
          }
          else
          {
            temp1=tf3.getText();
            System.out.println(temp1);
            try  
            {
              if(Float.parseFloat(tf7.getText())*Integer.parseInt(tf4.getText())<Float.parseFloat(tf5.getText()))
              {
                JOptionPane.showMessageDialog(null,"You QUOTED Payment is Higher than required ...");
                return;
              }  
              pst=con.prepareStatement("insert into Distributers values(?,?,?,?,?,?,?,?,?)");   
              pst.setString(1,tf1.getText());  
              pst.setString(2,tf2.getText());  
              pst.setString(3,tf3.getText());  
              pst.setFloat(4,Float.parseFloat(tf7.getText()));  //price
              pst.setInt(5,Integer.parseInt(tf4.getText()));    //q
              pst.setFloat(6,Float.parseFloat(tf5.getText()));  //paid
              pst.setInt(7,100+cal.get(Calendar.MONTH)+1);  
              pst.setInt(8,cal.get(Calendar.YEAR));
              pst.setInt(9,100+cal.get(Calendar.DATE));  
              pst.executeUpdate();  
              st.executeUpdate("commit");  
                  pst=con.prepareStatement("insert into Stack values(?,?,?,?,?,?,?,?,?)");  
                  pst.setString(1,tf3.getText());  
                  pst.setFloat(2,Float.parseFloat(tf7.getText()));  
                  pst.setInt(3,Integer.parseInt(tf4.getText()));  
                  pst.setInt(4,cal.get(Calendar.MONTH)+1);  
                  pst.setInt(5,cal.get(Calendar.YEAR));
                  pst.setInt(6,cal.get(Calendar.DATE));
                  pst.setInt(7,cal.get(Calendar.HOUR));
                  pst.setInt(8,cal.get(Calendar.MINUTE));
                  pst.setInt(9,cal.get(Calendar.SECOND));
                  cal.clear();
                  cal=new GregorianCalendar();
                  pst.executeUpdate();  
                  st.executeUpdate("commit");
              body[0]=tf1.getText();  
              body[1]=tf2.getText();  
              body[2]=tf3.getText();  
              body[3]=tf7.getText();  
              body[4]=tf4.getText();  
              body[5]=Float.toString((Float.parseFloat(tf7.getText()))*(Integer.parseInt(tf4.getText())));  
              body[6]=tf5.getText();  
              body[7]=Float.toString(Float.parseFloat(body[5])-Float.parseFloat(body[6]));
              body[8]=Integer.toString(100+cal.get(Calendar.DATE)).substring(1,3)+"."+Integer.toString(100+cal.get(Calendar.MONTH)+1).substring(1,3)+"."+Integer.toString(cal.get(Calendar.YEAR));  
              dtm3.addRow(body);  
              l8.setText("SUCCESSFULLY Added To Database");  
            }  
            catch(Exception ex)  
            {  
              System.out.println(ex);  
              l8.setText("Database Error");  
              System.out.println("catch==>>");  
            }  
          }
        }
        if(e.getActionCommand()=="Add Product")
        {
          l8.setBounds(250,460,400,20);
          l8.setVisible(true);
          if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals(""))
          {
            l8.setText("Some Text Fields are BLANK");
          }
          else
          {
            temp1=tf2.getText();
            System.out.println(temp1);
            try
            {
              pst=con.prepareStatement("select * from Products where PId=?");
              pst.setString(1,temp1);
              rs=pst.executeQuery();
              System.out.println("executed==>>"+rs);
              rs.next();
              if(!(rs.getString(1).equals(temp1)))
              {
                throw new IllegalAccessException("Useful Error");
              }
              else
                l8.setText("Product already ADDED");
            }
            catch(Exception exx)  
            {
              Object ob[]=new Object[4];
              try
              {
                System.out.println("try2==>>");
                pst=con.prepareStatement("insert into Products values(?,?,?)");
                pst.setString(1,tf2.getText());
                pst.setString(2,tf3.getText());
                pst.setFloat(3,Float.parseFloat(tf4.getText()));
                pst.executeUpdate();
                System.out.println("executed==>>");
                st.executeUpdate("commit");
                System.out.println("Committed==>>");
                ob[0]=tf2.getText();
                ob[1]=tf3.getText();
                ob[2]=tf4.getText();
                ob[3]=Integer.toString(0);
                dtm2.addRow(ob);
                l8.setText("SUCCESSFULLY Added To Database");
                System.out.println("==>>");
              }
              catch(Exception ex)
              {
                l8.setText("Database Error");
                System.out.println("catch==>>");
              }
              try
              {
                rs=st.executeQuery("select * from Stack");
                tempi=0;
                while(rs.next())
                {
                  if(rs.getString(1).equals(tf2.getText()))
                  {
                    dtm2.setValueAt(rs.getInt(3),dtm2.getRowCount(),3);
                    tempi=1;
                  }
                }
                if(tempi==0)
                {
                  dtm2.setValueAt(0,dtm2.getRowCount(),3);
                }
              }
              catch(Exception sldtkhskljdhgfhje){}
            }
          }
          tf2.setText("");
          tf3.setText("");
          tf4.setText("");
          tf5.setText("");
        }  
      }
      if(e.getSource()==b6)                                                         //b6   **************************
      {
        tempi=Integer.parseInt(tf5.getText());
        amount=Float.parseFloat(tf4.getText());
        amount*=(float)tempi;
        sum+=amount;
        
        body[0]=tf2.getText();
        body[1]=tf3.getText();  
        body[2]=tf4.getText(); 
        body[3]=Integer.toString(tempi);
        body[4]=Float.toString(amount);
        t1.setVisible(true);
        jsp.setVisible(true);
        dtm1.addRow(body);
        
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText(Float.toString(sum));
      }
      
      if(e.getSource()==b7)                                                         //b7   **************************
      {
        if(e.getActionCommand()=="Back")
        {
          chkb1.setVisible(false);
          tf9.setVisible(false);
          
          f1.add(b1);
          f1.add(b2);
          f1.add(l3);f1.add(l4);f1.add(l5);f1.add(l6);f1.add(l7);f1.add(l8);f1.add(l9);f1.add(l10);f1.add(l11);
          f1.add(tf1);
          f1.add(tf2);
          //f1.add(tf3);
          //f1.add(tf4);
          f1.add(tf5);f1.add(tf6);
          if(enable==0)
          {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b5.setEnabled(false);
          }
          
          p1.removeAll();
          p1.setVisible(false);
          p2.removeAll();
          p2.setVisible(false);
          
          l1.setIcon(ii1);
          l1.setBounds(0,0,800,100);
          l2.setIcon(ii2);
          l2.setBounds(0,100,200,500);
          l2.setVisible(true);
          l8.setVisible(false);
          l9.setVisible(false);
          l10.setVisible(false);
          l11.setVisible(false);
          l4.setVisible(true);
          l4.setIcon(ii19);
          l4.setText("");
          l4.setBounds(150,101,645,494);
          
          tf1.setVisible(false);
          tf2.setVisible(false);
          tf3.setVisible(false);
          tf4.setVisible(false);
          tf5.setVisible(false);
          tf6.setVisible(false);
          tf7.setVisible(false);
          
          pf1.setVisible(false);
          pf2.setVisible(false);
          
          l3.setVisible(false);
          l5.setVisible(false);
          l6.setVisible(false);
          l7.setVisible(false);
          l10.setVisible(false);
          l11.setVisible(false);
          l12.setVisible(false);
          l17.setVisible(false);
          l18.setVisible(false);
          
          //b2.setVisible(false);
          cb1.setVisible(false);
          cb2.setVisible(false);
          cb3.setVisible(false);
          cb4.setVisible(false);
          
          
          b1.setVisible(true);
          b2.setVisible(true);
          b11.setVisible(false);
          b10.setVisible(false);
          b3.setText("Backup");
          b3.setBounds(250,270,150,20);
          b3.setToolTipText("Click here to BACKUP your Data (*.SM file creates)");
          b3.setVisible(true);
          b4.setVisible(true);
          b5.setVisible(false);
          b7.setVisible(false);
          b2.setBounds(250,240,150,20);
          b1.setText("AMD Products");
          b2.setText("Reports");
          b3.setText("Settings");
          b4.setText("Billing");
          b5.setText("AMD Distributers");
          b5.setVisible(true);
          b4.setBounds(250,210,150,20);
          b5.setBounds(250,180,150,20);
          b1.setBounds(250,150,150,20);
          b5.setToolTipText("Click here to ADD,MODIFY,DELETE Distributers");
          b1.setToolTipText("Click to ADD,MODIFY,DELETE Products");
          b2.setToolTipText("Click to get Daily / Monthly Reports");
          b4.setToolTipText("Customer BILLING");
          b6.setVisible(false);
          jsp.setVisible(false);
          jsp1.setVisible(false);
          jsp2.setVisible(false);
          jsp3.setVisible(false);
          jsp4.setVisible(false);
          jsp5.setVisible(false);
          
          t2.setVisible(false);
          t3.setVisible(false);
          sum=0;
        }
      }
      if(e.getSource()==b8)                                                         //b8   Close **************************
      {
        System.exit(0);
      }
      if(e.getSource()==b9)                                                         //b9   Minimize *********************** 
      {
        f1.setExtendedState(Frame.ICONIFIED);
      }
      if(e.getSource()==b10)                                                         //b10    
      {
        try
        {
          t3.print();
        }
        catch(Exception rftufrtdf){}
      }
      if(e.getSource()==b11)                                                         //b11    
      {
        try
        {
          t2.print();
        }
        catch(Exception rftufrtdf){}
      }      
      if(e.getSource()==tf1)                                                        //tf1   **************************
      {
        temp1=tf1.getText();
        System.out.println(temp1);
        try
        {
          pst=con.prepareStatement("select * from Products where PId=?");
          pst.setString(1,temp1);
          rs=pst.executeQuery();
          System.out.println("executed==>>"+rs);
          rs.next();
          body[0]=rs.getString(1);
          body[1]=rs.getString(2);
          body[2]=rs.getString(3); 
          tf2.setText(body[0]);
          tf3.setText(body[1]);
          tf4.setText(body[2]);
          tf5.setText("1");
          System.out.println("==>>"+body[0]);
        }
        catch(Exception ee){System.out.println("error==>>");}
      }
    }  
  }
  
  public class MouseHandler implements MouseListener,MouseMotionListener
  {
    Point location;
    MouseEvent pressed;
    public void mousePressed(MouseEvent me)
    {
      pressed = me;
    }
    public void mouseDragged(MouseEvent me)
    {
      location = f1.getLocation(location);
      int x = location.x - pressed.getX() + me.getX();
      int y = location.y - pressed.getY() + me.getY();
      if(pressed.getY()<=100)
        f1.setLocation(x, y);
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
  }
  
  public class ItemHandler implements ItemListener
  {
    public void itemStateChanged(ItemEvent e)
    {
      if(e.getSource()==chkb1)
      {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
          tf9.setText("");
          tf9.setToolTipText("Enter a Product ID");
          tf9.setVisible(true);
          tf9.setEnabled(true);
          tf9.setBounds(130,230,100,20);
        }
        else
        {
          tf9.setText("");
          tf9.setToolTipText("Enter a Product ID");
          tf9.setVisible(true);
          tf9.setEnabled(false);
          tf9.setBounds(130,230,100,20);
        }
      }
      if(e.getSource()==cb1)
      {
        for(tempi=t4.getRowCount()-1;tempi>=0;tempi--)
          dtm4.removeRow(tempi);
        m=cb1.getSelectedIndex()+1;
        calendarLeft(1,m,y);
      }
      else if(e.getSource()==cb2)
      {
        for(tempi=t4.getRowCount()-1;tempi>=0;tempi--)
          dtm4.removeRow(tempi);
        y=cb2.getSelectedIndex()+1;
        y+=2000;
        calendarLeft(1,m,y);
      }
      
      if(e.getSource()==cb3)
      {
        for(tempi=t5.getRowCount()-1;tempi>=0;tempi--)
          dtm5.removeRow(tempi);
        m1=cb3.getSelectedIndex()+1;
        calendarRight(1,m1,y1);
      }
      else if(e.getSource()==cb4)
      {
        for(tempi=t5.getRowCount()-1;tempi>=0;tempi--)
          dtm5.removeRow(tempi);
        y1=cb4.getSelectedIndex()+1;
        y1+=2000;
        calendarRight(1,m1,y1);
      }
    }
  }
  
  public void calendarLeft(int DD,int MM,int YYYY)
  {
    m=MM;
    y=YYYY;
    if(m==1||m==3||m==5||m==7||m==8||m==10||m==12) tempx=31;
    else if(m==2) 
    {
      if(y%400==0)tempx=29;
      else if(y%100==0)tempx=28;
      else if(y%4==0)tempx=29;
      else tempx=28;
    }
    else tempx=30;
    tempi=m;tempj=y;
    tempk=Calendar.MONTH;
    templ=Calendar.YEAR;
    cal.set(Calendar.MONTH,tempi-1);
    cal.set(Calendar.YEAR,tempj);
    tempj=cal.get(Calendar.DATE);
    tempi=cal.get(Calendar.DAY_OF_WEEK);
    cal.set(Calendar.MONTH,tempk);
    cal.set(Calendar.YEAR,templ);
    for(;tempj>1;tempj--)
    {
      tempi--;
      if(tempi<=0)tempi=7;
    }
    for(tempj=0;tempi>1;tempi--,tempj++) body[tempj]=" ";
    tempi=1;tempk=1;
    do
    {
      for(;tempj<7;tempj++,tempi++)
      {
        if(tempi<=tempx) body[tempj]=Integer.toString(tempi);
        else body[tempj]=" ";
      }
      dtm4.addRow(body);
      tempj=0;tempk++;
    }while(tempk<7);
  }
  
  public void calendarRight(int DD,int MM,int YYYY)
  {
    m1=MM;
    y1=YYYY;
    if(m1==1||m1==3||m1==5||m1==7||m1==8||m1==10||m1==12) tempx=31;
    else if(m1==2) 
    {
      if(y1%400==0)tempx=29;
      else if(y1%100==0)tempx=28;
      else if(y1%4==0)tempx=29;
      else tempx=28;
    }
    else tempx=30;
    tempi=m1;tempj=y1;
    tempk=Calendar.MONTH;
    templ=Calendar.YEAR;
    cal.set(Calendar.MONTH,tempi-1);
    cal.set(Calendar.YEAR,tempj);
    tempj=cal.get(Calendar.DATE);
    tempi=cal.get(Calendar.DAY_OF_WEEK);
    cal.set(Calendar.MONTH,tempk);
    cal.set(Calendar.YEAR,templ);
    for(;tempj>1;tempj--)
    {
      tempi--;
      if(tempi<=0)tempi=7;
    }
    for(tempj=0;tempi>1;tempi--,tempj++) body[tempj]=" ";
    tempi=1;tempk=1;
    do
    {
      for(;tempj<7;tempj++,tempi++)
      {
        if(tempi<=tempx) body[tempj]=Integer.toString(tempi);
        else body[tempj]=" ";
      }
      dtm5.addRow(body);
      tempj=0;tempk++;
    }while(tempk<7);
  }
}