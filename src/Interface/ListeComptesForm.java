package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import db.DbCreateQueries;
import db.DbReadQueries;
import model.Client;
import model.Compte;
import model.Conseiller;
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

	// CORR - La liste des comptes doit �tre g�n�r� automatiquement avec une boucle for
	// CORR - Le titre de la page doit contenir dynamiquement le nom du client selectionn� (selectClientByClick)
	// CORR - Les noms des composants doivent �tre explicite*//

	// CORR - La liste des comptes doit �tre g�n�r� automatiquement avec une boucle for
	
	// CORR - Le titre de la page doit contenir dynamiquement le nom du client selectionn� (selectClientByClick)***********/////////

	

	
	private static final int JRadioBtnWidth = 0;
	private static final int JRadioBtnAndJTextFieldHeigth = 0;
	private JPanel contentPane;
	private JTextField txtGestionDesComptes;
	private JPanel panel;
	
	private ButtonGroup group;
	
	ArrayList<Compte> CompteClient;

	/**
	 * Create the frame.
	 */

	public ListeComptesForm() {
		
		
		/*Client compte1;
		this.CompteClient = DbReadQueries.dbReadClientCompteInBdd(compte1);
		
	    int x = 40;
        int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;
		
		group = new ButtonGroup();
		
		for (Compte compte1: this.CompteClient) {
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(compte1.getId() + " " + compte1.getCompteCourant()+  " " + compte1.CompteEpargne());
			rdbtnNewRadioButton.setBounds(x, y, JRadioBtnWidth, JRadioBtnAndJTextFieldHeigth);
			getContentPane().add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setSelected(true);
			
			rdbtnNewRadioButton.setActionCommand(compte1.getId());
			group.add(rdbtnNewRadioButton);

			y += 50;
		}*/git 
		
		
		
		
		
		
	
		
		
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Client client = CurrentSessionData.getSelectClientByClick();
		
		txtGestionDesComptes = new JTextField();
		txtGestionDesComptes.setForeground(Color.WHITE);
		txtGestionDesComptes.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionDesComptes.setFont(new Font("Arial", Font.BOLD, 25));
		txtGestionDesComptes.setBackground(new Color(0, 0, 128));
		txtGestionDesComptes.setText("Gestion des comptes de " + client.getPrenom() + " " + client.getNom());
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
		

		JButton btnOuvrireCompte = new JButton("Ouvrire");

		
		
		JButton btnOuvrireCompte2 = new JButton("Ouvrir");
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

	public ArrayList<Compte> getCompteClient() {
		return CompteClient;
	}

	public static void main(String[] args) {
		
	}
}
