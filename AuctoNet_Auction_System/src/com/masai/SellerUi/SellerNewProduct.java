package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.ProductDao;
import com.masai.Dao.ProductDaoImpl;
import com.masai.Dto.Product;
import com.masai.Dto.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerNewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	static Product product;
	static ProductDao productDao = new ProductDaoImpl();
	static SellerNewProduct frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerNewProduct();
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
	public SellerNewProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 631);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New Products");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel.setBounds(402, 10, 376, 65);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1.setBounds(29, 121, 186, 45);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField.setBounds(256, 109, 376, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Price Per Unit");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1_2.setBounds(29, 217, 186, 45);
		contentPane.add(lblNewLabel_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_2.setColumns(10);
		textField_2.setBounds(256, 201, 238, 45);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1_3 = new JLabel("Product Description");
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1_3.setBounds(29, 393, 230, 65);
		contentPane.add(lblNewLabel_1_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_1.setColumns(10);
		textField_1.setBounds(858, 109, 144, 45);
		contentPane.add(textField_1);

		JLabel lblNewLabel_1_1 = new JLabel("Quantity\r\n");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(734, 121, 129, 45);
		contentPane.add(lblNewLabel_1_1);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textArea.setBounds(258, 393, 411, 165);
		contentPane.add(textArea);

		JCheckBox chckbxNewCheckBox = new JCheckBox("YES");

		chckbxNewCheckBox.setBackground(new Color(216, 191, 216));
		chckbxNewCheckBox.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		chckbxNewCheckBox.setBounds(871, 223, 66, 35);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNo = new JCheckBox("NO");
		chckbxNo.setBackground(new Color(216, 191, 216));
		chckbxNo.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		chckbxNo.setBounds(874, 273, 77, 35);
		contentPane.add(chckbxNo);

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxNewCheckBox.isSelected()) {
					chckbxNo.setSelected(false);
				}

			}
		});

		chckbxNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxNo.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
				}

			}
		});

		JLabel lblNewLabel_1_2_1 = new JLabel("Return Policy");
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1_2_1.setBounds(686, 244, 186, 45);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Category\r\n");
		lblNewLabel_1_2_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1_2_2.setBounds(29, 297, 186, 45);
		contentPane.add(lblNewLabel_1_2_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 139));
		comboBox.setBackground(new Color(216, 191, 216));
		comboBox.addItem("Clothing");
		comboBox.addItem("Electronics");
		comboBox.addItem("Grocery");
		comboBox.addItem("Miscellaneous");
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		comboBox.setBounds(258, 302, 180, 35);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Add Product");
		CSS.setMouseCursorNormal2(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String name = textField.getText();

				int quantity;

				try {

					quantity = Integer.parseInt(textField_1.getText());

				} catch (Exception e2) {

					JOptionPane.showInternalMessageDialog(null, "Quantity must be in number format");
					textField_1.setText("");
					return;

				}

				if (quantity < 2 || quantity > 4000) {

					JOptionPane.showInternalMessageDialog(null, "Quantity must be between 2 and 400.");
					return;

				}

				double price;

				try {

					price = Double.parseDouble(textField_2.getText());

				} catch (Exception e2) {

					JOptionPane.showInternalMessageDialog(null, "Product Price must be in number format");
					textField_2.setText("");
					return;

				}

				if (quantity < 10 || quantity > 100000) {

					JOptionPane.showInternalMessageDialog(null, "Product Price must be between 10 and 100000");
					return;

				}

				String description = textArea.getText();

				if (description.length() == 0 || description.length() < 20) {

					JOptionPane.showInternalMessageDialog(null,
							"Product Description must be length between 20 and 5000 characters");
					return;

				}

				int returnPolicy = 0;

				if (chckbxNewCheckBox.isSelected()) {
					returnPolicy = 1;
				}

				String category = (String) comboBox.getSelectedItem();

				int categoryId = productDao.getProductIdByCategoryName(category);

				product = new Product();

				product.setProductName(name);
				product.setProductPrice(price);
				product.setSellerId(SellerOperations.seller.getSellerUserName());
				product.setSellerName(
						SellerOperations.seller.getFirstName() + " " + SellerOperations.seller.getLastName());
				product.setProductQuantity(quantity);
				product.setProductDescription(description);
				product.setProductCategoryId(categoryId);
				product.setProductSoldStatus(0);
				product.setReturnPolicy(returnPolicy);

				if (productDao.addProductBySeller(product)) {

					JOptionPane.showMessageDialog(null, "Product is successfully added");
					frame.setVisible(false);
					SellerOperations.main(null);

				} else {

					JOptionPane.showMessageDialog(null, "Something went wrong");

				}

			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		btnNewButton.setBounds(734, 390, 245, 45);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		btnNewButton_1.setBounds(734, 502, 245, 45);
		contentPane.add(btnNewButton_1);
	}
}
