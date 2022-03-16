package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class CreationBanqueForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPasseword;
	private JTextField txtSocitDpargne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationBanqueForm frame = new CreationBanqueForm();
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
	public CreationBanqueForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Username = new JPanel();
		Username.setBackground(Color.WHITE);
		Username.setBounds(327, 200, 352, 55);
		contentPane.add(Username);
		Username.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 10, 215, 35);
		Username.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(327, 286, 352, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPasseword = new JPasswordField();
		txtPasseword.setBorder(null);
		txtPasseword.setFont(new Font("Arial", Font.BOLD, 20));
		txtPasseword.setText("Password");
		txtPasseword.setBounds(10, 10, 201, 35);
		panel_1.add(txtPasseword);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(327, 368, 352, 45);
		contentPane.add(btnNewButton);
		
		txtSocitDpargne = new JTextField();
		txtSocitDpargne.setHorizontalAlignment(SwingConstants.CENTER);
		txtSocitDpargne.setFont(new Font("Arial", Font.BOLD, 25));
		txtSocitDpargne.setText("Soci\u00E9t\u00E9 d'\u00E9pargne");
		txtSocitDpargne.setBounds(310, 74, 375, 45);
		contentPane.add(txtSocitDpargne);
		txtSocitDpargne.setColumns(10);
		
		
	}
}
