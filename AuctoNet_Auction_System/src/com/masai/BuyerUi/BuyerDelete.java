package com.masai.BuyerUi;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class BuyerDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	static String username;
	static String password;
	static BuyerDao buyerDao = new BuyerDaoImpl();
	static BuyerDelete frame;
	static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerDelete();
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
	public BuyerDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 732);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(142, 10, 198, 163);
		contentPane.add(lblNewLabel);
		
		
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/BuyerMain/deleteuser.png"));
		Image iPage1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(iPage1);
		lblNewLabel.setIcon(icon1);
		
		JLabel lblNewLabel_1 = new JLabel("Account Deletion for Buyers");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel_1.setBounds(235, 49, 535, 76);
		contentPane.add(lblNewLabel_1);
				
		
		JLabel lblNewLabel_2_1 = new JLabel("Please note that once your account is deleted, it cannot be recovered");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 518, 889, 59);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("\nHowever, if you change your mind,"
				+ "you have the option to restore your account within a 30-day period.");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(10, 565, 945, 59);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2.setBounds(45, 186, 163, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Password");
		lblNewLabel_2_3.setForeground(SystemColor.desktop);
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2_3.setBounds(45, 263, 163, 31);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Confirm Password");
		lblNewLabel_2_4.setForeground(SystemColor.desktop);
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2_4.setBounds(46, 347, 224, 31);
		contentPane.add(lblNewLabel_2_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField.setBounds(321, 171, 404, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(321, 249, 404, 46);
		contentPane.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(321, 332, 404, 46);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Delete Acount");
		btnNewButton.setBackground(Color.WHITE);
		CSS.setMouseCursorDelete(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String tempUsername = textField.getText();
 				String tempPassword = textField_1.getText();
 				String confirmPassword = textField_2.getText();
 			
				
 				if(username.equals("") || tempPassword.equals("") || confirmPassword.equals("")) {
 					
 					JOptionPane.showMessageDialog(null,"All field all necessary to field");
 					return;
 					
 				}
 				
 				if(!confirmPassword.equals(tempPassword)) {
 					
 					JOptionPane.showMessageDialog(null, "Password and Confirm Password is not matching");
 					return;
 					
 				}
 				
 				
 				if(!username.equals(tempUsername) || !password.equals(tempPassword)) {
 					
 					JOptionPane.showMessageDialog(null, "Invalid username and password");
 					return;
 					
 				}
 				
 				
 				if(buyerDao.deleteBuyer(tempUsername, confirmPassword) && buyerDao.hideTransactions(username,name) ) {
 					
 					 LocalDate currentDate = LocalDate.now();
 					 
 					 currentDate.plusDays(30);
 					 
 			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
 			        String formattedDate = currentDate.format(formatter);
 			        
 					
 					
 					JOptionPane.showMessageDialog(null, "Your account has been successfully deleted.\nThank you for being a part of our platform. We hope to see you again in the future"
 							+ "\nYou can restore your acount till "+formattedDate);
 					BuyerMain.buyer = null;
 					frame.setVisible(false);
 					BuyerMain.main(null);
 					
 				}else {
 					
 					JOptionPane.showMessageDialog(null, "Something went wrong");
 					
 				}
 				
 				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(420, 418, 205, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCancelDeletion = new JButton("Cancel Deletion ");
		btnCancelDeletion.setBackground(Color.WHITE);
		CSS.setMouseCursorNormal2(btnCancelDeletion);
		
		
		btnCancelDeletion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations.main(null);
			}
		});
		btnCancelDeletion.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnCancelDeletion.setBounds(641, 639, 284, 46);
		contentPane.add(btnCancelDeletion);
		
	
		
		
		
	}
}
