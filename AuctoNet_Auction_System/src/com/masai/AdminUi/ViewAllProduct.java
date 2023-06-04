package com.masai.AdminUi;

import java.awt.Color;
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
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ViewAllProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AdminDaoImpl admin = new AdminDaoImpl();
	static ViewAllProduct frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminOperations oper = new AdminOperations();
				oper.main(null);
				
			}
		});
		btnNewButton.setBounds(1317, 627, 103, 39);
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
			btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 22));
			btnNewButton_2.setBounds(651, 589, 307, 51);
			contentPane.add(btnNewButton_2);
			
			JPanel panel = new JPanel();
			panel.setBounds(20, 534, 307, 132);
			panel.setBackground(new Color(0, 0, 0, 80));
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("View Products By Category ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(SystemColor.textHighlightText);
			lblNewLabel.setBounds(10, 10, 265, 46);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 64, 173, 40);
			panel.add(comboBox);
			comboBox.addItem("Clothing");
			comboBox.addItem("Electronics");
			comboBox.addItem("Grocery");
			comboBox.addItem("Miscellaneous");
			comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 17));
			
			JButton btnNewButton_1 = new JButton("View");
			btnNewButton_1.setBounds(193, 67, 96, 37);
			panel.add(btnNewButton_1);
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
			btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			
			JButton btnNewButton_2_1 = new JButton("Sort The Products By Price ");
			btnNewButton_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
			btnNewButton_2_1.setBounds(634, 411, 372, 51);
			contentPane.add(btnNewButton_2_1);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(new Color(0, 0, 0, 80));
			panel_1_1.setBounds(1056, 349, 364, 206);
			contentPane.add(panel_1_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("View Products By Quantity Range");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			lblNewLabel_2_1.setBounds(-14, 10, 368, 46);
			panel_1_1.add(lblNewLabel_2_1);
			
		
			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setFont(new Font("Bahnschrift", Font.BOLD, 21));
			textField_1.setColumns(10);
			textField_1.setBounds(78, 86, 77, 37);
			panel_1_1.add(textField_1);
			
			
			
			JButton btnNewButton_1_1_1 = new JButton("View");
			btnNewButton_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton_1_1_1.setBounds(139, 144, 87, 33);
			panel_1_1.add(btnNewButton_1_1_1);
			

			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item = (String) textField.getText() ;
					
					int from = 0;
					int to = 0;
					try {
						
						from = Integer.parseInt(textField_1.getText());
						to = Integer.parseInt(textField_2.getText());
						
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Invalid Values");
						try {
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
							textField_1.setText("");
							textField_2.setText("");
						} catch (RecordNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						CSS.setTable(table);
						
						return;
					}
					
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllProductsByQuantity(from,to)));
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
			
			JLabel lblNewLabel_1_1 = new JLabel("From:");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
			lblNewLabel_1_1.setBounds(-53, 96, 188, 27);
			panel_1_1.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("To:");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
			lblNewLabel_1_1_1.setBounds(153, 96, 188, 27);
			panel_1_1.add(lblNewLabel_1_1_1);
			
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setFont(new Font("Bahnschrift", Font.BOLD, 21));
			textField_2.setColumns(10);
			textField_2.setBounds(264, 86, 77, 37);
			panel_1_1.add(textField_2);
			
		
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(20, 349, 542, 133);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(0, 0, 0, 80));
			
			JLabel lblNewLabel_2 = new JLabel("View Products For Particular Seller");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			lblNewLabel_2.setBounds(104, 10, 368, 46);
			panel_1.add(lblNewLabel_2);
			
			JButton btnNewButton_1_1 = new JButton("View");
			btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton_1_1.setBounds(430, 73, 102, 35);
			panel_1.add(btnNewButton_1_1);
			
			
			textField = new JTextField();
			textField.setFont(new Font("Bahnschrift", Font.BOLD, 21));
			textField.setBounds(198, 71, 194, 37);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Enter Seller Id :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
			lblNewLabel_1.setForeground(SystemColor.textHighlightText);
			lblNewLabel_1.setBounds(10, 76, 188, 27);
			panel_1.add(lblNewLabel_1);
			
			
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item = (String) textField.getText() ;
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllProductsBySellerId(item)));
						CSS.setTable(table);
						
						if(table.getRowCount()==0) {
							JOptionPane.showMessageDialog(null, "No Record Found");
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
							textField.setText("");
							CSS.setTable(table);
						}
					} catch (RecordNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "No Record Found");
					}
				}
			});
			
			btnNewButton_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllProductsByInAccendingOrderByPrice()));
						
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
			
		
		} catch (RecordNotFoundException e) {
		
			
			JOptionPane.showMessageDialog(null, "No Record Found...");
			
		}
		
	}
}
