package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerReopenAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static SellerDao sellerDao = new SellerDaoImpl();
	static SellerReopenAccount frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerReopenAccount();
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
	public SellerReopenAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrDearSellerIf = new JTextArea();
		txtrDearSellerIf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtrDearSellerIf.setText(
				"\r\n Dear Seller,\r\n\r\n If your account remains closed for more than 3 months from the date of deletion, \r\n it will automatically reopen. No additional steps required.\r\n\r\n Best regards.");
		txtrDearSellerIf.setBounds(13, 450, 537, 147);
		contentPane.add(txtrDearSellerIf);

		JLabel lblNewLabel = new JLabel("Account Reactivation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(141, 23, 409, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1.setBounds(31, 119, 160, 41);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField.setBounds(210, 105, 378, 42);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(210, 189, 378, 42);
		contentPane.add(textField_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(31, 203, 160, 41);
		contentPane.add(lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(210, 274, 378, 42);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(31, 303, 233, 41);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("Reactivate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = textField.getText();
				String password = textField_1.getText();
				String confirmPassword = textField_2.getText();

				if (username.equals("") || password.equals("") || confirmPassword.equals("")) {

					JOptionPane.showMessageDialog(null, "All fields are necesarry to field");
					return;

				}

				else if (!password.equals(confirmPassword)) {

					JOptionPane.showMessageDialog(null, "Password and Confirm Password is not matching");
					return;

				}

				else {

					if (sellerDao.reopenSeller(username, password)) {

						JOptionPane.showMessageDialog(null,
								"We are delighted to inform you that your account has been successfully reopened.\n"
										+ "You can now resume selling and enjoy the benefits of our platform.");
						frame.setVisible(false);
						SellerMain.main(null);

					} else {

						JOptionPane.showMessageDialog(null,
								"We apologize, but no seller account matching the provided username and password was found for reopening.\n"
										+ "Please ensure you have entered the correct credentials.");

					}

				}

			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton.setBounds(210, 373, 140, 41);
		contentPane.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerMain.main(null);
			}
		});
		btnCancel.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnCancel.setBounds(448, 373, 140, 41);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1_2_1 = new JLabel("Confirm");
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(33, 273, 233, 41);
		contentPane.add(lblNewLabel_1_2_1);
	}
}
