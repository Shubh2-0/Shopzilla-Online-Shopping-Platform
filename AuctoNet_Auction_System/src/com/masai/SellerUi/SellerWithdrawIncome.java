package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerWithdrawIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static double income;
	static SellerDao sellerDao = new SellerDaoImpl();
    static SellerWithdrawIncome frame; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new SellerWithdrawIncome();
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
	public SellerWithdrawIncome() {
		income =  SellerOperations.seller.getIncome();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 460);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 228, 181));
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 228, 181));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel.setText("When you learn to withdraw income with purpose,");
		lblNewLabel.setBounds(115, 61, 394, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 228, 181));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1.setText("you unlock a world of enjoyment that money alone can never buy");
		lblNewLabel_1.setBounds(60, 82, 512, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Income Withdrawal");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel_2.setBounds(109, 21, 374, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		textField.setBounds(208, 236, 338, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total Income :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_3.setBounds(28, 151, 155, 49);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setText(income+"");
		lblNewLabel_4.setForeground(new Color(105, 105, 105));
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(193, 157, 153, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Amount");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_5.setBounds(28, 251, 209, 49);
		contentPane.add(lblNewLabel_5);
		
		
		JButton btnNewButton = new JButton("Withdraw");
		CSS.setMouseCursorLogin(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double amount = 0;
				
				try {
					
					amount = Double.parseDouble(textField.getText());
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Invalid Amount");
					textField.setText("");
					return;
					
				}
				
				if(amount > income) {
					
					JOptionPane.showMessageDialog(null, "Your requested withdrawal amount exceeds your total income. Please revise the withdrawal amount accordingly");
					textField.setText("");
					return;
					
					
				}else {
					
					  amount = income - amount;
					
					
					if(sellerDao.amountWithrowBySeller(amount, SellerOperations.seller.getSellerUserName())) {
						
						
						JOptionPane.showMessageDialog(null, "Withdrawal Successful! Enjoy your funds.\nYuor remaining balance is "+amount);
						frame.setVisible(false);
						SellerOperations.seller.setIncome(amount);
						SellerOperations.main(null);
						
						
					
						
						
					}else {
						
						
						JOptionPane.showMessageDialog(null, "Something went wrong try again letter");
						textField.setText("");
						return;
						
					}
					
					
					
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnNewButton.setBounds(259, 322, 260, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerOperations.main(null);
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		btnBack.setBounds(634, 368, 111, 45);
		contentPane.add(btnBack);
		
		
		
		
		
		
		
		
		
	}
}
