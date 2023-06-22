package com.masai.SellerUi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.BuyerDao;
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
import java.awt.Color;
import javax.swing.SwingConstants;

public class SellerViewProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;
	SellerDao sellerDao = new SellerDaoImpl();
	static SellerViewProducts frame;
	static String sellerUsername = SellerOperations.seller.getSellerUserName();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static int id = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerViewProducts();
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
	public SellerViewProducts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1554, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 35, 1480, 376);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new String[] { "product_id", "product_name", "price_per_piece",
				"seller_id", "seller_name", "quantity", "description", "sold_status", "category_id" },
				getDefaultCloseOperation()));

		table.setModel(DbUtils.resultSetToTableModel(sellerDao.getAllSellerProducts(sellerUsername)));
		CSS.setTable(table);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Clothing");
		comboBox.addItem("Electronics");
		comboBox.addItem("Grocery");
		comboBox.addItem("Miscellaneous");
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		comboBox.setBounds(318, 513, 157, 30);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("View Product By Category : ");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel.setBounds(26, 510, 296, 40);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("View");
		CSS.setMouseCursorNormal2(btnNewButton_1);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				table.setModel(
						DbUtils.resultSetToTableModel(sellerDao.getSellerAllProductsByCategory(item, sellerUsername)));
				CSS.setTable(table);

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "No Record Found");
					table.setModel(DbUtils.resultSetToTableModel(sellerDao.getAllSellerProducts(sellerUsername)));
					CSS.setTable(table);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_1.setBounds(483, 510, 118, 35);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton_2);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerOperations sellerOperations = new SellerOperations(sellerDao.loginSeller(
						SellerOperations.seller.getSellerUserName(), SellerOperations.seller.getPassword()));
				sellerOperations.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton_2.setBounds(1396, 681, 110, 40);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Reset");
		CSS.setMouseCursorBack(btnNewButton_3);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.setModel(DbUtils.resultSetToTableModel(sellerDao.getAllSellerProducts(sellerUsername)));
				CSS.setTable(table);

			}
		});
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton_3.setBounds(1409, 435, 97, 40);
		contentPane.add(btnNewButton_3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(26, 596, 587, 125);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Update Product");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1.setBounds(215, 9, 270, 49);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Product ID");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_2.setBounds(31, 68, 148, 47);
		panel.add(lblNewLabel_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_4.setBounds(157, 68, 188, 47);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Go To Update Page");
		CSS.setMouseCursorNormal2(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Empty Field");
					return;
				}

				try {

					id = Integer.parseInt(textField_4.getText());

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Product ID must be in number format");
					return;

				}

				List<Integer> list = sellerDao.getSellerProductsID(sellerUsername);

				if (list.indexOf(id) < 0) {

					JOptionPane.showMessageDialog(null, "This Product ID is not belong to you");
					return;

				}

				frame.setVisible(false);
				SellerProductUpdate.main(null);

			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton.setBounds(368, 72, 209, 39);
		panel.add(btnNewButton);

		JButton btnNewButton_4 = new JButton("Sort Products By Quantity");
		CSS.setMouseCursorNormal2(btnNewButton_4);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.setModel(
						DbUtils.resultSetToTableModel(sellerDao.getAllSellerProductsOrderByPrice(sellerUsername)));
				CSS.setTable(table);

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "No Record Found");
					table.setModel(DbUtils.resultSetToTableModel(sellerDao.getAllSellerProducts(sellerUsername)));
					CSS.setTable(table);

				}

			}
		});

		btnNewButton_4.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton_4.setBounds(847, 531, 373, 52);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("Sort Products By Price");
		CSS.setMouseCursorNormal2(btnNewButton_4_1);
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.setModel(
						DbUtils.resultSetToTableModel(sellerDao.getAllSellerProductsOrderByQuantity(sellerUsername)));
				CSS.setTable(table);

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "No Record Found");
					table.setModel(DbUtils.resultSetToTableModel(sellerDao.getAllSellerProducts(sellerUsername)));
					CSS.setTable(table);

				}

			}
		});
		btnNewButton_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton_4_1.setBounds(847, 627, 373, 52);
		contentPane.add(btnNewButton_4_1);

	}
}
