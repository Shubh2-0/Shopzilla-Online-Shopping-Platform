package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.masai.CSS.CSS;
import com.masai.Dao.BuyerDaoImpl;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerTransactions extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	static BuyerTransactions frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerTransactions();
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
		setBounds(100, 100, 1491, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 33, 1429, 223);
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
		table.setModel(DbUtils.resultSetToTableModel(new BuyerDaoImpl().viewAllTransactions()));
		
		if(table.getRowCount()==0) {
			JOptionPane.showMessageDialog(null, "No Transaction Found....");
		}
		CSS.setTable(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations buyerop = new BuyerOperations(new BuyerDaoImpl().loginBuyer(BuyerOperations.buyer.getBuyerUserName(),BuyerOperations.buyer.getPassword()));
				buyerop.main(null);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(1301, 353, 151, 46);
		contentPane.add(btnNewButton);
	}

}
