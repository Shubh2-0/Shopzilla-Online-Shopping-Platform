package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.masai.CSS.CSS;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dao.TransactionDao;
import com.masai.Dao.TransactionDaoImpl;
import com.masai.Dto.*;
import com.masai.Exceptions.RecordNotFoundException;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BuyerTransactions extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	static BuyerTransactions frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	static BuyerDao buyerDao = new BuyerDaoImpl();
	static Buyer buyer = BuyerOperations.buyer;
	private JButton btnReset;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JTextField textField_2;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;
	static TransactionDao transactionDao = new TransactionDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerTransactions();
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
	public BuyerTransactions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1554, 837);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(45, 34, 1461, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		table.setModel(DbUtils.resultSetToTableModel(new BuyerDaoImpl().viewAllTransactions()));
		
		if(table.getRowCount()==0) {
			JOptionPane.showMessageDialog(null, "No Transaction Found....");
		}
		CSS.setTable(table);
		
		btnNewButton = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations buyerop = new BuyerOperations(new BuyerDaoImpl().loginBuyer(BuyerOperations.buyer.getBuyerUserName(),BuyerOperations.buyer.getPassword()));
				buyerop.main(null);
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.setBounds(1354, 733, 151, 46);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(37, 583, 898, 196);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("View Transaction By Date Range ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel.setBounds(198, 0, 426, 56);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(440, 111, 202, 40);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(148, 111, 202, 40);
		panel.add(textField_1);
		
		
		lblNewLabel_1 = new JLabel("Write Date In YYYY-MM-DD Format");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_1.setBounds(270, 49, 283, 36);
		panel.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("View");
		CSS.setMouseCursorNormal2(btnNewButton_2);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				LocalDate s = null;
				LocalDate e1 = null;
				try {
					s = LocalDate.parse(textField.getText());
				    e1 = LocalDate.parse(textField_1.getText());
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Invalid Date");
				}finally {
					CSS.setTable(table);
					textField_1.setText(null);
					textField.setText(null);
					
				}	
				
				if(s!=null && e1!=null) {
					
					if(s.isAfter(e1)) JOptionPane.showMessageDialog(null, "From Date not should be after To Date...");
					
					else {
						try {
							table.setModel(DbUtils.resultSetToTableModel(buyerDao.getBuyerAllTransactionbyDateRange(s, e1, buyer.getBuyerUserName())));
							
							if(table.getRowCount()==0) {
								
								JOptionPane.showMessageDialog(null, "No Record Found From the Given Range....");
								
								
							}
							
						} catch (RecordNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
							
						}finally {
							CSS.setTable(table);
							textField_1.setText(null);
							textField.setText(null);
							
						}	
					}
					
				}
				
				
				
			}
				
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_2.setBounds(697, 111, 94, 36);
		panel.add(btnNewButton_2);
		
		
		
		lblNewLabel_2 = new JLabel("To  :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_2.setBounds(392, 122, 39, 25);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("From :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_3.setBounds(76, 122, 62, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sort Transactions By :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_4.setBounds(45, 462, 249, 30);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		comboBox.setBounds(272, 459, 180, 36);
		contentPane.add(comboBox);
		comboBox.addItem("Total Price");
		comboBox.addItem("Quantity");
		comboBox.addItem("Purchase Date");
		comboBox.addItem("GST Percentage");
		
		JButton btnNewButton_3 = new JButton("Sort");
		CSS.setMouseCursorNormal2(btnNewButton_3);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sortingValue = (String) comboBox.getSelectedItem();
				 
				   
				 
				try {
                     
					if(sortingValue.equals("Total Price"))
					table.setModel(DbUtils.resultSetToTableModel(buyerDao.getBuyerAllTransactionByTotalPrice(buyer.getBuyerUserName())));
					
					else if(sortingValue.equals("Quantity"))
						table.setModel(DbUtils.resultSetToTableModel(buyerDao.getBuyerAllTransactionByQuantity(buyer.getBuyerUserName())));
					
					else if(sortingValue.equals("Purchase Date"))
						table.setModel(DbUtils.resultSetToTableModel(buyerDao.getBuyerAllTransactionByPurchaseDate(buyer.getBuyerUserName())));
					
					else
						table.setModel(DbUtils.resultSetToTableModel(buyerDao.getBuyerAllTransactionByGSTPercentage(buyer.getBuyerUserName())));
					
					
				} catch (RecordNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
				
			}
		});
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnNewButton_3.setBounds(525, 459, 85, 33);
		contentPane.add(btnNewButton_3);
		
		btnReset = new JButton("Reset");
		CSS.setMouseCursorBack(btnReset);
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(DbUtils.resultSetToTableModel(new BuyerDaoImpl().viewAllTransactions()));
				
				
			}
		});
		btnReset.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnReset.setBounds(1354, 444, 151, 46);
		contentPane.add(btnReset);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 127, 80));
		panel_1.setBounds(973, 583, 331, 196);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Return Product ?");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_5.setBounds(57, 10, 218, 35);
		panel_1.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_2.setBounds(221, 80, 84, 35);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Enter Transaction ID :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 90, 217, 25);
		panel_1.add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("Go To Return Page");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int id = 0;
				
				try {
					
					id = Integer.parseInt(textField_2.getText()) ;
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Transaction ID must be in number");
					return;
				}
				
				List<Integer> list = transactionDao.getAllTransactionIdByParticularBuyer(buyer.getBuyerUserName());
				
			   
				if(  list.indexOf(id) < 0) {
					
					JOptionPane.showMessageDialog(null, "The transaction ID you provided does not belong to you");
					return;
					
				}else {
					
					ReturnProduct returnProduct = new ReturnProduct();
					
					List<String> l = transactionDao.getProductNameAndProductIdAndQuantityById(id);
					
					BuyerReturnProduct.quantity = Integer.parseInt(l.get(2));
					returnProduct.setBuyerId(buyer.getBuyerUserName());
					returnProduct.setBuyerName(buyer.getFirstName()+" "+buyer.getLastName());
					returnProduct.setProductName(l.get(0));
					returnProduct.setProdunctId(Integer.parseInt(l.get(1)));
					
					BuyerReturnProduct.returnProduct = returnProduct;
					
					
					
				}
				
			
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_1.setBounds(57, 144, 246, 42);
		panel_1.add(btnNewButton_1);
		
	
	}
}
