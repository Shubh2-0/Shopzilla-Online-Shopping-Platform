package com.masai.SellerUi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.masai.BuyerUi.BuyerOperations;
import com.masai.BuyerUi.BuyerUpdate;
import com.masai.CSS.CSS;
import com.masai.CommanCode.Common;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.Dto.*;
import com.masai.MainUi.MainPage;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;

public class SellerOperations extends JFrame {

	private JPanel contentPane;
	static Seller seller;
	static SellerOperations frame;
	static SellerDao sellerDao = new SellerDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerOperations(seller);
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
	public SellerOperations(Seller seller) {
		this.seller = seller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 691);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("seller");
		lblNewLabel.setText("Hello " + seller.getFirstName() + " " + seller.getLastName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(281, 10, 381, 37);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Update Details");
		CSS.setMouseCursorNormal2(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				SellerUpdate.main(null);

			}
		});

		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(30, 201, 255, 59);
		contentPane.add(btnNewButton_1);

		JButton btnViewProductsFor = new JButton("View Products");
		CSS.setMouseCursorNormal2(btnViewProductsFor);
		btnViewProductsFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				SellerViewProducts.main(null);

			}
		});
		btnViewProductsFor.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnViewProductsFor.setBackground(SystemColor.menu);
		btnViewProductsFor.setBounds(30, 296, 255, 51);
		contentPane.add(btnViewProductsFor);

		JButton btnAddBalance = new JButton("Withdraw Income");
		CSS.setMouseCursorNormal2(btnAddBalance);
		btnAddBalance.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (seller.getPendingAmount() > 0) {

					JOptionPane.showMessageDialog(null, "\"Important Notice: Before withdrawing your income\n"
							+ "please ensure that you have cleared the pending amount. Once the payment is settled\n"
							+ "you can proceed with withdrawing your hard-earned money without any hindrances.\"");

					return;

				}

				frame.setVisible(false);
				SellerWithdrawIncome.main(null);

			}
		});
		btnAddBalance.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnAddBalance.setBackground(SystemColor.menu);
		btnAddBalance.setBounds(30, 378, 255, 51);
		contentPane.add(btnAddBalance);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(361, 29, 583, 400);
		contentPane.add(lblNewLabel_1);

		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/SellerMain/sellerOperation.png"));
		icon = MainPage.setImgeSize(600, 400, icon);
		lblNewLabel_1.setIcon(icon);

		JLabel lblNewLabel_2 = new JLabel("Total Income :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2.setBounds(30, 545, 172, 44);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(105, 105, 105));
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(266, 553, 207, 29);
		contentPane.add(lblNewLabel_3);
		seller.setIncome(Common.getUptoTwoDecimal(seller.getIncome()));
		lblNewLabel_3.setText(seller.getIncome() + "");

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				SellerMain.main(null);
			}
		});
		CSS.setMouseCursorLogout(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_2.setBounds(735, 595, 184, 42);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Temporary Seller Break");
		CSS.setMouseCursorDelete(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (seller.getPendingAmount() > 0) {

					JOptionPane.showMessageDialog(null,
							"ATTENTION: Please clear your pending amount before taking a break.\n"
									+ "Once the payment is taken care of, you can fully enjoy your uninterrupted time off.\"");

					return;

				}

				frame.setVisible(false);
				sellerDao.deleteSeller(seller.getSellerUserName(), seller.getPassword());
				SellerAcountClose.main(null);

			}
		});
		btnNewButton_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_2_1.setBounds(538, 402, 381, 59);
		contentPane.add(btnNewButton_2_1);

		JLabel lblNewLabel_4 = new JLabel("");

		if (seller.getIncome() > 1000000) {
			lblNewLabel_4.setText("Withdrawal Required: Please withdraw your income amount exceeding 10 lakhs");
		}
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(30, 93, 657, 37);
		contentPane.add(lblNewLabel_4);

		JButton btnAddNewProduct = new JButton("Add New Product");
		CSS.setMouseCursorNormal2(btnAddNewProduct);
		btnAddNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerNewProduct.main(null);

			}
		});
		btnAddNewProduct.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnAddNewProduct.setBackground(SystemColor.menu);
		btnAddNewProduct.setBounds(30, 462, 255, 51);
		contentPane.add(btnAddNewProduct);

		JLabel lblNewLabel_3_1 = new JLabel();
		seller.setPendingAmount(Common.getUptoTwoDecimal(seller.getPendingAmount()));
		lblNewLabel_3_1.setText(seller.getPendingAmount() + "");
		lblNewLabel_3_1.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_3_1.setBounds(266, 608, 207, 29);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_2_1 = new JLabel("Pending Amount :");
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(30, 600, 207, 44);
		contentPane.add(lblNewLabel_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Pay Pending Amount");
		CSS.setMouseCursorNormal2(btnNewButton_2_1_1);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (seller.getPendingAmount() < 1) {

					JOptionPane.showMessageDialog(null, "No pending amount to pay");
					return;

				}

				frame.setVisible(false);
				SellerPendingAmount.main(null);

			}
		});
		btnNewButton_2_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton_2_1_1.setBounds(538, 478, 381, 59);
		contentPane.add(btnNewButton_2_1_1);

		JLabel lblNewLabel_3_2 = new JLabel("₹");
		lblNewLabel_3_2.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_3_2.setBounds(247, 553, 21, 29);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("₹");
		lblNewLabel_3_2_1.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_3_2_1.setBounds(247, 608, 27, 29);
		contentPane.add(lblNewLabel_3_2_1);

		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				BuyerUpdate.main(null);

			}
		});

	}
}
