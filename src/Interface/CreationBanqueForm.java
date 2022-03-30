package Interface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import controler.ConseillerConnectionControler;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class CreationBanqueForm extends BaseTemplateForm {

	// ==== Some variables declared outside constructor to allow Getters and Setters
	// ====
	private JTextField txtUsername;
	private JPasswordField txtPasseword;
	private JLabel errorMsgField;

	public CreationBanqueForm() {
		// ==== Call of BaseTemplateForm (parent class) constructor ====
		super();

		// *******************************************************
		// ==== Hiding header ====
		header.setVisible(false);

		// *******************************************************
		// ==== Frame components ====
		// == Title component ==
		JLabel titleLabel = new JLabel("Soci\u00E9t\u00E9 d'Epargne");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
		titleLabel.setBounds(301, 77, 394, 55);
		getContentPane().add(titleLabel);

		// == Conseiller id components ==
		// = Conseiller id static title =
		JPanel Username = new JPanel();
		Username.setBackground(Color.WHITE);
		Username.setBounds(327, 189, 352, 55);
		getContentPane().add(Username);
		Username.setLayout(null);

		// = Conseiller id dynamic field =
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
		txtUsername.setText("Identifiant");
		txtUsername.setBounds(10, 10, 215, 35);
		txtUsername.setColumns(10);
		Username.add(txtUsername);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String myPass = String.valueOf(txtPasseword.getPassword());
					ConseillerConnectionControler.onLogInBtnClicked(txtUsername.getText(), myPass);
				}
			}
		});
		txtUsername.requestFocusInWindow();

		// == Conseiller password components ==
		// = Conseiller password static title =
		JPanel Password = new JPanel();
		Password.setBackground(Color.WHITE);
		Password.setBounds(327, 258, 352, 55);
		getContentPane().add(Password);
		Password.setLayout(null);

		// = Conseiller password dynamic field =
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
					ConseillerConnectionControler.onLogInBtnClicked(txtUsername.getText(), myPass);
				}
			}
		});

		// == Connection btn ==
		JButton btnNewButton = new JButton("CONNEXION");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(327, 335, 352, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myPass = String.valueOf(txtPasseword.getPassword());
				ConseillerConnectionControler.onLogInBtnClicked(txtUsername.getText(), myPass);
			}
		});

		// == Error setable field component ==
		JLabel errorFieldLabel = new JLabel("");
		errorFieldLabel.setForeground(new Color(165, 42, 42));
		errorFieldLabel.setFont(new Font("Arial", Font.BOLD, 18));
		errorFieldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorFieldLabel.setBounds(10, 391, 966, 61);
		getContentPane().add(errorFieldLabel);
		this.errorMsgField = errorFieldLabel;
	}

	// *******************************************************
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
