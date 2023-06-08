package com.masai.BuyerUi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class BuyerProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;
	BuyerDaoImpl buyerdao = new BuyerDaoImpl();
	private JTextField textField;
	private JTextField textField_1;
	static BuyerProducts frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerProducts();
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
	public BuyerProducts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1449, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 34, 1399, 216);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new String[] {
					"product_id", "product_name", "price_per_piece", "seller_id", "seller_name", "quantity", "description", "sold_status", "category_id"
				}, getDefaultCloseOperation()
			));
		
		table.setModel(DbUtils.resultSetToTableModel(buyerdao.getAllProductForSell()));
		CSS.setTable(table);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Clothing");
		comboBox.addItem("Electronics");
		comboBox.addItem("Grocery");
		comboBox.addItem("Miscellaneous");
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		comboBox.setBounds(510, 328, 157, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("View Product By Category : ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(222, 322, 296, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				table.setModel(DbUtils.resultSetToTableModel(buyerdao.getAllProductsByCategory(item)));
				CSS.setTable(table);
				
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No Record Found");
					table.setModel(DbUtils.resultSetToTableModel(buyerdao.getAllProductForSell()));
					CSS.setTable(table);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(692, 325, 118, 35);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(26, 406, 784, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Buy Product ?");
		lblNewLabel_1.setBounds(346, 26, 128, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Product Id to Buy :");
		lblNewLabel_1_1.setBounds(10, 81, 264, 43);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setBounds(265, 82, 136, 41);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				int id = 0;
				int quantity = 0;
				
				try {
					
					id = Integer.parseInt(textField.getText());
					quantity = Integer.parseInt(textField_1.getText());
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Id must be in Number Format");
					
					
				}
				
				
				
				if(id!=0) {
					
					if(quantity > 10) {
						
						JOptionPane.showMessageDialog(null, "Quantity Not More Than 10");
					}else {
						
						table.setModel(DbUtils.resultSetToTableModel(buyerdao.getProductsByProductId(id)));
						
						if(table.getRowCount()==0)
							JOptionPane.showMessageDialog(null, "No Product Found with With id");
						
						else {
							String ans = buyerdao.purchaseItem(id, quantity);
							JOptionPane.showMessageDialog(null,ans);
							
							frame.setVisible(false);
							BuyerTransactions buyert = new BuyerTransactions();
							buyert.main(null);
							
						}
						
					}
					
				
				}
				textField.setText(null);
				textField_1.setText(null);
				
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(346, 133, 128, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Quantity :");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(446, 81, 264, 43);
		panel.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(623, 81, 136, 42);
		panel.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations buyerop = new BuyerOperations(new BuyerDaoImpl().loginBuyer(BuyerOperations.buyer.getBuyerUserName(),BuyerOperations.buyer.getPassword()));
				buyerop.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnNewButton_2.setBounds(1315, 565, 110, 40);
		contentPane.add(btnNewButton_2);
	}
}
