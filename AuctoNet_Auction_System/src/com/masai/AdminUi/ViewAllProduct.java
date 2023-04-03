package com.masai.AdminUi;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ViewAllProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AdminDaoImpl admin = new AdminDaoImpl();
	static ViewAllProduct frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewAllProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAllProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1444, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminOperations oper = new AdminOperations();
				oper.main(null);
				
			}
		});
		btnNewButton.setBounds(1252, 602, 168, 64);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 1410, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "Redmi Note 10 Pro", null, "seller1", "Rajesh Kumar", new Integer(50), "6GB RAM, 128GB storage, 64MP quad camera", new Integer(0), new Integer(2)},
				{new Integer(2), "Realme 8", null, "seller9", "Suresh Menon", new Integer(30), "8GB RAM, 128GB storage, 64MP quad camera", new Integer(0), new Integer(2)},
				{new Integer(3), "Mi TV 4A Horizon Edition", null, "seller7", "Aparna Bose", new Integer(10), "43-inch Full HD LED TV, Android TV, PatchWall", new Integer(0), new Integer(2)},
				{new Integer(4), "Samsung Galaxy M51", null, "seller4", "Neha Patel", new Integer(20), "6GB RAM, 128GB storage, 64MP quad camera", new Integer(0), new Integer(2)},
				{new Integer(5), "Poco X3 Pro", null, "seller1", "Rajesh Kumar", new Integer(40), "6GB RAM, 128GB storage, 48MP quad camera", new Integer(0), new Integer(2)},
				{new Integer(6), "Realme Narzo 30", null, "seller2", "Priya Sharma", new Integer(25), "4GB RAM, 64GB storage, 48MP triple camera", new Integer(0), new Integer(2)},
				{new Integer(7), "Basmati Rice 5 kg", null, "seller1", "Rajesh Kumar", new Integer(100), "Premium quality basmati rice.", new Integer(0), new Integer(3)},
				{new Integer(8), "Organic Turmeric Powder 250g", null, "seller2", "Priya Sharma", new Integer(50), "100% certified organic turmeric powder.", new Integer(0), new Integer(3)},
				{new Integer(9), "Cotton T-shirt", null, "seller6", "Vikas Jain", new Integer(30), "100% pure cotton t-shirt, available in all sizes.", new Integer(0), new Integer(1)},
				{new Integer(10), "Jeans", null, "seller7", "Aparna Bose", new Integer(20), "Stylish and comfortable jeans for men and women.", new Integer(0), new Integer(1)},
				{new Integer(11), "Stainless Steel Water Bottle", null, "seller10", "Rohit Raj", new Integer(50), "Leak-proof and eco-friendly water bottle, available in 500 ml and 1 liter sizes.", new Integer(0), new Integer(4)},
				{new Integer(12), "Wall Clock", null, "seller5", "Rashmi Gupta", new Integer(10), "Beautiful and elegant wall clock, adds style to your home decor.", new Integer(0), new Integer(4)},
			},
			new String[] {
				"product_id", "product_name", "price_per_piece", "seller_id", "seller_name", "quantity", "description", "sold_status", "category_id"
			}
		));
	    
		
		try {
			
			table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
			
			
			CSS.setTable(table);
			
			JComboBox comboBox = new JComboBox();
			comboBox.addItem("Clothing");
			comboBox.addItem("Electronics");
			comboBox.addItem("Grocery");
			comboBox.addItem("Miscellaneous");
			comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
			comboBox.setBounds(519, 393, 157, 30);
			contentPane.add(comboBox);
			
			JLabel lblNewLabel = new JLabel("View Product By Category : ");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblNewLabel.setBounds(251, 385, 296, 40);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_1 = new JButton("View");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item = (String) comboBox.getSelectedItem();
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllProductsByCategory(item)));
						CSS.setTable(table);
						
						if(table.getRowCount()==0) {
							JOptionPane.showMessageDialog(null, "No Record Found");
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
							CSS.setTable(table);
						}
					} catch (RecordNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "No Record Found");
					}
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_1.setBounds(708, 394, 118, 35);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("View Sold Products Only");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllSoldProducts()));
						
						if(table.getRowCount()==0) {
							JOptionPane.showMessageDialog(null, "No Record Found");
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
							CSS.setTable(table);
						
						}
						
					} catch (RecordNotFoundException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
			});
			btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			btnNewButton_2.setBounds(437, 530, 307, 51);
			contentPane.add(btnNewButton_2);
			
		} catch (RecordNotFoundException e) {
		
			
			JOptionPane.showMessageDialog(null, "No Record Found...");
			
		}
		
	}
	
	
}
