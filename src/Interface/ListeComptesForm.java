package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import db.DbCreateQueries;
import model.Client;
import model.Compte;
import sessionData.CurrentSessionData;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.management.remote.SubjectDelegationPermission;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Date;

public class ListeComptesForm extends JFrame {
	// CORR - La liste des comptes doit être généré automatiquement avec une boucle for
	
	// CORR - Le titre de la page doit contenir dynamiquement le nom du client selectionné (selectClientByClick)

	// CORR - Les noms des composants doivent être explicite*//
	
	private static final int JRadioBtnWidth = 0;
	private static final int JRadioBtnAndJTextFieldHeigth = 0;
	private JPanel contentPane;
	private JTextField txtGestionDesComptes;
	private JPanel panel;
	private JTextField txtComptepargneNnumro;
	private Client[] conseillerClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

        /*ArrayList<Compte> Comptes = new ArrayList<Compte>();
		Comptes.add(new Compte("1",5005, 3000, "true", "no", new Date(), "name"));
		Comptes.add(new Compte("2",5006, 4000, "false", "yes", new Date(), "name"));
		Comptes.add(new Compte("1",5007, 5000, "true", "non", new Date(), "nom"));*/
		
		
		
		
	/**/	/*Super();
		
		JTextField jTextField2 = new JTextField();
		jTextField2.setLocation(10, 3);
		Client client = CurrentSessionData.getSelectClientByClick();
		/*this.conseillerClients = DbCreateQueries.dbReClientofConseiller(client);
		JTextComponent titlePageLabel;
		JTextField jTextField = new JTextField();
		jTextField.setText("Compte de  " + client.getPrenom() + " " + client.getNom());
		
}

	private static void Super() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public ListeComptesForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGestionDesComptes = new JTextField();
		txtGestionDesComptes.setForeground(Color.WHITE);
		txtGestionDesComptes.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionDesComptes.setFont(new Font("Arial", Font.BOLD, 25));
		txtGestionDesComptes.setBackground(new Color(0, 0, 128));
		txtGestionDesComptes.setText("Gestion des comptes<dynamic><dynamic>");
		txtGestionDesComptes.setBounds(0, 0, 986, 52);
		contentPane.add(txtGestionDesComptes);
		txtGestionDesComptes.setColumns(10);//

		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(29, 115, 380, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(6, 6, 21, 21);
		panel.add(rdbtnNewRadioButton);
		
		txtComptepargneNnumro = new JTextField();
		txtComptepargneNnumro.setFont(new Font("Arial", Font.BOLD, 10));
		txtComptepargneNnumro.setText("Compte \u00E9pargne N\u00B0{Num\u00E9ro du compte}-{Libelle-Clinet}-Solde: {Solde}EUROS");
		txtComptepargneNnumro.setBounds(33, 10, 337, 25);
		panel.add(txtComptepargneNnumro);
		txtComptepargneNnumro.setColumns(10);
		
		JButton btnOuvrireCompte = new JButton("Ouvrire");
		btnOuvrireCompte.setBackground(Color.WHITE);
		btnOuvrireCompte.setBounds(576, 258, 132, 45);
		contentPane.add(btnOuvrireCompte);
		
		JButton btnCrditerUnCompte = new JButton("Cr\u00E9diter");
		btnCrditerUnCompte.setBackground(Color.WHITE);
		btnCrditerUnCompte.setBounds(771, 258, 132, 45);
		contentPane.add(btnCrditerUnCompte);
		
		JButton btnTransfrerDeCompte = new JButton("Transf\u00E9rer");
		btnTransfrerDeCompte.setBackground(Color.WHITE);
		btnTransfrerDeCompte.setBounds(771, 324, 132, 45);
		contentPane.add(btnTransfrerDeCompte);
		
		JButton btnDbiterUnCompte = new JButton("D\u00E9biter ");
		btnDbiterUnCompte.setBackground(Color.WHITE);
		btnDbiterUnCompte.setBounds(576, 324, 132, 45);
		contentPane.add(btnDbiterUnCompte);
		
		JButton btnClturerCompte = new JButton("Cl\u00F4turer");
		btnClturerCompte.setBackground(Color.WHITE);
		btnClturerCompte.setBounds(771, 391, 132, 45);
		contentPane.add(btnClturerCompte);
		
		JButton btnModifierCompte = new JButton("Modifier");
		btnModifierCompte.setBackground(Color.WHITE);
		btnModifierCompte.setBounds(576, 391, 132, 45);
		contentPane.add(btnModifierCompte);
		
		JButton btnBack_Back = new JButton("Back to liste Costomer");
		btnBack_Back.setBounds(818, 62, 144, 35);
		contentPane.add(btnBack_Back);
		
		JButton btnListeComptes = new JButton("Liste des Comptes");
		btnListeComptes.setFont(new Font("Arial", Font.BOLD, 25));
		btnListeComptes.setBounds(29, 69, 380, 36);
		contentPane.add(btnListeComptes);
		
	}
	
}
