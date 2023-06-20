package com.masai.BuyerUi;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.BuyerDao;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerReturnProductsTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static BuyerDao buyerDao = BuyerOperations.buyerDao;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerReturnProductsTable frame = new BuyerReturnProductsTable();
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
	public BuyerReturnProductsTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 41, 981, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(DbUtils.resultSetToTableModel(buyerDao.getAllReturnProduct(BuyerOperations.buyer.getBuyerUserName())));
		
		if(table.getRowCount()==0) {
			
			JOptionPane.showMessageDialog(null, "No Record Found");
			
			
		}
		
		CSS.setTable(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		btnNewButton.setBounds(923, 506, 107, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Filter Product By Type");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel.setBounds(61, 375, 309, 43);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("REFUND");
		comboBox.addItem("RETURN");
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		comboBox.setBounds(61, 418, 154, 43);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String type = (String)comboBox.getSelectedItem();
				
				
				table.setModel(DbUtils.resultSetToTableModel(buyerDao.getAllReturnProductOfBuyerByType(BuyerOperations.buyer.getBuyerUserName(), type)));
				
				if(table.getRowCount() == 0) {
					
					JOptionPane.showMessageDialog(null, "No Record Found");
					table.setModel(DbUtils.resultSetToTableModel(buyerDao.getAllReturnProduct(BuyerOperations.buyer.getBuyerUserName())));
					
				}
				
				CSS.setTable(table);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_1.setBounds(243, 418, 113, 43);
		contentPane.add(btnNewButton_1);
		
	}
}
