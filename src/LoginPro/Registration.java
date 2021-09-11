package LoginPro;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 

public class Registration implements ActionListener{
    JFrame frame;
    JLabel lbl_image,lbl_heading,lbl_username,lbl_password,lbl_cpassword;
    JTextField txt_fname,txt_lname,txt_username;
    JPasswordField txt_password,txt_cpassword;
    JButton register,cancel;
    JPanel p;
    JComboBox c;
    
    Font fon1,fon2;
    ImageIcon image;
    JButton btn_register,btn_cancel;
    
    public Registration() {
    frame=new JFrame ("Registration Page");
    fon1=new Font("arial",Font.BOLD,35);
    fon2=new Font("arial",Font.BOLD,25);
    
    p= new JPanel();
    
    
    
    lbl_heading = new JLabel(" User Registration");
    lbl_heading.setForeground(new Color(255,255,255));
    lbl_heading.setFont(fon1);
    lbl_heading.setBounds(500,60,400,50);
    p.add(lbl_heading);
    
    
    lbl_username = new JLabel("Email");
    lbl_username.setForeground(new Color(0,0,0));
    lbl_username.setFont(fon2);
    lbl_username.setBounds(400,200,250,30);
    p.add(lbl_username);
    
    txt_username = new JTextField();
    txt_username.setForeground(Color.blue);
    txt_username.setFont(fon2);
    txt_username.setBounds(650,250,250,30);
    p.add(txt_username);
    
    lbl_password = new JLabel("Password");
    lbl_password.setForeground(new Color(0,0,0));
    lbl_password.setFont(fon2);
    lbl_password.setBounds(400,300,250,30);
    p.add(lbl_password);
    
    txt_password = new JPasswordField();
    txt_password.setForeground(Color.blue);
    txt_password.setFont(fon2);
    txt_password.setBounds(650,350,250,30);
    p.add(txt_password);
    
    lbl_cpassword = new JLabel("Confirm Password");
    lbl_cpassword.setForeground(new Color(0,0,0));
    lbl_cpassword.setFont(fon2);
    lbl_cpassword.setBounds(400,400,250,30);
    p.add(lbl_cpassword);
    
    txt_cpassword = new JPasswordField();
    txt_cpassword.setForeground(Color.blue);
    txt_cpassword.setFont(fon2);
    txt_cpassword.setBounds(650,450,250,30);
    p.add(txt_cpassword);
    
    
    register = new JButton("Register");
    register.setForeground(new Color(0,255,0));
    register.setFont(fon1);
    register.addActionListener(this);
    register.setBackground(new Color(16,1,35));
    register.setBounds(400,500,250,50);
    p.add(register);
    
    cancel = new JButton("Clear");
    cancel.setForeground(new Color(0,255,0));
    cancel.setFont(fon1);
    cancel.setBackground(new Color(16,1,35));
    cancel.setBounds(700,500,250,50);
    p.add(cancel);
    
    image= new ImageIcon(getClass().getResource("backgroungs.png"));
    lbl_image=new JLabel(image);
    lbl_image.setBounds(100, 0, 1300, 700);
    p.add(lbl_image);
    
    frame.add(p);
    p.setBounds(0,0,1300,700);
    p.setLayout(null);

 

    frame.setSize(1700,900);
    frame.setLayout(null);
    frame.setVisible(true);
}

 

    @Override
    public void actionPerformed(ActionEvent e) {
        String email=txt_username.getText();
        String password=txt_password.getText();
        
                
        if(e.getSource()==register) {
            DbConnection db=new DbConnection();
            String query="insert into registration_tbl(email,password) values('"+email+"','"+password+"')";
            int ans= db.insert(query);
            if (ans>0) {
                JOptionPane.showMessageDialog(register, "User successfully registered");
            }
        }
    }

    
}

 


