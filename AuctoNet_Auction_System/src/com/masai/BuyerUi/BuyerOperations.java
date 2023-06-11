package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dto.BuyerImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerOperations extends JFrame {

	private JPanel contentPane;
	static BuyerImpl buyer;
	static BuyerOperations frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerOperations(buyer);
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
	public BuyerOperations(BuyerImpl buyer) {
		this.buyer = buyer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 647);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("buyer");
		lblNewLabel.setText("Hello " + buyer.getFirstName()+" "+buyer.getLastName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(163, 10, 662, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				BuyerUpdate.main(null);
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(30, 165, 255, 44);
		contentPane.add(btnNewButton);
		
		JButton btnViewProductsFor = new JButton("View Products");
		btnViewProductsFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				BuyerProducts.main(null);
				
				
			}
		});
		btnViewProductsFor.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnViewProductsFor.setBackground(SystemColor.menu);
		btnViewProductsFor.setBounds(30, 348, 255, 51);
		contentPane.add(btnViewProductsFor);
		
		JButton btnViewTransactions = new JButton("View Transactions");
		btnViewTransactions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			  frame.setVisible(false);
			  BuyerTransactions.main(null);
				
			}
		});
		btnViewTransactions.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnViewTransactions.setBackground(SystemColor.menu);
		btnViewTransactions.setBounds(30, 256, 255, 59);
		contentPane.add(btnViewTransactions);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				BuyerMain.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		btnNewButton_1.setBounds(773, 523, 158, 59);
		contentPane.add(btnNewButton_1);
	}
}
