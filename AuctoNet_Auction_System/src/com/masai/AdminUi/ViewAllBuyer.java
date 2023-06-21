package com.masai.AdminUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.MainUi.MainPage;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class ViewAllBuyer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	static ViewAllBuyer frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewAllBuyer();
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
	public ViewAllBuyer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(23, 51, 1229, 296);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.GRAY);
		table.setBorder(null);
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "buyer1", "password1", "Amit", "Sharma", "9876543210", "123 Main St, Delhi" },
						{ "buyer2", "password2", "Neha", "Patel", "8765432109", "456 Oak St, Mumbai" },
						{ "buyer3", "password3", "Rahul", "Singh", "7654321098", "789 Maple St, Bangalore" },
						{ "buyer4", "password4", "Pooja", "Gupta", "6543210987", "456 Elm St, Chennai" },
						{ "buyer5", "password5", "Priya", "Verma", "+91-9876543211", "345 Park St, Kolkata" },
						{ "buyer6", "password6", "Raj", "Gandhi", "+91-8765432108", "567 Beach Rd, Goa" },
						{ "buyer7", "password7", "Sneha", "Kapoor", "+91-7654321097", "789 Hill St, Hyderabad" },
						{ "buyer8", "password8", "Vikram", "Mehra", "+91-6543210986", "234 Lake Ave, Chandigarh" }, },
				new String[] { "User  Name", "password", "first_name", "last_name", "mobile_no", "address" }));
		table.getColumnModel().getColumn(5).setPreferredWidth(108);

		try {
			table.setModel(DbUtils.resultSetToTableModel(new AdminDaoImpl().getAllBuyer()));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSS.setTable(table);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.WHITE);
		CSS.setMouseCursorBack(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				AdminOperations.main(null);
			}
		});

		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(635, 447, 115, 39);
		contentPane.add(btnNewButton);
	}

}
