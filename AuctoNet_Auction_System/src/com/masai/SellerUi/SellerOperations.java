package com.masai.SellerUi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.masai.BuyerUi.BuyerOperations;
import com.masai.BuyerUi.BuyerUpdate;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.Dto.BuyerImpl;
import com.masai.Dto.SellerImpl;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class SellerOperations extends JFrame {

	private JPanel contentPane;
	static SellerImpl seller;
	static SellerOperations frame;
	static SellerDao sellerDao = new SellerDaoImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerOperations frame = new SellerOperations(seller);
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
	public SellerOperations(SellerImpl seller) {
		this.seller = seller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("seller");
		lblNewLabel.setText("Hello " + seller.getFirstName()+" "+seller.getLastName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(281, 10, 381, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Update Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerUpdate.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(30, 207, 255, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnViewProductsFor = new JButton("View Products");
		btnViewProductsFor.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnViewProductsFor.setBackground(SystemColor.menu);
		btnViewProductsFor.setBounds(30, 296, 255, 51);
		contentPane.add(btnViewProductsFor);
		
		JButton btnAddBalance = new JButton("Add Balance");
		btnAddBalance.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnAddBalance.setBackground(SystemColor.menu);
		btnAddBalance.setBounds(30, 378, 255, 51);
		contentPane.add(btnAddBalance);
		
		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				BuyerUpdate.main(null);
				
				
				
			}
		});
		
		
		
		
	}

}
