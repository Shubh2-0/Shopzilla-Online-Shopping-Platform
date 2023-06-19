package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dto.ReturnProduct;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BuyerReturnProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static  ReturnProduct returnProduct;
	private JTextField textField_5;
	static int quantity;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerReturnProduct frame = new BuyerReturnProduct();
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
	public BuyerReturnProduct() {
		setBackground(new Color(255, 127, 80));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 682);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturnProduct = new JLabel("Return Product");
		lblReturnProduct.setBounds(350, 10, 284, 62);
		lblReturnProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnProduct.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		contentPane.add(lblReturnProduct);
		
		JLabel lblNewLabel = new JLabel("Product ID :");
		lblNewLabel.setBounds(43, 113, 200, 27);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(returnProduct.getProdunctId()+"");
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField.setBounds(243, 108, 93, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(returnProduct.getProductName());
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(583, 98, 301, 37);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1.setBounds(393, 113, 200, 27);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setText(LocalDate.now()+"");
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(243, 186, 301, 37);
		contentPane.add(textField_2);
		
		JLabel lblProductDate = new JLabel("Return Date :");
		lblProductDate.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblProductDate.setBounds(43, 196, 200, 27);
		contentPane.add(lblProductDate);
		
		textField_3 = new JTextField();
		textField_3.setText(returnProduct.getBuyerId());
		textField_3.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(243, 275, 207, 37);
		contentPane.add(textField_3);
		
		JLabel lblBuyerId = new JLabel("Buyer ID :");
		lblBuyerId.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblBuyerId.setBounds(43, 280, 200, 27);
		contentPane.add(lblBuyerId);
		
		textField_4 = new JTextField();
		textField_4.setText(returnProduct.getBuyerName());
		textField_4.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(243, 356, 301, 37);
		contentPane.add(textField_4);
		
		JLabel lblBuyerName = new JLabel("Buyer Name :");
		lblBuyerName.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblBuyerName.setBounds(43, 357, 158, 34);
		contentPane.add(lblBuyerName);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		textArea.setLineWrap(true);
		textArea.setBounds(246, 433, 413, 210);
		contentPane.add(textArea);
		
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblReason.setBounds(43, 431, 200, 27);
		contentPane.add(lblReason);
		
		JTextArea txtrPleaseKindlyLet = new JTextArea();
		txtrPleaseKindlyLet.setBackground(new Color(250, 128, 114));
		txtrPleaseKindlyLet.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		txtrPleaseKindlyLet.setText("\r\n Please kindly let us know \r\n the reason for returning \r\n the product. \r\n\r\n Your feedback is valuable\r\n to us in improving our \r\n products and services.");
		txtrPleaseKindlyLet.setBounds(42, 468, 184, 167);
		contentPane.add(txtrPleaseKindlyLet);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select Return Type :");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(507, 272, 258, 43);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        comboBox.addItem("REFUND");
        comboBox.addItem("EXCHANGE");
		comboBox.setBounds(776, 278, 108, 32);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Return");
		
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(693, 435, 208, 43);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnCancel.setBounds(693, 600, 208, 43);
		contentPane.add(btnCancel);
		
		textField_5 = new JTextField();
		textField_5.setText((String) null);
		textField_5.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(776, 225, 93, 37);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity :");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(633, 235, 200, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Total Quantity :");
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		lblNewLabel_1_2_1.setBounds(605, 192, 158, 27);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Total Quantity :");
		lblNewLabel_1_2_1_1.setText(quantity+"");
		lblNewLabel_1_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		lblNewLabel_1_2_1_1.setBounds(776, 192, 158, 27);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String description = textArea.getText();
				String returnType = (String)comboBox.getSelectedItem();
				
				int enterQuantity = 0;
				
				try {
					
					enterQuantity = Integer.parseInt(textField_5.getText());
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Quantity must be in number");
					return;
				}
				
				if(enterQuantity > quantity) {
					
					JOptionPane.showMessageDialog(null, "Quantity more the amount that you purchased.");
					return;
				}
				
				
				if(description.length() < 30) {
					
					JOptionPane.showMessageDialog(null, "Please provide a reason for returning the product."
							+ "\nReason should be between 30 and 4000 characters in length");
					
					return;
				}else {
					
					
					if(returnType.equals("REFUND")) {
						
						
						
						
						
						
					}
					
					returnProduct.setReasonForRefund(description);
					returnProduct.setType(returnType);
					
					
					
					
					
				}
				
				
			}
		});
		
	}
}
