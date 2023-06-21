package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CommanCode.Common;
import com.masai.Dao.SellerDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerPendingAmount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static double sellerPendingAmount;
	static double sellerIncome;
	SellerDao sellerDao = SellerOperations.sellerDao;
   
	static SellerPendingAmount frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new SellerPendingAmount();
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
	public SellerPendingAmount() {
		sellerPendingAmount = SellerOperations.seller.getPendingAmount();
		sellerIncome = SellerOperations.seller.getIncome();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNoteWhenA = new JTextArea();
		txtrNoteWhenA.setForeground(new Color(139, 0, 0));
		txtrNoteWhenA.setBackground(new Color(255, 182, 193));
		txtrNoteWhenA.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		txtrNoteWhenA.setText("Note: When a buyer purchases a product from a seller, they pay a certain amount for that product, \r\nwhich is added to the seller's income. \r\n\r\nHowever, if the buyer decides to return the product and request a refund, the refunded amount is \r\ncategorized as the \"pending amount.\" This pending amount represents the money that needs \r\nto be refunded to the buyer.");
		txtrNoteWhenA.setBounds(10, 368, 662, 118);
		contentPane.add(txtrNoteWhenA);
		
		JLabel lblNewLabel = new JLabel("Seller's Unpaid Refunds");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel.setBounds(129, 10, 432, 85);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		textField.setBounds(204, 215, 438, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("PAY");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				double amount = 0;
			
				try {
					
					amount = Double.parseDouble(textField.getText());
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Amount must be in number format");
					return;
				}
				
				
				
				if(amount > sellerPendingAmount) {
					
					JOptionPane.showMessageDialog(null, "The amount you have entered is higher than the amount due for payment.");
					return;
					
				}
				
				if(amount > sellerIncome) {
					
					JOptionPane.showMessageDialog(null, "The amount you have entered exceeds your available income.\n"
							+ "Please input an amount between 500 and " +sellerIncome+"to ensure it is within your available funds.");
					return;
					
				}
				
				sellerIncome = sellerIncome - amount;
				sellerIncome = Common.getUptoTwoDecimal(sellerIncome);
				sellerPendingAmount = sellerPendingAmount - amount;
				sellerPendingAmount = Common.getUptoTwoDecimal(sellerPendingAmount);
				
				
				
				if(sellerDao.sellerPaidPendingAmount(sellerPendingAmount, SellerOperations.seller.getSellerUserName(), sellerIncome)) {
					
					
					JOptionPane.showMessageDialog(null, "Amount paid successfully...");
					SellerOperations.seller.setIncome(sellerIncome);
					SellerOperations.seller.setPendingAmount(sellerPendingAmount);
					frame.setVisible(false);
					SellerOperations.main(null);
					
					
				}else {
					
					
					JOptionPane.showMessageDialog(null, "Something went wrong....");
					return;
					
				}
				
				
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(334, 288, 160, 54);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Cancel");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerOperations.main(null);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_1.setBounds(567, 490, 136, 54);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 222, 208, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Income :");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_3.setBounds(35, 117, 99, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pending Amount :");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_3_1.setBounds(35, 160, 200, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("0.00");
		lblNewLabel_2.setText(sellerPendingAmount+"");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(245, 160, 148, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("0.00");
		lblNewLabel_2_1.setText(sellerIncome+""); 
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_2_1.setBounds(151, 115, 154, 36);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("₹");
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_2_1_1.setBounds(129, 115, 21, 36);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("₹");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_2_2.setBounds(225, 160, 21, 33);
		contentPane.add(lblNewLabel_2_2);
	}
}
