package Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controler.ConseillerConnectionControler;
import controler.NewClientControler;
import sessionData.CurrentSessionData;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class OuvrirCompteForm extends JFrame {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldCourriel;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;

	public OuvrirCompteForm() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0, 128, 128));
		setAutoRequestFocus(false);
		setUndecorated(false);
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 1000, 40);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ajouter un nouveau client");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 962, 40);
		panel.add(lblNewLabel);

		// TEXT FIELDS
		// To factorize (one day)
		// Nom
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNom.setBounds(59, 64, 114, 31);
		getContentPane().add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNom.setBounds(133, 64, 733, 31);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		textFieldNom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingNomTextField();
			}
		});

		// Prenom
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrenom.setBounds(59, 124, 114, 31);
		getContentPane().add(lblPrenom);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(159, 124, 707, 31);
		getContentPane().add(textFieldPrenom);
		textFieldPrenom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingPrenomTextField();
			}
		});

		// Courriel
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(59, 189, 114, 31);
		getContentPane().add(lblEmail);

		textFieldCourriel = new JTextField();
		textFieldCourriel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldCourriel.setColumns(10);
		textFieldCourriel.setBounds(133, 189, 733, 31);
		getContentPane().add(textFieldCourriel);
		textFieldCourriel.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingCourrielTextField();
			}
		});

		// Adresse
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAdresse.setBounds(59, 251, 114, 31);
		getContentPane().add(lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(159, 251, 707, 31);
		getContentPane().add(textFieldAdresse);
		textFieldAdresse.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingAdresseTextField();
			}
		});

		// Téléphone
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTlphone.setBounds(59, 318, 114, 31);
		getContentPane().add(lblTlphone);

		textFieldTel = new JTextField();
		textFieldTel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(176, 318, 690, 31);
		getContentPane().add(textFieldTel);
		textFieldTel.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingTelTextField();
			}
		});

		// BUTTONS
		// add client to db
		JButton btnAddClient = new JButton("Ajouter le client");
		btnAddClient.setFont(new Font("Arial", Font.BOLD, 24));
		btnAddClient.setBounds(230, 383, 229, 40);
		getContentPane().add(btnAddClient);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClientControler.onAddClientClick();
			}
		});

		// return to previous client list page
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 24));
		btnCancel.setBounds(540, 383, 229, 40);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClientControler.onCancelClick();
			}
		});
		
		JLabel NomReturnMsg = new JLabel("New label");
		NomReturnMsg.setFont(new Font("Arial", Font.BOLD, 20));
		NomReturnMsg.setForeground(new Color(165, 42, 42));
		NomReturnMsg.setBounds(876, 64, 100, 31);
		getContentPane().add(NomReturnMsg);
	}

	public static void main(String[] args) {
		CurrentSessionData.setConnectedConseiller("MPTremblay");
		OuvrirCompteForm testFrame = new OuvrirCompteForm();
		testFrame.setVisible(true);
	}
	
	// Textfields getters and setters
	public String getNom() {
		return this.textFieldNom.getText();
	}

	public String getPrenom() {
		return this.textFieldPrenom.getText();
	}

	public String getCourriel() {
		return this.textFieldCourriel.getText();
	}
	
	public String getAdresse() {
		return this.textFieldAdresse.getText();
	}
	
	public String getTel() {
		return this.textFieldTel.getText();
	}
	
	public void setNom(String newText) {
		this.textFieldNom.setText(newText);
	}
	
	public void setPrenom(String newText) {
		this.textFieldPrenom.setText(newText);
	}
	
	public void setCourriel(String newText) {
		this.textFieldCourriel.setText(newText);
	}
	
	public void setAdresse(String newText) {
		this.textFieldAdresse.setText(newText);
	}
	
	public void setTel(String newText) {
		this.textFieldTel.setText(newText);
	}
	
	// For futur factorization
	private JLabel generateJLabel(String label) {
		return null;
	}

	private JTextField generateJTextField() {
		return null;
	}
}
