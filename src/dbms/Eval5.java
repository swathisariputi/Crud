package dbms;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Eval5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eval5 window = new Eval5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Eval5() {
		initialize();
		Connected();
		//table_load();
	}
	Connection con;
	PreparedStatement pst;
	private JTable table;
	private JTextField age;
	private JTextField address;
	private JTextField name;
	private JTextField contact;
	private JTextField country_id;
	private JTextField current_profession;
	private JTextField pro_exp;
	private JTextField total_inc1;
	private JButton btnNewButton_1;
	private JTextField findage;
	private JTextField findincome;
	private JTextField findco;
	private JTable table_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField comd;
	private JTextField how_manyyear;
	private JTextField pre_wor;
	private JTextField num_year;
	private JTextField year_par;
	
	public void Connected() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","C##swathi","0000");
			//con = DriverManager.getConnection("jdbc:mysql://localhost/databasename","root","");
			System.out.println("Connected");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Connection failed-class not found");
		}
		catch (SQLException ex) {
			System.out.println("Connection failed");
		}
	}
	void table_load() {
		try {
			pst = con.prepareStatement("select * from personal_details");
			ResultSet Rs;
			Rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(Rs));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1143, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 789, 99);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		name = new JTextField();
		name.setBounds(10, 10, 85, 19);
		panel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(105, 10, 79, 19);
		panel.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.setBounds(194, 10, 79, 19);
		panel.add(address);
		address.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(286, 10, 64, 19);
		panel.add(contact);
		contact.setColumns(10);
		
		country_id = new JTextField();
		country_id.setBounds(372, 10, 96, 19);
		panel.add(country_id);
		country_id.setColumns(10);
		
		current_profession = new JTextField();
		current_profession.setBounds(485, 10, 96, 19);
		panel.add(current_profession);
		current_profession.setColumns(10);
		
		pro_exp = new JTextField();
		pro_exp.setBounds(591, 10, 96, 19);
		panel.add(pro_exp);
		pro_exp.setColumns(10);
		
		total_inc1 = new JTextField();
		total_inc1.setBounds(697, 10, 79, 19);
		panel.add(total_inc1);
		total_inc1.setColumns(10);
		
		comd = new JTextField();
		comd.setText("");
		comd.setBounds(140, 70, 96, 19);
		panel.add(comd);
		comd.setColumns(10);
		
		how_manyyear = new JTextField();
		how_manyyear.setBounds(265, 70, 96, 19);
		panel.add(how_manyyear);
		how_manyyear.setColumns(10);
		
		pre_wor = new JTextField();
		pre_wor.setBounds(385, 70, 96, 19);
		panel.add(pre_wor);
		pre_wor.setColumns(10);
		
		num_year = new JTextField();
		num_year.setBounds(507, 70, 96, 19);
		panel.add(num_year);
		num_year.setColumns(10);
		
		year_par = new JTextField();
		year_par.setBounds(626, 70, 96, 19);
		panel.add(year_par);
		year_par.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(928, 33, 191, 456);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("WAR");
		lblNewLabel.setBounds(381, 10, 203, 22);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nme=name.getText();
				String age1=age.getText();
				int age=Integer.parseInt(age1);
				String add=address.getText();
				String contact1=contact.getText();
				int contact=Integer.parseInt(contact1);
				String countid=country_id.getText();
				String pro_ex=pro_exp.getText();
				String curpro=current_profession.getText();
				String total_in=total_inc1.getText();
				int total_inc=Integer.parseInt(total_in);
				String co=comd.getText();
				String how=how_manyyear.getText();
			    int how_many=Integer.parseInt(how);
			    String pre_work=pre_wor.getText();
			    String num_pre=num_year.getText();
			    int num_pre_work=Integer.parseInt(num_pre);
			    String year_pa=year_par.getText();
				try {
					PreparedStatement insert,insert1;
					insert = con.prepareStatement("insert into personal_details values (?,?,?,?,?,?,?,?)");
					insert.setString(1, nme);
					insert.setInt(2, age);
					insert.setString(3,add);
					insert.setInt(4,contact);
					insert.setString(5, countid);
					insert.setString(6,curpro );
					insert.setString(7,pro_ex);
					insert.setInt(8,total_inc);
                    insert.executeUpdate();
                    insert1 = con.prepareStatement("insert into Military_Database values (?,?,?,?,?,?,?,?)");
					insert1.setString(1, countid);
					insert1.setString(2, nme);
					insert1.setString(3,co);
					insert1.setInt(4,contact);
					insert1.setInt(5,how_many);
					insert1.setString(6,pre_work );
					insert1.setInt(7,num_pre_work);
					insert1.setString(8,year_pa);
                    insert1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Inserted new record");
                    //table_load();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(809, 61, 85, 55);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("FIND");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            try {  
		            PreparedStatement search;
					String src=findage.getText();
					int age=Integer.parseInt(src);
					String inc=findincome.getText();
					int income=Integer.parseInt(inc);
					String co=findco.getText();
					search = con.prepareStatement("select p.country_id,p.nme,age,address,p.contact,current_profession,Professional_Experience,Total_income,country_region,how_manyyears_inCountry,how_manyyears_inCountry, previous_worked,no_ofyears_previous_worked, Years_participated from personal_details p, Military_Database m where p.contact=m.contact and age<? and Total_income<? and country_region=?");
					search.setInt(1,age);
					search.setInt(2,income);
					search.setString(3,co);
					ResultSet res;
					res=search.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(res));
	 
	        }catch (SQLException ex) {
	 
	        }
			}
		});
		btnNewButton_1.setBounds(40, 183, 111, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		findage = new JTextField();
		findage.setBounds(178, 184, 96, 19);
		frame.getContentPane().add(findage);
		findage.setColumns(10);
		
		findincome = new JTextField();
		findincome.setBounds(306, 184, 96, 19);
		frame.getContentPane().add(findincome);
		findincome.setColumns(10);
		
		findco = new JTextField();
		findco.setBounds(428, 184, 156, 19);
		frame.getContentPane().add(findco);
		findco.setColumns(10);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
			}
		});
		table_2.setBounds(10, 262, 725, 217);
		frame.getContentPane().add(table_2);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                int selectedIndex = table_2.getSelectedRow();
	            try {  
	            String cont  = model.getValueAt(selectedIndex, 4).toString();
	            int contact=Integer.parseInt(cont);
	            PreparedStatement delete,delete1;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to Delete the record","Warning",JOptionPane.YES_NO_OPTION);
	            if(dialogResult == JOptionPane.YES_OPTION){
	            delete = con.prepareStatement("delete from personal_details where contact = ?");
	            delete.setInt(1,contact);
	            delete.executeUpdate();
	            delete1 = con.prepareStatement("delete from Military_Database where contact = ?");
	            delete1.setInt(1,contact);
	            delete1.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Deleted");
	            //table_load();
	            
	            }         
	        }  catch (SQLException ex) {
	 
	        }	
			}
		});
		btnNewButton_2.setBounds(773, 323, 102, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                int selectedIndex = table_2.getSelectedRow();
	            try {  
	            	int dialogResult =Integer.parseInt(JOptionPane.showInputDialog ("Enter the new contact of record which you wanted to update"));
		            PreparedStatement update,update1;
		            String cont  = model.getValueAt(selectedIndex, 4).toString();
		            int contact=Integer.parseInt(cont);
					update = con.prepareStatement("update personal_details set contact= ? where contact= ?");
					update1 = con.prepareStatement("update Military_Database set contact= ? where contact= ?");
					update.setInt(1,dialogResult);
					update.setInt(2,contact);
					update.executeUpdate();
					update1.setInt(1,dialogResult);
					update1.setInt(2,contact);
					update1.executeUpdate();
	                JOptionPane.showMessageDialog(null, "Record Updated");
	                //table_load(); 
	        }catch (SQLException ex) {
	 
	        }
			}
		});
		btnNewButton_3.setBounds(773, 364, 102, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("View ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load(); 
			}
		});
		btnNewButton_4.setBounds(947, 10, 138, 21);
		frame.getContentPane().add(btnNewButton_4);
	}
}
