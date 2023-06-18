package com.masai.SellerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerAcountClose extends JFrame {

	private JPanel contentPane;
	static SellerAcountClose frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new SellerAcountClose();
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
	public SellerAcountClose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		CSS.setMouseCursorBack(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				SellerMain.main(null);
			}
		});
		btnNewButton.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		btnNewButton.setBounds(561, 735, 120, 55);
		contentPane.add(btnNewButton);
		
		JTextArea txtrDearSellerWe = new JTextArea();
		txtrDearSellerWe.setForeground(new Color(0, 0, 0));
		txtrDearSellerWe.setEditable(false);
		txtrDearSellerWe.setFont(new Font("Gabriola", Font.BOLD, 24));
		txtrDearSellerWe.setLineWrap(true);
		txtrDearSellerWe.setBounds(10, 10, 687, 798);
		contentPane.add(txtrDearSellerWe);

		// Set the text content in the JTextArea
		String letter = "Dear Seller,\n\n"
		        + "We value your participation as a member of our organization, "
		        + "\nand we want to inform you about the account closure options available "
		        + "\nto you. Please note that instead of permanently deleting your account, "
		        + "\nwe offer the feature to temporarily close your account for a "
		        + "\nmaximum period of 3 months.\n\n"
		        + "By choosing to temporarily close your account, you can take a break from\n"
		        + "our platform without losing your account data and settings. This allows you the flexibility to step away for a defined period, knowing that your"
		        + "information will be securely stored during this time.\n\n"
		        + "After the 3-month duration, your account will automatically reopen, enabling you to resume your activities seamlessly. We believe this approach strikes a balance between giving you a temporary break while ensuring a smooth transition back into our platform.\n\n"
		        + "If you have any questions or require further clarification regarding account closure or reactivation, please don't hesitate to contact our dedicated support team. We are here to assist you every step of the way.\n\n"
		        + "Thank you for your understanding and continued partnership.\n\n"
		        + "Best regards,\n"
		        + "[Your Organization]";

		txtrDearSellerWe.setText("\r\n    Dear Seller,\r\n\r\n    We value your participation and want to inform you about our account \r\n    closure options. Instead of permanently deleting your account, \r\n    we offer the choice to temporarily close it for up to 3 months.\r\n\r\n    Temporary account closure  allows you to take a break without \r\n    losing your data and settings. \r\n\r\n    Your information will be securely stored, and after the 3-month period, \r\n    your account will automatically reopen for you to resume seamlessly.\r\n\r\n\r\n    Thank you for your understanding and continued partnership.\r\n\r\n    Best regards,\r\n    [Your Organization]");
		
		JButton button = new JButton("New button");
		button.setBounds(580, 733, 85, 21);
		contentPane.add(button);

		
	}

}
