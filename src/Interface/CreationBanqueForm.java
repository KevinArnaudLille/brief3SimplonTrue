package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import controler.ConseillerConnectionControler;
import sessionData.CurrentSessionData;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class CreationBanqueForm extends BaseTemplateForm {

	private JTextField txtUsername;
	private JPasswordField txtPasseword;
	private JLabel errorMsgField;

	public CreationBanqueForm() {
		
		super();

		panel.setVisible(false);
		
		JPanel Username = new JPanel();
		Username.setBackground(Color.WHITE);
		Username.setBounds(327, 189, 352, 55);
		getContentPane().add(Username);
		Username.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
		txtUsername.setText("Identifiant");
		txtUsername.setBounds(10, 10, 215, 35);
		Username.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String myPass = String.valueOf(txtPasseword.getPassword());
					ConseillerConnectionControler.logInBtnClicked(txtUsername.getText(), myPass);
				}
			}
		});

		txtUsername.requestFocusInWindow();
		
		JPanel Password = new JPanel();
		Password.setBackground(Color.WHITE);
		Password.setBounds(327, 258, 352, 55);
		getContentPane().add(Password);
		Password.setLayout(null);

		txtPasseword = new JPasswordField();
		txtPasseword.setBorder(null);
		txtPasseword.setFont(new Font("Arial", Font.BOLD, 20));
		txtPasseword.setText("");
		txtPasseword.setBounds(10, 10, 201, 35);
		Password.add(txtPasseword);
		txtPasseword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String myPass = String.valueOf(txtPasseword.getPassword());
					ConseillerConnectionControler.logInBtnClicked(txtUsername.getText(), myPass);
				}
			}
		});

		JButton btnNewButton = new JButton("CONNEXION");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(327, 335, 352, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			// Go to next page
			public void actionPerformed(ActionEvent e) {
				String myPass = String.valueOf(txtPasseword.getPassword());
				ConseillerConnectionControler.logInBtnClicked(txtUsername.getText(), myPass);
			}
		});

		JLabel lblNewLabel = new JLabel("Soci\u00E9t\u00E9 d'Epargne");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 42));
		lblNewLabel.setBounds(301, 77, 394, 55);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 391, 966, 61);
		getContentPane().add(lblNewLabel_1);
		this.errorMsgField = lblNewLabel_1;
	}

	// ==== Setters ====
	public void setIdentifiantTextField(String textField) {
		this.txtUsername.setText(textField);
	}

	public void setMdpTextField(String textField) {
		this.txtPasseword.setText(textField);
	}

	public void setErrorMsgTextField(String errorMsg) {
		this.errorMsgField.setText(errorMsg);
	}
}
