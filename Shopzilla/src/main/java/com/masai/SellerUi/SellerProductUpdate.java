package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.ProductDao;
import com.masai.Dao.ProductDaoImpl;
import com.masai.Dto.Product;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerProductUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static int id;
	static ProductDao productDao = new ProductDaoImpl();
	static Product product;
	static SellerProductUpdate frame;

	/**
	 * Launch the application.
	 */

	static {

		id = SellerViewProducts.id;
		System.out.println(id);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerProductUpdate();

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
	public SellerProductUpdate() {

		product = productDao.getProductById(id);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Details Update");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblNewLabel.setBounds(169, 10, 443, 80);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1.setBounds(51, 116, 241, 37);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setText(product.getProductName());
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField.setBackground(new Color(216, 191, 216));
		textField.setBounds(282, 96, 387, 53);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Price Per Unit");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(51, 202, 241, 37);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(51, 304, 241, 37);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Description");
		lblNewLabel_1_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1_3.setBounds(51, 464, 241, 37);
		contentPane.add(lblNewLabel_1_3);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(60);
		textArea.setTabSize(6);
		textArea.setText(product.getProductDescription());
		textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textArea.setBackground(new Color(245, 222, 179));
		textArea.setBounds(282, 464, 397, 171);
		contentPane.add(textArea);

		textField_1 = new JTextField();
		textField_1.setText(product.getProductPrice() + "");
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_1.setBackground(new Color(216, 191, 216));
		textField_1.setColumns(10);
		textField_1.setBounds(282, 195, 387, 53);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText(product.getProductQuantity() + "");
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_2.setBackground(new Color(216, 191, 216));
		textField_2.setColumns(10);
		textField_2.setBounds(282, 294, 387, 53);
		contentPane.add(textField_2);

		JButton btnBack = new JButton("Back");
		CSS.setMouseCursorBack(btnBack);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnBack.setBounds(504, 668, 208, 59);
		contentPane.add(btnBack);

		JRadioButton rdbtnNotApplicable = new JRadioButton("Not Applicable");

		rdbtnNotApplicable.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnNotApplicable.setBackground(new Color(216, 191, 216));
		rdbtnNotApplicable.setBounds(476, 380, 179, 53);
		contentPane.add(rdbtnNotApplicable);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Applicable");

		rdbtnNotApplicable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNotApplicable.isSelected()) {

					rdbtnNewRadioButton.setSelected(false);
				}

			}
		});

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNotApplicable.setSelected(false);
				}

			}
		});

		rdbtnNewRadioButton.setBackground(new Color(216, 191, 216));
		rdbtnNewRadioButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(282, 380, 137, 53);
		contentPane.add(rdbtnNewRadioButton);

		if (product.getReturnPolicy() == 1) {

			rdbtnNewRadioButton.setSelected(true);
			rdbtnNotApplicable.setSelected(false);
		}

		if (product.getReturnPolicy() == 0) {

			rdbtnNewRadioButton.setSelected(false);
			rdbtnNotApplicable.setSelected(true);
		}

		JLabel lblNewLabel_1_2_1 = new JLabel("Return");
		lblNewLabel_1_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBounds(51, 390, 241, 37);
		contentPane.add(lblNewLabel_1_2_1);

		JButton btnUpdateProduct = new JButton("Update Product");
		CSS.setMouseCursorLogin(btnUpdateProduct);
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = textField.getText();
				double amount;

				try {

					amount = Double.parseDouble(textField_1.getText());

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Price must be in number format");
					textField_1.setText(product.getProductPrice() + "");
					return;
				}

				if (amount <= 10 || amount > 2000000) {

					JOptionPane.showMessageDialog(null,
							"Please ensure that the price is greater than 10 rupees and less than 2,000,000 rupees");
					textField_1.setText(product.getProductPrice() + "");
					return;
				}

				int quantity = 0;

				try {

					quantity = Integer.parseInt(textField_2.getText());

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Quantity must be in number format");
					textField_2.setText(product.getProductQuantity() + "");
					return;
				}

				System.out.println(quantity);

				if (quantity <= 2) {
					System.out.println(quantity);
					JOptionPane.showMessageDialog(null, "Quantity must be in more than 2 Units");
					textField_2.setText(product.getProductQuantity() + "");
					return;
				}

				String description = textArea.getText();

				int returnPolicy = 1;

				if (rdbtnNotApplicable.isSelected())
					returnPolicy = 0;

				if (!name.equals(""))
					product.setProductName(name);
				product.setProductPrice(amount);
				product.setProductDescription(description);
				product.setProductQuantity(quantity);
				product.setReturnPolicy(returnPolicy);

				if (productDao.updateProductBySeller(product, id)) {

					JOptionPane.showMessageDialog(null,
							"Product update successful. Note that any empty fields will retain their previous values");
					frame.setVisible(false);
					SellerViewProducts.main(null);

				}

				else {

					JOptionPane.showMessageDialog(null,
							"Something went wrong try to uypdate product some times letter");
					frame.setVisible(false);
					SellerViewProducts.main(null);

				}

			}
		});

		btnUpdateProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnUpdateProduct.setBounds(102, 668, 241, 59);
		contentPane.add(btnUpdateProduct);
	}
}
