package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerAddBalance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static double balance ;
	static String username;
	static JFrame frame;
	static BuyerDao buyerDao = new BuyerDaoImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new BuyerAddBalance();
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
	public BuyerAddBalance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField.setBounds(258, 80, 370, 54);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Amount");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel.setBounds(73, 103, 175, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				String b = textField.getText();
				double amount = 0.0;
				try {
					
					amount = Double.parseDouble(b);
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Invalid amount entered");
					textField.setText("");
					return;
				}
				
				if(amount < 5000) {
					
					JOptionPane.showMessageDialog(null, "Deposit a minimum amount of 5000 or more, taking into account the maximum balance limit of 1,000,000.");
					return;
				}
				
				if(amount+balance >= 1000000) {
					double remaining = 1000000 - balance;
					JOptionPane.showMessageDialog(null, "The maximum account balance limit is 1,000,000. Please deposit an amount ranging from 5,000 to "+remaining);
					
					return;
					
				}
				
				if(buyerDao.addAmountToBuyerBalance(amount+balance, username)) {
					
					JOptionPane.showMessageDialog(null, "Blaance added successfully");
					frame.setVisible(false);
					BuyerOperations.main(null);
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton.setBounds(367, 157, 127, 47);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerOperations.main(null);
				
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnBack.setBounds(560, 265, 98, 54);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(100, 151, 269, 178);
		contentPane.add(lblNewLabel_1);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/BuyerMain/buyeraddbalance.png"));
		Image iPage1 = icon1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(iPage1);
		lblNewLabel_1.setIcon(icon1);
		
	}
}
