import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame {



  private JButton btnTutup  = new JButton("Exit");
  private JButton btnTambah = new JButton("Create");

  private JTextField txtA = new JTextField();
  private JTextField txtB = new JTextField();
  private JTextField txtC = new JTextField();

  private JLabel lblA = new JLabel("Password :");
  private JLabel lblB = new JLabel("Password Name :");
  private JLabel lblC = new JLabel("Edit Password :");

  public MyFrame(){
    getContentPane().setBackground(Color.GRAY);
    setTitle("Login In");
    setSize(400,200);
    setLocation(new Point(300,200));
    setLayout(null);    
    setResizable(false);
    initComponent();    
    initEvent();    
  }

  private void initComponent(){
    btnTutup.setBounds(300,130, 80,25);
    btnTambah.setBounds(300,100, 80,25);

    txtA.setBounds(150,10,100,20);
    //txtB.setBounds(200,35,100,20);
    //txtC.setBounds(200,65,100,20);

    lblA.setBounds(20,10,100,20);
    //lblB.setBounds(20,35,100,20);
    //lblC.setBounds(20,65,100,20);


    add(btnTutup);
    add(btnTambah);

    add(lblA);
    //add(lblB);
    //add(lblC);

    add(txtA);
    //add(txtB);
    //add(txtC);
  }

  private void initEvent(){

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
       System.exit(1);
      }
    });

    btnTutup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTutupClick(e);
      }
    });

    btnTambah.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTambahClick(e);
      }
    });
  }
  
  private void btnTutupClick(ActionEvent evt){
    System.exit(0);
  }
  
  private void btnTambahClick(ActionEvent evt){
    Integer x,y,z;
    try{
      x = Integer.parseInt(txtA.getText());
      y = Integer.parseInt(txtB.getText());
      z = x + y;
      txtC.setText(z.toString());

    }catch(Exception e){
      System.out.println(e);
      JOptionPane.showMessageDialog(null, 
          e.toString(),
          "Error", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
}