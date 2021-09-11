package LoginPro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class HomePage implements ActionListener {
	JFrame fr;
	JLabel lbl_heading,lbl_id,lbl_name,lbl_gender,lbl_phone_number,lbl_email, lbl_address, lbl_delete_id;
	JTextField txt_id,txt_name,txt_gender,txt_phone_number,txt_email, txt_address, txt_delete_id, txt_select_id;
	JButton btn_add,btn_delete_id, btn_update, btn_select;
	
	Font fon1,fon2,fon3,fon;
	JPanel panel,panel1, panel2, panel3;
	ImageIcon reg_bg;
	JCheckBox aggree;
	JRadioButton rmale,rfemale;
	DefaultTableModel model;

    JTable jt;
    public void update_id(JPanel panel) {
		
		fon1=new Font("algerian",Font.BOLD,50);
		fon2=new Font("areal",Font.BOLD,18);
		fon3=new Font("algerian",Font.BOLD,40);
		txt_select_id=new JTextField();
		txt_select_id.setFont(fon2);
		txt_select_id.setBackground(new Color(245,254,255));
		txt_select_id.setBounds(50,400,170,35);
		panel.add(txt_select_id);
		btn_update=new JButton("UPDATE");
		btn_update.setForeground(Color.white);
		btn_update.setBackground(new Color(11,135,15));
		btn_update.setBorder(new LineBorder(Color.green,6));
		btn_update.setFont(fon3);
		btn_update.setBounds(250,450,200,50);
		btn_update.addActionListener(this);
		panel.add(btn_update);
		
		
		btn_select=new JButton("SELECT");
		btn_select.setForeground(Color.white);
		btn_select.setBackground(new Color(11,135,15));
		btn_select.setBorder(new LineBorder(Color.green,6));
		btn_select.setFont(fon3);
		btn_select.setBounds(250,400,200,50);
		btn_select.addActionListener(this);
		panel.add(btn_select);
		String id=txt_select_id.getText();
		
				
	}
    public void data(JPanel panel) {
    	this.panel=panel;
    	model= new DefaultTableModel();
    	jt= new JTable(model);
    	fon=new Font("Dialog", Font.BOLD, 22);
    	fon1=new Font("Serif", Font.BOLD, 18);
    	jt.setFont(fon1);
    	jt.setRowHeight(40);
    	jt.setBackground(new Color(122,243,138));
    	model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Phone Number");
        model.addColumn("Email");
        model.addColumn("Address");
        JTableHeader header = jt.getTableHeader();
        header.setFont(fon);
        header.setBackground(Color.black);
        header.setForeground(Color.white);
        jt.getTableHeader().setPreferredSize(new Dimension(100,50));
        try {
        	DbConnection db=new DbConnection();
        	String query="select * from info";
        	ResultSet rs=db.select(query);
        	DefaultTableModel model=(DefaultTableModel)jt.getModel();
        	model.setRowCount(0);
//        	model.fireTableDataChanged();
//        	jt.repaint();
            int i=0;
          
            while(rs.next()){
            	System.out.println(rs.getString(1)+" "+rs.getString(2));
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),
                		rs.getString(4),rs.getString(5), rs.getString(6)});
                
//            	((AbstractTableModel) jt.getModel()).fireTableCellUpdated(1, 0);
            	
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jt);
        pg.setBounds(0,0,650,400);
        panel.add(pg);
    }


	public HomePage() {
		fr=new JFrame("Information Page");
		fon1=new Font("algerian",Font.BOLD,50);
		fon2=new Font("areal",Font.BOLD,18);
		fon3=new Font("areal",Font.BOLD,30);
		fon=new Font("areal",Font.BOLD,30);
		panel= new JPanel();
		panel.setBounds(0,0,1370,700);
		panel.setLayout(null);
		fr.add(panel);
		
		
		panel1= new JPanel();
		panel1.setBounds(10,50,650,500);
		panel1.setBackground(Color.green);
		panel1.setLayout(null);
		panel.add(panel1);
		update_id(panel1);
		
		panel2= new JPanel();
		panel2.setBounds(800,400,660,180);
		panel2.setBackground(Color.green);
		panel2.setLayout(null);
		panel.add(panel2);
		
		
		panel3= new JPanel();
		panel3.setBounds(800,40,650,400);
		panel3.setBackground(Color.green);
		panel3.setLayout(null);
		panel.add(panel3);
		data(panel3);
		
		
		txt_delete_id=new JTextField();
		txt_delete_id.setFont(fon2);
		txt_delete_id.setBackground(new Color(245,254,255));
		txt_delete_id.setBounds(230,50,170,35);
		panel2.add(txt_delete_id);
		
		btn_delete_id=new JButton("Delete");
		btn_delete_id.setFont(fon2);
		btn_delete_id.setForeground(new Color(5,188,5));
		btn_delete_id.setBounds(235,100,200,45);
		btn_delete_id.setBackground(new Color(207,241,245));
		btn_delete_id.addActionListener(this);
		panel2.add(btn_delete_id);
		

		
		
		lbl_name=new JLabel("Name:");
		lbl_name.setFont(fon2);
		lbl_name.setBounds(20,80,300,50);
		panel1.add(lbl_name);
		
		txt_name=new JTextField();
		txt_name.setFont(fon2);
		txt_name.setBackground(new Color(245,254,255));
		txt_name.setBounds(130,85,170,35);
		panel1.add(txt_name);
		
		
		lbl_email=new JLabel("Email         :");
		lbl_email.setFont(fon2);
		lbl_email.setBounds(20,140,300,50);
		panel1.add(lbl_email);
		
		txt_email=new JTextField();
		txt_email.setFont(fon2);
		txt_email.setBounds(130,145,170,35);
		txt_email.setBackground(new Color(245,254,255));
		panel1.add(txt_email);
		
		lbl_gender =new JLabel("Gender :");
		lbl_gender.setFont(fon2);
		lbl_gender.setBounds(310,140,300,50);
		panel1.add(lbl_gender);
		
		rmale=new JRadioButton("Male");    
		rmale.setBounds(460,150,80,30);  
		rmale.setFont(fon2);
		rmale.setBackground(new Color(253,253,132));
		rfemale=new JRadioButton("Female");    
		rfemale.setBounds(550,150,100,30);  
		rfemale.setFont(fon2);
		rfemale.setBackground(new Color(253,253,132));
		ButtonGroup bg=new ButtonGroup(); 
		bg.add(rmale);
		bg.add(rfemale);
		panel1.add(rmale);
		panel1.add(rfemale);
		
		lbl_phone_number=new JLabel("Contact:");
		lbl_phone_number.setFont(fon2);
		lbl_phone_number.setBounds(20,180,300,50);
		panel1.add(lbl_phone_number);
		
		txt_phone_number=new JTextField();
		txt_phone_number.setFont(fon2);
		txt_phone_number.setBounds(130,190,170,35);
		txt_phone_number.setBackground(new Color(245,254,255));
		panel1.add(txt_phone_number);
		
		lbl_address=new JLabel("Address         :");
		lbl_address.setFont(fon2);
		lbl_address.setBounds(20,220,300,50);
		panel1.add(lbl_address);
		
		txt_address=new JTextField();
		txt_address.setFont(fon2);
		txt_address.setBounds(130,230,170,35);
		txt_address.setBackground(new Color(245,254,255));
		panel1.add(txt_address);
		
		
		
	    
		btn_add=new JButton("ADD");
		btn_add.setFont(fon3);
		btn_add.setForeground(new Color(5,188,5));
		btn_add.setBounds(250,295,200,45);
		btn_add.setBackground(new Color(207,241,245));
		btn_add.addActionListener(this);
		panel1.add(btn_add);
		
		
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.setVisible(true);
		fr.setBackground(Color.YELLOW);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_update) {
			String id=txt_select_id.getText();
			   String gender="";
			       if (rmale.isSelected()) {
			           gender=rmale.getText();
			       }
			       if(rfemale.isSelected()) {
			           gender=rfemale.getText();
			       }
			       ;
			   try {
			      String query="update info set name='"+txt_name.getText()+"',"
			            + "email='"+txt_email.getText()+"',gender='"+gender+"',phone_number='"+txt_phone_number.getText()+"',address='"+txt_address.getText()+"'"
			                  + " where id='"+id +"'";
			      DbConnection db=new DbConnection();
			      int rs=db.Update(query);
			      JOptionPane.showMessageDialog(btn_update, "Update successsful");
			      panel3.removeAll();
	        		panel3.repaint();
	        		panel3.revalidate();
	        		data(panel3);
			   }
			   finally{
			      
			   }
			}
		
		if (e.getSource()==btn_select) {
			String id=txt_select_id.getText();
			DbConnection db=new DbConnection();
			String query="select * from info where id='"+id+"'";
			ResultSet rs=db.select(query);
			try {
				while (rs.next())
				  {
					
					txt_name.setText(rs.getString("name"));
					
					
					txt_phone_number.setText(rs.getString("phone_number"));
					
					
					txt_email.setText(rs.getString("email"));
					
					
					txt_address.setText(rs.getString("address"));
					
					
					String gender=rs.getString("gender");
					
			        if (gender.length()==4 ) {
			        	System.out.println("male");
			        	rmale.setSelected(true);
			        }
			        else{
			        	rfemale.setSelected(true);
			        	System.out.println("female");
			        	
			        }
			        	
					
					
					
	}
			} catch (SQLException eR) {
				// TODO Auto-generated catch block
				eR.printStackTrace();
			}
			

			
		}
		if (e.getSource()==btn_delete_id) {
			try {
				DbConnection db=new DbConnection();
				String sql = "DELETE FROM info WHERE id='"+txt_delete_id.getText()+"'";
				int rowsDeleted = db.executeDelete(sql);
				model = (DefaultTableModel) jt.getModel();
				if (rowsDeleted > 0) {
					JOptionPane.showMessageDialog(btn_delete_id, "Successfully deleted");
					panel3.removeAll();
	        		panel3.repaint();
	        		panel3.revalidate();
	        		data(panel3);
	        		
					
				}
				 
			}
				catch(Exception ex) {
					ex.printStackTrace();
					
				}
		}
		if (e.getSource()==btn_add) {
			
		     String name=txt_name.getText();
		     String phone_number=txt_phone_number.getText();
		     String email=txt_email.getText();
		     String address=txt_address.getText();
		     String gender="";
		        if (rmale.isSelected()) {
		        	gender=rmale.getText();
		        }
		        if(rfemale.isSelected()) {
		        	gender=rfemale.getText();
		        }
		        ;
		     
		     DbConnection db=new DbConnection();
		     
		     String query="insert into info(name,gender,phone_number,email,address)"
	        			+ " values('"+name+"','"+gender+"',"
	        					+ "'"+phone_number+"','"+email+"',"
	        		+ "'"+address+"')";
	        	int ans= db.insert(query);
	        	if (ans>0) {
	        		JOptionPane.showMessageDialog(btn_add, "Contact saved");
	        		panel3.removeAll();
	        		panel3.repaint();
	        		panel3.revalidate();
	        		data(panel3);
	        	
	        		txt_name.setText("");
	   		     txt_phone_number.setText("");
	   		     txt_email.setText("");
	   		     txt_address.setText("");
	   		     
	        	} 
	        	
	        		
	        	}
		     }
		}
	


