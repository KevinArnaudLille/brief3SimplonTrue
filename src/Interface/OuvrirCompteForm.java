package Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sessionData.CurrentSessionData;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNom.setBounds(59, 64, 114, 31);
		getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrenom.setBounds(59, 124, 114, 31);
		getContentPane().add(lblPrenom);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(59, 189, 114, 31);
		getContentPane().add(lblEmail);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAdresse.setBounds(59, 251, 114, 31);
		getContentPane().add(lblAdresse);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTlphone.setBounds(59, 318, 114, 31);
		getContentPane().add(lblTlphone);
		
		textFieldNom = new JTextField();
		textFieldNom.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNom.setBounds(133, 64, 770, 31);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(159, 124, 744, 31);
		getContentPane().add(textFieldPrenom);
		
		textFieldCourriel = new JTextField();
		textFieldCourriel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldCourriel.setColumns(10);
		textFieldCourriel.setBounds(133, 189, 770, 31);
		getContentPane().add(textFieldCourriel);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(159, 251, 744, 31);
		getContentPane().add(textFieldAdresse);
		
		textFieldTel = new JTextField();
		textFieldTel.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(176, 318, 727, 31);
		getContentPane().add(textFieldTel);
		
		JButton btnAddClient = new JButton("Ajouter le client");
		btnAddClient.setFont(new Font("Arial", Font.BOLD, 24));
		btnAddClient.setBounds(230, 383, 229, 40);
		getContentPane().add(btnAddClient);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 24));
		btnCancel.setBounds(540, 383, 229, 40);
		getContentPane().add(btnCancel);
	}

	public static void main(String[] args) {
		CurrentSessionData.setConnectedConseiller("MPTremblay");
		OuvrirCompteForm testFrame = new OuvrirCompteForm();
		testFrame.setVisible(true);
	}
	
	// For futur factorisation
	private JLabel generateJLabel() {
		return null;
	}
}
