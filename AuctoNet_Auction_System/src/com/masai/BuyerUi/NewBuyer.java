package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.CommanCode.Common;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dto.Buyer;
import com.masai.Dto.*;
import com.masai.MainUi.MainPage;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;

public class NewBuyer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JPasswordField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JTextArea textField_5;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JLabel lblNewLabel_7;
	static Buyer buyer;
	static JFrame frame;
	static final BuyerDao bDao = new BuyerDaoImpl();
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewBuyer();
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
	public NewBuyer() {
		setBackground(new Color(128, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 777);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("Button.disabledShadow"));
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 1100, 740);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField.setBounds(174, 131, 333, 45);
		panel.add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("Firstname");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1.setBounds(31, 146, 133, 30);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Lastname");
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_2.setBounds(588, 146, 133, 30);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_1.setColumns(10);
		textField_1.setBounds(731, 131, 333, 45);
		panel.add(textField_1);

		textField_3 = new JPasswordField();
		textField_3.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_3.setColumns(10);
		textField_3.setBounds(174, 224, 333, 45);
		panel.add(textField_3);

		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_4.setBounds(31, 242, 133, 30);
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_4.setColumns(10);
		textField_4.setBounds(731, 224, 333, 45);
		panel.add(textField_4);

		textField_5 = new JTextArea();
		textField_5.setLineWrap(true);
		textField_5.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(174, 308, 817, 216);
		panel.add(textField_5);

		lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_5.setBounds(588, 242, 133, 30);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(Color.PINK);
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_6.setBounds(31, 310, 133, 30);
		panel.add(lblNewLabel_6);

		btnNewButton = new JButton("Create Account");
		btnNewButton.setBackground(Color.WHITE);
		CSS.setMouseCursorLogin(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String firstName = Common.nameFormat(textField.getText()).trim();
				String lastName = Common.nameFormat(textField_1.getText()).trim();
				String password = textField_3.getText().trim();
				String mobileNo = textField_4.getText().trim();
				String address = textField_5.getText().trim();
				String balance = textField_2.getText().trim();

				if (firstName.equals("") || lastName.equals("") || password.equals("") || mobileNo.equals("")
						|| address.equals("")) {

					JOptionPane.showMessageDialog(null,
							"kindly provide the necessary information in all the required fields");
					return;

				}

				if (Common.checkPasswordLength(password)) {

					JOptionPane.showMessageDialog(null,
							"Your password should be between 7 and 12 characters in length to meet the security requirements");
					return;

				}

				if (Common.checkPasswordHaveSpace(password)) {

					JOptionPane.showMessageDialog(null,
							"Keep your password free from more than 4 spaces, as it is recommended for better password security");
					return;

				}

				if (Common.checkPhoneNumber(mobileNo)) {

					JOptionPane.showMessageDialog(null,
							"Phone numbers should only contain numeric digits. Avoid using alphabetic or special characters");
					return;

				}

				if (mobileNo.length() != 10) {

					JOptionPane.showMessageDialog(null, "Provide a proper number without coountry code");
					return;

				}

				if (Common.checkBalance(balance)) {

					JOptionPane.showMessageDialog(null, "Invalid balnce enter");
					textField_2.setText("");
					return;

				}

				int b = Integer.parseInt(balance);

				if (b <= 5000 || b >= 1000000) {

					JOptionPane.showMessageDialog(null,
							"Ensure that the balance falls within the range of 5000 to 1000000");
					return;

				}

				if (buyer != null) {
					buyer = null;
					JOptionPane.showMessageDialog(null,
							"Please choose a different username as the current one is already taken");

					return;

				} else {
					String username = firstName + "_" + (int) (Math.random() * 5000);
					JOptionPane.showMessageDialog(null,
							"Congratulations! Your account has been successfully created\n" + "Your username : "
									+ username + "\n " + "Your password : " + password + "\n"
									+ "Please ensure to remember your username , password and keep it in a safe place\n"
									+ "You will need it to log in to the application");
					buyer = new Buyer(username, password, firstName, lastName, mobileNo, address, b);
					bDao.registerNewBuyer(buyer);
					frame.setVisible(false);
					BuyerMain.main(null);

				}

			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(459, 634, 218, 45);
		panel.add(btnNewButton);

		lblNewLabel_7 = new JLabel("Welcome To Actonet Auction System");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
		lblNewLabel_7.setForeground(SystemColor.window);
		lblNewLabel_7.setBounds(236, 10, 695, 102);
		panel.add(lblNewLabel_7);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_2.setColumns(10);
		textField_2.setBounds(431, 553, 333, 45);
		panel.add(textField_2);

		JLabel lblNewLabel_6_1 = new JLabel("Wallet Balnce");
		lblNewLabel_6_1.setForeground(Color.PINK);
		lblNewLabel_6_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_6_1.setBounds(274, 559, 193, 30);
		panel.add(lblNewLabel_6_1);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(928, 662, 149, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(Color.WHITE);
		CSS.setMouseCursorBack(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				BuyerMain.main(null);
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		btnNewButton_2.setBounds(10, 10, 128, 53);
		panel_1.add(btnNewButton_2);

		lblNewLabel = new JLabel("Welcome To  AuctoNet Auction System");
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 0, 1203, 845);
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/Images/BuyerMain/newbuyer.png"));
		icon4 = MainPage.setImgeSize(2000, 12000, icon4);
		lblNewLabel.setIcon(icon4);

		contentPane.add(lblNewLabel);

		btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_1.setBounds(835, 789, 218, 45);
		contentPane.add(btnNewButton_1);
	}
}
