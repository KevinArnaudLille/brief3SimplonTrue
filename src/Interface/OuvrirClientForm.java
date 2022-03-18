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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OuvrirClientForm extends BaseTemplateForm {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldCourriel;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;
	
	private JLabel nomReturnMsg;
	private JLabel prenomReturnMsg;
	private JLabel courrielReturnMsg;
	private JLabel adresseReturnMsg;
	private JLabel telReturnMsg;
	
	private JButton btnAddClient;

	public OuvrirClientForm() {

		super();

		titlePageLabel.setText("Ajouter un nouveau client");
		
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
		textFieldNom.setBounds(133, 64, 682, 31);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		textFieldNom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingNomTextField();
			}
		});
		textFieldNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewClientControler.onAddingTextAnywhere();
			}
		});
		
		nomReturnMsg = new JLabel("");
		nomReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		nomReturnMsg.setForeground(new Color(165, 42, 42));
		nomReturnMsg.setBounds(825, 64, 151, 31);
		getContentPane().add(nomReturnMsg);

		// Prenom
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrenom.setBounds(59, 124, 114, 31);
		getContentPane().add(lblPrenom);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(159, 124, 656, 31);
		getContentPane().add(textFieldPrenom);
		textFieldPrenom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingPrenomTextField();
			}
		});
		textFieldPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewClientControler.onAddingTextAnywhere();
			}
		});
		
		prenomReturnMsg = new JLabel("");
		prenomReturnMsg.setForeground(new Color(165, 42, 42));
		prenomReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		prenomReturnMsg.setBounds(825, 124, 151, 31);
		getContentPane().add(prenomReturnMsg);

		// Courriel
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(59, 189, 114, 31);
		getContentPane().add(lblEmail);

		textFieldCourriel = new JTextField();
		textFieldCourriel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldCourriel.setColumns(10);
		textFieldCourriel.setBounds(133, 189, 682, 31);
		getContentPane().add(textFieldCourriel);
		textFieldCourriel.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingCourrielTextField();
			}
		});
		textFieldCourriel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewClientControler.onAddingTextAnywhere();
			}
		});
		
		courrielReturnMsg = new JLabel("");
		courrielReturnMsg.setForeground(new Color(165, 42, 42));
		courrielReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		courrielReturnMsg.setBounds(825, 189, 151, 31);
		getContentPane().add(courrielReturnMsg);

		// Adresse
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAdresse.setBounds(59, 251, 114, 31);
		getContentPane().add(lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(159, 251, 656, 31);
		getContentPane().add(textFieldAdresse);
		textFieldAdresse.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingAdresseTextField();
			}
		});
		textFieldAdresse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewClientControler.onAddingTextAnywhere();
			}
		});
		
		adresseReturnMsg = new JLabel("");
		adresseReturnMsg.setForeground(new Color(165, 42, 42));
		adresseReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		adresseReturnMsg.setBounds(825, 251, 151, 31);
		getContentPane().add(adresseReturnMsg);

		// Téléphone
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTlphone.setBounds(59, 318, 114, 31);
		getContentPane().add(lblTlphone);

		textFieldTel = new JTextField();
		textFieldTel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(176, 318, 639, 31);
		getContentPane().add(textFieldTel);
		textFieldTel.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				NewClientControler.onLeavingTelTextField();
			}
		});
		textFieldTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewClientControler.onAddingTextAnywhere();
			}
		});
		
		telReturnMsg = new JLabel("");
		telReturnMsg.setForeground(new Color(165, 42, 42));
		telReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		telReturnMsg.setBounds(825, 318, 151, 31);
		getContentPane().add(telReturnMsg);

		// BUTTONS
		// add client to db
		btnAddClient = new JButton("Ajouter le client");
		btnAddClient.setFont(new Font("Arial", Font.BOLD, 24));
		btnAddClient.setBounds(230, 383, 229, 40);
		getContentPane().add(btnAddClient);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClientControler.onAddClientClick();
			}
		});
		btnAddClient.setEnabled(false);

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
	}
	
	// addClientBtn enabler
	public void enableAddClientBtn() {
		this.btnAddClient.setEnabled(true);
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
	
	// Error msgs setters
	public void setNomErrorMsg(String newText) {
		this.nomReturnMsg.setText(newText);
	}
	
	public void setPrenomErrorMsg(String newText) {
		this.prenomReturnMsg.setText(newText);
	}
	
	public void setCourrielErrorMsg(String newText) {
		this.courrielReturnMsg.setText(newText);
	}
	
	public void setAdresseErrorMsg(String newText) {
		this.adresseReturnMsg.setText(newText);
	}
	
	public void setTelErrorMsg(String newText) {
		this.telReturnMsg.setText(newText);
	}
	
	// For futur factorization
	private JLabel generateJLabel(String label) {
		return null;
	}

	private JTextField generateJTextField() {
		return null;
	}

	
	// MAIN FOR TESTING
	public static void main(String[] args) {
		CurrentSessionData.setConnectedConseiller("MPTremblay");
		OuvrirClientForm testFrame = new OuvrirClientForm();
		testFrame.setVisible(true);
	}
}
