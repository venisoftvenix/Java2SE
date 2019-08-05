import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.event.*;
public class HomePlanDesigner implements ActionListener,Printable
{
  JFrame f1;
  JLabel title,move,exp,addroom,modroom,iname,ename,le,bo,ri;
  ImageIcon ititle;
  JTextField tfName=new JTextField(""),tfMod=new JTextField("");
  JPanel left,right;
  Room r[];
  Interior in[];
  Exterior ex[];
  JButton addh,exit,modh,del,mini,sep,print,arrange;
  JRadioButton sofa,tv,table,bed,sp,ground,garden,lawn,parking;
  ButtonGroup interior,exterior;
  JSlider HMove,VMove,WiExp,HiExp;
  String Sn="";
  int x,y,w,d,array[][],i,j,ax[]=new int[50],ay[]=new int[50],count=0,icount=0,ecount=0,select,selecti,sval,total=0; 
  public HomePlanDesigner()
  {
    ititle=new ImageIcon("images/Title.PNG");                  //Title n lables
    title=new JLabel();
    title.setIcon(ititle);
    title.setBounds(0,0,1024,54);
    title.setVisible(true);
    
    addroom=new JLabel("Room    Name:");
    addroom.setBounds(5,5,85,20);
    addroom.setVisible(true);
    
    modroom=new JLabel("Change Name:");
    modroom.setBounds(5,30,85,20);
    modroom.setVisible(true);
    
    iname=new JLabel("Interior Designs:");
    iname.setBounds(5,100,150,20);
    iname.setVisible(true);
    
    ename=new JLabel("Exterior Designs:");
    ename.setBounds(5,190,150,20);
    ename.setVisible(true);
    
    le=new JLabel();
    le.setIcon(new ImageIcon("images/left.png"));
    le.setBounds(0,54,8,800);
    le.setVisible(true);
    
    ri=new JLabel();
    ri.setIcon(new ImageIcon("images/right.png"));
    ri.setBounds(1017,54,8,800);
    ri.setVisible(true);
    
    bo=new JLabel();
    bo.setIcon(new ImageIcon("images/bottom.png"));
    bo.setBounds(0,758,1030,10);
    bo.setVisible(true);
    
    move=new JLabel("Position");
    move.setBounds(30,320,100,100);
    exp=new JLabel("Size");
    exp.setBounds(180,320,100,100);
    
    tfName.setSize(100,20);
    tfName.setBounds(95,5,100,20);
    tfMod.setSize(100,20);
    tfMod.setBounds(95,30,100,20);
    
    addh=new JButton("Add");                          //Buttons
    addh.setBounds(200,5,90,20);
    modh=new JButton("Modify");
    modh.setBounds(200,30,90,20);
    del=new JButton("Delete");
    del.setBounds(5,55,285,20);
    exit=new JButton();
    exit.setIcon(new ImageIcon("images/X1.png"));
    exit.setRolloverIcon(new ImageIcon("images/X2.png"));
    exit.setBorder(null);
    exit.setBounds(975,5,40,16);
    mini=new JButton();
    mini.setIcon(new ImageIcon("images/M1.png"));
    mini.setRolloverIcon(new ImageIcon("images/M2.png"));
    mini.setBorder(null);
    mini.setBounds(935,5,36,16);
    sep=new JButton();                          //Buttons
    sep.setBounds(710,54,14,705);
    sep.setBorder(null);
    sep.setBackground(Color.GRAY);
    sep.setVisible(true);
    arrange=new JButton("Re Arrange");
    arrange.setBounds(5,450,285,20);
    arrange.setToolTipText("Re Arrange Room {Room always on Back}");
    print=new JButton("Print");
    print.setBounds(5,500,285,20);
    
    HMove=new JSlider(0,0,100,0);                      //Sliders
    HMove.setBounds(5,310,100,20);
    VMove=new JSlider(1,0,100,0);
    VMove.setValue(100);
    VMove.setBounds(106,310,20,100);
    
    WiExp=new JSlider(0,0,100,0);
    WiExp.setBounds(150,310,100,20);
    HiExp=new JSlider(1,0,100,0);
    HiExp.setValue(100);
    HiExp.setBounds(251,310,20,100);
    
    sofa=new JRadioButton("Sofa");                    //Radio buttons
    tv=new JRadioButton("Tv");
    table=new JRadioButton("Table");
    bed=new JRadioButton("Bed");
    sp=new JRadioButton("Swimming Pool");
    ground=new JRadioButton("Play Ground");
    garden=new JRadioButton("Garden");
    lawn=new JRadioButton("Lawn");
    parking=new JRadioButton("Parking");
    
    interior=new ButtonGroup();
    interior.add(sofa);
    interior.add(tv);
    interior.add(table);
    interior.add(bed);
    exterior=new ButtonGroup();
    exterior.add(sp);
    exterior.add(ground);
    exterior.add(garden);
    exterior.add(lawn);
    exterior.add(parking);
    
    sofa.setBounds(5,120,140,20);
    tv.setBounds(150,120,140,20);
    table.setBounds(5,140,140,20);
    bed.setBounds(150,140,140,20);
    
    sp.setBounds(5,210,140,20);
    ground.setBounds(150,210,140,20);
    garden.setBounds(5,230,140,20);
    lawn.setBounds(150,230,140,20);
    parking.setBounds(5,250,140,20);

    x=1;y=1;w=100;d=100;

    array=new int[700][700];
    for(i=0;i<700;i++)
      for(j=0;j<700;j++)
        array[i][j]=0;
    f1=new JFrame("Home Plan Designer");
    left=new JPanel();
    left.setSize(700,700);
    left.setBounds(5,55,705,705);
    right=new JPanel();
    right.setSize(250,750);
    right.setBounds(724,55,295,705);

    in=new Interior[50];
    for(i=0;i<50;i++)  
      in[i]=new Interior();
    
    ex=new Exterior[50];
    for(i=0;i<50;i++)  
      ex[i]=new Exterior();
    
    r=new Room[50];
    for(i=0;i<50;i++)
      r[i]=new Room();
      
    f1.add(sep);
    f1.add(le);
    f1.add(ri);
    f1.add(bo);
    f1.add(mini);
    f1.add(exit);  
    f1.add(title);
    f1.add(left);
    f1.add(right);

    f1.setSize(1024,768);
    f1.addWindowListener
    (
      new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)  
        {
          System.exit(0);
        }
      }
    );
    f1.getContentPane().setLayout(null);
    left.setLayout(null);
    right.setLayout(null);

    MouseHandler mh=new MouseHandler();
    ItemHandler ih=new ItemHandler();
    
    addh.addActionListener(this);
    modh.addActionListener(this);
    del.addActionListener(this);
    print.addActionListener(this);
    exit.addActionListener(this);
    mini.addActionListener(this);
    arrange.addActionListener(this);
    
    sofa.addItemListener(ih);
    tv.addItemListener(ih);
    table.addItemListener(ih);
    bed.addItemListener(ih);
    sp.addItemListener(ih);
    ground.addItemListener(ih);
    garden.addItemListener(ih);
    lawn.addItemListener(ih);
    parking.addItemListener(ih);

    for(i=0;i<50;i++)
    {
      r[i].b1.addActionListener(this);
      in[i].b1.addActionListener(this);
      ex[i].b1.addActionListener(this);
    }
    
    f1.addMouseListener(mh);
    f1.addMouseMotionListener(mh);
    HMove.addChangeListener(new MyChangeAction());
    VMove.addChangeListener(new MyChangeAction());
    WiExp.addChangeListener(new MyChangeAction());
    HiExp.addChangeListener(new MyChangeAction());
    
    left.setBackground(Color.LIGHT_GRAY);
    right.add(tfName);
    right.add(tfMod);
    right.add(addroom);
    right.add(modroom);
    right.add(iname);
    right.add(ename);
    right.add(arrange);
    right.add(print);
    right.add(addh);
    right.add(modh);
    right.add(del);
    right.add(sofa);
    right.add(tv);
    right.add(table);
    right.add(bed);
    right.add(sp);
    right.add(ground);
    right.add(garden);
    right.add(lawn);
    right.add(parking);
    right.add(HMove);
    right.add(VMove);
    right.add(move);
    right.add(exp);
    right.add(WiExp);
    right.add(HiExp);
    right.setBackground(Color.LIGHT_GRAY);

    f1.setResizable(false);
    f1.setLocationRelativeTo(null);
    f1.setUndecorated(true);
    f1.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    f1.show();
  }
  public int print(Graphics g, PageFormat pf, int index) throws PrinterException 
  {
    Graphics2D g2 = (Graphics2D)g;
    if (index >= 1)
    {
      return Printable.NO_SUCH_PAGE;
    }
    else 
    {
      left.printAll(g2);
      return Printable.PAGE_EXISTS;
    }
  }
  
  public static void main(String args[])
  {
    HomePlanDesigner hpd1=new HomePlanDesigner();
  }
  public void actionPerformed(ActionEvent e)
  {
    int f=0;
    if(e.getSource()==arrange)                                                          
    {
      r[select].room.setBounds((int)r[select].room.getBounds().getX()+1,(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
      r[select].room.setBounds((int)r[select].room.getBounds().getX()-1,(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
      f1.show();
    }
    if(e.getSource()==mini)                                                         //Minimize *********************** 
    {
      f1.setExtendedState(Frame.ICONIFIED);
    }
    if(e.getSource()==print)
    {
      PrinterJob printJob = PrinterJob.getPrinterJob();
      printJob.setPrintable(this);
      if(printJob.printDialog())
      {
        try
        {
          printJob.print();
        }
        catch(Exception ex)
        {
          throw new RuntimeException(ex);
        }
      }
    }
    if(e.getSource()==del)                   
    {
      if(select>=0&&select<100)
      {
        r[select].room.setVisible(false);
      }
      else if(select>=200&&select<300)
      {
        in[select-200].inte.setVisible(false);
      }
      else if(select>=400&&select<500)
      {
        ex[select-400].exte.setVisible(false);
      }
    }
    if(e.getSource()==modh)                   
    {
      if(select>=0&&select<100)
      {
        r[select].b1.setText(tfMod.getText());
      }
    }
    if(e.getSource()==addh)                   
    {
      System.out.println("1");
      Sn=tfName.getText();
      if(tfName.getText().equals(""))
      {
        JOptionPane.showMessageDialog(null,"Enter Name of the Room...");
        return;
      }

      r[count]=new Room(x,y,w,d,Sn,r[count].b1);
      tfName.setText("");
      /*
      for(i=x-1;i<x+w;i++)
        for(j=y-1;j<y+d;j++)
          array[i][j]=1;
      ax[count]=x;
      ay[count]=y;
      */
      System.out.println("Count:"+count);
      count++;

      f1.show();
      System.out.println("2");
      f=0;
      total++;
    }
    else if(e.getSource()==exit)                   
    {
      System.exit(1);
    }
    
    for(i=0;i<total;i++)
    {
      if(e.getSource()==r[i].b1)
      {
        select=i;f=1;
        tfMod.setText(r[select].b1.getText());
        break;
      }
    }
    for(i=0;i<icount;i++)
    {
      if(e.getSource()==in[i].b1)
      {
        select=i+200;f=1;
        break;
      }
    }
    for(i=0;i<ecount;i++)
    {
      if(e.getSource()==ex[i].b1)
      {
        select=i+400;f=1;
        break;
      }
    }    
    if(f==1)
    {
      if(select>=0&&select<100)
      {
        HMove.setValue((int)((int)r[select].room.getBounds().getX()/7));
        VMove.setValue(100-(int)((int)r[select].room.getBounds().getY()/7));
        WiExp.setValue((int)((int)r[select].room.getBounds().getWidth()/7));
        HiExp.setValue(100-(int)((int)r[select].room.getBounds().getHeight()/7));
      }
      else if(select>=200&&select<300)
      {
        HMove.setValue((int)((int)in[select-200].inte.getBounds().getX()/7));
        VMove.setValue(100-(int)((int)in[select-200].inte.getBounds().getY()/7));
        WiExp.setValue((int)((int)in[select-200].inte.getBounds().getWidth()/7));
        HiExp.setValue(100-(int)((int)in[select-200].inte.getBounds().getHeight()/7));
      }
      else if(select>=400&&select<500)
      {
        HMove.setValue((int)((int)ex[select-400].exte.getBounds().getX()/7));
        VMove.setValue(100-(int)((int)ex[select-400].exte.getBounds().getY()/7));
        WiExp.setValue((int)((int)ex[select-400].exte.getBounds().getWidth()/7));
        HiExp.setValue(100-(int)((int)ex[select-400].exte.getBounds().getHeight()/7));
      }
      System.out.println("Room:"+r[select].b1.getText());
    }   
  }
  public class ItemHandler implements ItemListener
  {
    public void itemStateChanged(ItemEvent e)
    {
      if(e.getSource()==sofa)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: SOFA\nAre you sure?")==0)
          {
            in[icount].inter(50,50,in[icount].b1,1);
            icount++;
            f1.show();
            return;
          }
      if(e.getSource()==tv)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: TV\nAre you sure?")==0)
          {
            in[icount].inter(50,50,in[icount].b1,2);
            icount++;
            f1.show();
            return;
          }
      if(e.getSource()==bed)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: BED\nAre you sure?")==0)
          {
            in[icount].inter(50,50,in[icount].b1,3);
            icount++;
            f1.show();
            return;
          }
      if(e.getSource()==table)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: TABLE\nAre you sure?")==0)
          {
            in[icount].inter(50,50,in[icount].b1,4);
            icount++;
            f1.show();
            return;
          }
      /////////////////////
      if(e.getSource()==sp)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: Swimming Pool\nAre you sure?")==0)
          {
            ex[ecount].exter(50,50,ex[ecount].b1,1);
            ecount++;
            f1.show();
            return;
          }
      if(e.getSource()==ground)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: Play Ground\nAre you sure?")==0)
          {
            ex[ecount].exter(50,50,ex[ecount].b1,2);
            ecount++;
            f1.show();
            return;
          }
      if(e.getSource()==garden)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: Garden\nAre you sure?")==0)
          {
            ex[ecount].exter(50,50,ex[ecount].b1,3);
            ecount++;
            f1.show();
            return;
          }
      if(e.getSource()==lawn)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: Lawn\nAre you sure?")==0)
          {
            ex[ecount].exter(50,50,ex[ecount].b1,4);
            ecount++;
            f1.show();
            return;
          }
      if(e.getSource()==parking)
        if(e.getStateChange()==ItemEvent.SELECTED)
          if(JOptionPane.showConfirmDialog(null,"Selected: Parking\nAre you sure?")==0)
          {
            ex[ecount].exter(50,50,ex[ecount].b1,5);
            ecount++;
            f1.show();
            return;
          }
    }
  }
  public class MyChangeAction implements ChangeListener
  {
    int temp=0,diff=0,sl,o=0,m;
    public void stateChanged(ChangeEvent ce)
    {
      if(ce.getSource()==HMove)
      {
        if(select>=0&&select<100)
          temp=(int)((r[select].room.getBounds().getX())/7);
        else if(select>=200&&select<300)
          temp=(int)((in[select-200].inte.getBounds().getX())/7);
        else if(select>=400&&select<500)
          temp=(int)((ex[select-400].exte.getBounds().getX())/7);
        sval=HMove.getValue();
        diff=temp-sval;
        if(diff>0)o=1;
        else {diff*=-1;o=0;}
        
        System.out.println(sval+":"+diff);
        
        if(select>=0&&select<100)
        {
          if((int)r[select].room.getBounds().getX()+(int)r[select].room.getBounds().getWidth()>=700&&o==0)
          {
            sl=HMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            HMove.setValue((int)r[select].room.getBounds().getX()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX()+(diff*7),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
  
            i=(int)r[select].room.getBounds().getX()-1;
            m=1;
            while(m<=7)
            {
              for(j=(int)r[select].room.getBounds().getY();j<=(int)r[select].room.getBounds().getHeight()+(int)r[select].room.getBounds().getY();j++)
              {
                //array[i-1][j-1]=0;
                //array[i-1][j-1]=1;
              }
              m++;
              i++;
            }
          }
          else
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX()-(diff*7),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
          }
          f1.show();
        }
        else if(select>=200&&select<300)
        {
          if((int)in[select-200].inte.getBounds().getX()+(int)in[select-200].inte.getBounds().getWidth()>=700&&o==0)
          {
            sl=HMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            HMove.setValue((int)in[select-200].inte.getBounds().getX()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX()+(diff*7),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight());
  
            i=(int)in[select-200].inte.getBounds().getX()-1;
            m=1;
            while(m<=7)
            {
              for(j=(int)in[select-200].inte.getBounds().getY();j<=(int)in[select-200].inte.getBounds().getHeight()+(int)in[select-200].inte.getBounds().getY();j++)
              {
                //array[i-1][j-1]=0;
                //array[i-1][j-1]=1;
              }
              m++;
              i++;
            }
          }
          else
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX()-(diff*7),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight());
          }
          f1.show();
        }
        else if(select>=400&&select<500)
        {
          if((int)ex[select-400].exte.getBounds().getX()+(int)ex[select-400].exte.getBounds().getWidth()>=700&&o==0)
          {
            sl=HMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            HMove.setValue((int)ex[select-400].exte.getBounds().getX()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX()+(diff*7),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight());
  
            i=(int)ex[select-400].exte.getBounds().getX()-1;
            m=1;
            while(m<=7)
            {
              for(j=(int)ex[select-400].exte.getBounds().getY();j<=(int)ex[select-400].exte.getBounds().getHeight()+(int)ex[select-400].exte.getBounds().getY();j++)
              {
                //array[i-1][j-1]=0;
                //array[i-1][j-1]=1;
              }
              m++;
              i++;
            }
          }
          else
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX()-(diff*7),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight());
          }
          f1.show();
        }
      }
      else if(ce.getSource()==VMove)
      {
        if(select>=0&&select<100)
          temp=(int)((r[select].room.getBounds().getY())/7);
        else if(select>=200&&select<300)
          temp=(int)((in[select-200].inte.getBounds().getY())/7);
        else if(select>=400&&select<500)
          temp=(int)((ex[select-400].exte.getBounds().getY())/7);
        sval=100-VMove.getValue();
        diff=temp-sval;
        if(diff>0)o=1;
        else {diff*=-1;o=0;}
        
        System.out.println(sval+":"+diff);
        if(select>=0&&select<100)
        {
          if((int)r[select].room.getBounds().getY()+(int)r[select].room.getBounds().getHeight()>=700&&o==0)
          {
            sl=VMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            VMove.setValue(100-(int)r[select].room.getBounds().getY()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY()+(diff*7),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY()-(diff*7),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight());
          }
        }
        else if(select>=200&&select<300)
        {
          if((int)in[select-200].inte.getBounds().getY()+(int)in[select-200].inte.getBounds().getHeight()>=700&&o==0)
          {
            sl=VMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            VMove.setValue(100-(int)in[select-200].inte.getBounds().getY()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY()+(diff*7),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY()-(diff*7),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight());
          }
        }
        else if(select>=400&&select<500)
        {
          if((int)ex[select-400].exte.getBounds().getY()+(int)ex[select-400].exte.getBounds().getHeight()>=700&&o==0)
          {
            sl=VMove.getValue();
            System.out.println("S1:::::::::::::::"+sl);
            VMove.setValue(100-(int)ex[select-400].exte.getBounds().getY()/7);
          }
          else if(temp<sval)
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY()+(diff*7),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY()-(diff*7),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight());
          }
        }
        f1.show();
      }
      else if(ce.getSource()==WiExp)
      {
        if(select>=0&&select<100)
          temp=(int)((r[select].room.getBounds().getWidth())/7);
        else if(select>=200&&select<300)
          temp=(int)((in[select-200].inte.getBounds().getWidth())/7);
        else if(select>=400&&select<500)
          temp=(int)((ex[select-400].exte.getBounds().getWidth())/7);
        sval=WiExp.getValue();
        diff=Math.abs(temp-sval);
        System.out.println(sval+":"+diff);
        if(select>=0&&select<100)
        {
          if(temp<sval)
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth()+(diff*7),(int)r[select].room.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth()-(diff*7),(int)r[select].room.getBounds().getHeight());
          }
        }
        else if(select>=200&&select<300)
        {
          if(temp<sval)
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth()+(diff*7),(int)in[select-200].inte.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth()-(diff*7),(int)in[select-200].inte.getBounds().getHeight());
          }
        }
        else if(select>=400&&select<500)
        {
          if(temp<sval)
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth()+(diff*7),(int)ex[select-400].exte.getBounds().getHeight());
          }
          else
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth()-(diff*7),(int)ex[select-400].exte.getBounds().getHeight());
          }
        }
        f1.show();
      }
      else if(ce.getSource()==HiExp)
      {
        if(select>=0&&select<100)
          temp=(int)((r[select].room.getBounds().getHeight())/7);
        else if(select>=200&&select<300)
          temp=(int)((in[select-200].inte.getBounds().getHeight())/7);
        else if(select>=400&&select<500)
          temp=(int)((ex[select-400].exte.getBounds().getHeight())/7);
        sval=100-HiExp.getValue();
        diff=Math.abs(temp-sval);
        System.out.println(sval+":"+diff);
        if(select>=0&&select<100)
        {
          if(temp<sval)
          {
            temp=sval;
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight()+(diff*7));
          }                                                                                                                                                                                              
          else                                                                                                                                                                                           
          {                                                                                                                                                                                              
            temp=sval;                                                                                                                                                                                   
            r[select].room.setBounds((int)r[select].room.getBounds().getX(),(int)r[select].room.getBounds().getY(),(int)r[select].room.getBounds().getWidth(),(int)r[select].room.getBounds().getHeight()-(diff*7));
          }
        }
        else if(select>=200&&select<300)
        {
          if(temp<sval)
          {
            temp=sval;
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight()+(diff*7));
          }                                                                                                                                                                                              
          else                                                                                                                                                                                           
          {                                                                                                                                                                                              
            temp=sval;                                                                                                                                                                                   
            in[select-200].inte.setBounds((int)in[select-200].inte.getBounds().getX(),(int)in[select-200].inte.getBounds().getY(),(int)in[select-200].inte.getBounds().getWidth(),(int)in[select-200].inte.getBounds().getHeight()-(diff*7));
          }
        }
        else if(select>=400&&select<500)
        {
          if(temp<sval)
          {
            temp=sval;
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight()+(diff*7));
          }                                                                                                                                                                                              
          else                                                                                                                                                                                           
          {                                                                                                                                                                                              
            temp=sval;                                                                                                                                                                                   
            ex[select-400].exte.setBounds((int)ex[select-400].exte.getBounds().getX(),(int)ex[select-400].exte.getBounds().getY(),(int)ex[select-400].exte.getBounds().getWidth(),(int)ex[select-400].exte.getBounds().getHeight()-(diff*7));
          }
        }
        f1.show();
      }
    }
  }
  class MouseHandler implements MouseListener,MouseMotionListener
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
      if(pressed.getY()<=54)
        f1.setLocation(x, y);
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
  }
  class Room
  {  
    JPanel room;  
    JLabel l1,l2,l3,l4;  
    public JButton b1;  
    ImageIcon ii1,ii2,ii3;
    Room(int x1,int y1,int w1,int d1,String name,JButton b) 
    {  
      room=new JPanel();  
      room.setLayout(new BorderLayout());  
      ii1=new ImageIcon("images/HND.png");  
      ii2=new ImageIcon("images/VND.png");  
      //ii5=new ImageIcon("images/C.png");  
        
      l1=new JLabel(ii1);  
      l2=new JLabel(ii1);  
      l3=new JLabel(ii2);  
      l4=new JLabel(ii2);
      b1=b;  
      b1.setText(name);  
      b1.setRolloverEnabled(false);
      room.add(l1,BorderLayout.NORTH);  
      room.add(l2,BorderLayout.SOUTH);  
      room.add(l3,BorderLayout.WEST);  
      room.add(l4,BorderLayout.EAST);  
      room.add(b1,BorderLayout.CENTER);  
      room.setBounds(x1,y1,w1,d1);  
      room.setVisible(true);  
      left.add(room);  
    }
    Room()
    {
      b1=new JButton();
    }
  }
  class Interior
  { 
    JPanel inte;
    public JButton b1;  
    ImageIcon ii1;
    Interior()
    {
      b1=new JButton();
      b1.setRolloverEnabled(false);
      inte=new JPanel();
      inte.setLayout(new BorderLayout());
      inte.add(b1,BorderLayout.CENTER);
      inte.setBounds(0,0,5,5);
      inte.setVisible(false);
      left.add(inte);
    }
    void inter(int w1,int d1,JButton b,int type) 
    {  
      if(type==1) 
        ii1=new ImageIcon("images/sofa.gif");
      else if(type==2) 
        ii1=new ImageIcon("images/tv.jpg");
      else if(type==3) 
        ii1=new ImageIcon("images/bed.gif");
      else if(type==4) 
        ii1=new ImageIcon("images/table.gif");
      b1=b;
      b1.setIcon(ii1);
      inte.setBounds(0,0,w1,d1);  
      inte.setVisible(true);
    }
  }
  class Exterior
  { 
    JPanel exte;
    public JButton b1;  
    ImageIcon ii1;
    Exterior()
    {
      b1=new JButton();
      b1.setRolloverEnabled(false);
      exte=new JPanel();
      exte.setLayout(new BorderLayout());
      exte.add(b1,BorderLayout.CENTER);
      exte.setBounds(0,0,5,5);
      exte.setVisible(false);
      left.add(exte);
    }
    void exter(int w1,int d1,JButton b,int type) 
    {  
      if(type==1) 
        ii1=new ImageIcon("images/sp.gif");
      else if(type==2) 
        ii1=new ImageIcon("images/ground.gif");
      else if(type==3) 
        ii1=new ImageIcon("images/garden.jpg");
      else if(type==4) 
        ii1=new ImageIcon("images/lawn.jpg");
      else if(type==5) 
        ii1=new ImageIcon("images/parking.jpg");
      b1=b;
      b1.setIcon(ii1);
      exte.setBounds(0,0,w1,d1);  
      exte.setVisible(true);
    }
  } 
}