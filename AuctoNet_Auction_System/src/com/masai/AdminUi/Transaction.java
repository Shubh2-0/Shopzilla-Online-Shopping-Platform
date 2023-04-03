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

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
		setBounds(100, 100, 1726, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 39, 1516, 149);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					AdminOperations jk = new AdminOperations();
					jk.main(null);
					
				}
			});
			
			CSS.setTable(table);
			
			
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnNewButton.setBounds(1340, 619, 190, 46);
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("View Transaction By id :");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblNewLabel.setBounds(45, 255, 231, 36);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("View Transaction By Date Range ");
			lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(127, 386, 306, 46);
			contentPane.add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField.setBounds(296, 255, 202, 40);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton_2 = new JButton("View");
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
			btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			btnNewButton_2.setBounds(508, 255, 142, 36);
			contentPane.add(btnNewButton_2);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField_1.setColumns(10);
			textField_1.setBounds(180, 489, 202, 40);
			contentPane.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField_2.setColumns(10);
			textField_2.setBounds(180, 557, 202, 40);
			contentPane.add(textField_2);
			
			JButton btnNewButton_2_1 = new JButton("View");
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
			btnNewButton_2_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(431, 521, 142, 36);
			contentPane.add(btnNewButton_2_1);
			
			JLabel lblNewLabel_2 = new JLabel("From :");
			lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(88, 484, 112, 40);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("To  :");
			lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(88, 570, 112, 40);
			contentPane.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_3 = new JLabel("Write Date In YYYY-MM-DD Format");
			lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(137, 442, 271, 37);
			contentPane.add(lblNewLabel_3);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
