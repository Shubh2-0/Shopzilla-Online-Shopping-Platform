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
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setBounds(100, 100, 1554, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton);
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminOperations.main(null);
				
			}
		});
		btnNewButton.setBounds(1389, 724, 103, 39);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 1505, 383);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
	    
		
		try {
			
			table.setModel(DbUtils.resultSetToTableModel(admin.getAllProducts()));
			
			
			CSS.setTable(table);
			
			JButton btnNewButton_2 = new JButton("View Sold Products Only");
			CSS.setMouseCursorNormal2(btnNewButton_2);
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
			btnNewButton_2.setBounds(633, 647, 373, 51);
			contentPane.add(btnNewButton_2);
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 621, 307, 132);
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
			CSS.setMouseCursorNormal2(btnNewButton_1);
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
			CSS.setMouseCursorNormal2(btnNewButton_2_1);
			btnNewButton_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
			btnNewButton_2_1.setBounds(634, 559, 372, 51);
			contentPane.add(btnNewButton_2_1);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(new Color(0, 0, 0, 80));
			panel_1_1.setBounds(1151, 446, 364, 206);
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
			CSS.setMouseCursorNormal2(btnNewButton_1_1_1);
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
			panel_1.setBounds(10, 478, 542, 133);
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
			CSS.setMouseCursorNormal2(btnNewButton_1_1);
			btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton_1_1.setBounds(430, 73, 102, 35);
			panel_1.add(btnNewButton_1_1);
			
			
			textField = new JTextField();
			textField.setFont(new Font("Bahnschrift", Font.BOLD, 21));
			textField.setBounds(198, 71, 194, 37);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Enter Username :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
			lblNewLabel_1.setForeground(SystemColor.textHighlightText);
			lblNewLabel_1.setBounds(10, 76, 188, 27);
			panel_1.add(lblNewLabel_1);
			
			
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item = (String) textField.getText() ;
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllProductsBySellerUsername(item)));
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
						CSS.setTable(table);
						
						if(table.getRowCount()== 0) {
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
