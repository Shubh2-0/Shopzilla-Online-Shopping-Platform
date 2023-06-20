package com.masai.AdminUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.MainUi.MainPage;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Transaction extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	static Transaction frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private AdminDaoImpl admin = new AdminDaoImpl(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Transaction();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1554, 844);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1520, 371);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Return Policy", "Total Amount", "Tax Amount", "Gst Percentage", "Price", "Price Per Unit", "Purchase Date", "Quantity", "Buyer Name", "Buyer Id", "Product Name", "Product Id", "Transaction Id"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(12).setPreferredWidth(78);
		table.getColumnModel().getColumn(12).setMinWidth(28);
		try {
			table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransaction()));
			
			btnNewButton = new JButton("Back");
			CSS.setMouseCursorBack(btnNewButton);
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					AdminOperations.main(null);
					
				}
			});
			
			CSS.setTable(table);
			
			
			btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton.setBounds(1375, 738, 136, 46);
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("View Transaction By id :");
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			lblNewLabel.setBounds(24, 512, 231, 36);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField.setBounds(265, 507, 202, 40);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton_2 = new JButton("View");
			CSS.setMouseCursorNormal2(btnNewButton_2);
			btnNewButton_2.setBackground(Color.WHITE);
			btnNewButton_2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					 
					int id = 0;
					
					try {
						
					id = Integer.parseInt(textField.getText());	
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Invalid Id Format... ID Must Be Number");
					
					}finally {
						CSS.setTable(table);
						textField.setText(null);
						
					}	
					
					if(id!=0) {
						
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getTransactionById(id)));
						
						if(table.getRowCount()==0) {
							
							JOptionPane.showMessageDialog(null, "No Record Found With This ID");
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransaction()));
							
						}
						
					} catch (RecordNotFoundException e1) {
						
						e1.printStackTrace();
					}finally {
						CSS.setTable(table);
						textField.setText(null);
						
					}	
						
						
					}
					
					
				}
			});
			btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton_2.setBounds(491, 512, 107, 36);
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton_1 = new JButton("Reset");
			CSS.setMouseCursorBack(btnNewButton_1);
			btnNewButton_1.setBackground(Color.WHITE);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransaction()));
					} catch (RecordNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			btnNewButton_1.setBounds(1362, 431, 144, 46);
			contentPane.add(btnNewButton_1);
			
			JPanel panel = new JPanel();
			panel.setForeground(Color.RED);
			panel.setBackground(new Color(204, 255, 204));
			panel.setBackground(new Color(0, 0, 0, 80));
			panel.setBounds(10, 588, 898, 196);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("View Transaction By Date Range ");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(198, 0, 426, 56);
			panel.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
			
			JLabel lblNewLabel_3 = new JLabel("Write Date In YYYY-MM-DD Format");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(270, 49, 283, 36);
			panel.add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 16));
			
			JButton btnNewButton_2_1 = new JButton("View");
			CSS.setMouseCursorNormal2(btnNewButton_2_1);
			btnNewButton_2_1.setBackground(Color.WHITE);
			btnNewButton_2_1.setForeground(Color.BLACK);
			btnNewButton_2_1.setBounds(708, 118, 94, 36);
			panel.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LocalDate s = null;
					LocalDate e1 = null;
					try {
						s = LocalDate.parse(textField_1.getText());
					    e1 = LocalDate.parse(textField_2.getText());
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Invalid Date");
					}finally {
						CSS.setTable(table);
						textField_1.setText(null);
						textField_2.setText(null);
						
					}	
					
					if(s!=null && e1!=null) {
						
						if(s.isAfter(e1)) JOptionPane.showMessageDialog(null, "From Date not should be after To Date...");
						
						else {
							try {
								table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransactionbyDateRange(s, e1)));
								
								if(table.getRowCount()==0) {
									
									JOptionPane.showMessageDialog(null, "No Record Found From the Given Range....");
									
									
								}
								
							} catch (RecordNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
								
							}finally {
								CSS.setTable(table);
								textField_1.setText(null);
								textField_2.setText(null);
								
							}	
						}
						
					}
					
					
					
				}
			});
			btnNewButton_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			
			textField_2 = new JTextField();
			textField_2.setBounds(440, 111, 202, 40);
			panel.add(textField_2);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_2_1 = new JLabel("To  :");
			lblNewLabel_2_1.setBounds(392, 122, 39, 25);
			panel.add(lblNewLabel_2_1);
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			
			JLabel lblNewLabel_2 = new JLabel("From :");
			lblNewLabel_2.setBounds(76, 122, 62, 25);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			
			textField_1 = new JTextField();
			textField_1.setBounds(148, 111, 202, 40);
			panel.add(textField_1);
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Sort Transactions By :");
			lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 20));
			lblNewLabel_4.setBounds(36, 472, 249, 30);
			contentPane.add(lblNewLabel_4);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
			comboBox.addItem("Total Price");
			comboBox.addItem("Quantity");
			comboBox.addItem("Purchase Date");
			comboBox.addItem("GST Percentage");
			comboBox.setBounds(265, 460, 202, 36);
			contentPane.add(comboBox);
			
			JButton btnNewButton_3 = new JButton("Sort");
			CSS.setMouseCursorNormal2(btnNewButton_3);
			btnNewButton_3.setBackground(Color.WHITE);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String sortingValue = (String) comboBox.getSelectedItem();
					 
					   
					 
						try {
                             
							if(sortingValue.equals("Total Price"))
							table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransactionByTotalPrice()));
							
							else if(sortingValue.equals("Quantity"))
								table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransactionByQuantity()));
							
							else if(sortingValue.equals("Purchase Date"))
								table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransactionByPurchaseDate()));
							
							else
								table.setModel(DbUtils.resultSetToTableModel(admin.getAllTransactionByGSTPercentage()));
							
							
						} catch (RecordNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					
				}
			});
			btnNewButton_3.setFont(new Font("Bahnschrift", Font.BOLD, 19));
			btnNewButton_3.setBounds(491, 459, 107, 36);
			contentPane.add(btnNewButton_3);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setBounds(868, 425, 519, 395);
			
			ImageIcon icon = new ImageIcon(getClass().getResource("/Images/AdminPage/admintransactions.png"));
			icon = MainPage.setImgeSize(600, 400, icon);
			
			lblNewLabel_5.setIcon(icon);
			
			contentPane.add(lblNewLabel_5);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
