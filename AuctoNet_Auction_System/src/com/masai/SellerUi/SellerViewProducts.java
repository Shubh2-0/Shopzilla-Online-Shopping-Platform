package com.masai.SellerUi;

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
import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
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

public class SellerViewProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;
	SellerDao sellerDao = new SellerDaoImpl();
	static SellerViewProducts frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerViewProducts();
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
	public SellerViewProducts() {
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
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		comboBox.setBounds(514, 325, 157, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("View Product By Category : ");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 22));
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
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_1.setBounds(679, 322, 118, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations buyerop = new BuyerOperations(new BuyerDaoImpl().loginBuyer(BuyerOperations.buyer.getBuyerUserName(),BuyerOperations.buyer.getPassword()));
				buyerop.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton_2.setBounds(1315, 565, 110, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				table.setModel(DbUtils.resultSetToTableModel(buyerdao.getAllProductForSell()));
				CSS.setTable(table);
				
			}
		});
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_3.setBounds(1307, 320, 97, 40);
		contentPane.add(btnNewButton_3);
	}
}
