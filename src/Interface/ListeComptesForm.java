package Interface;

import javax.swing.JOptionPane;
import db.DbReadQueries;
import db.DbUpdateQueries;
import model.Client;
import model.Compte;
import sessionData.CurrentSessionData;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListeComptesForm extends BaseTemplateForm {

	// ==== Some variables declared outside constructor to allow Getters and Setters ====
	private ButtonGroup group;

	public ListeComptesForm() {
		
		// ==== Call of BaseTemplateForm (parent class) constructor ====
		super();

		// *******************************************************
		// ==== Header ====
		// == Fetching sessions data ==
		Client client = CurrentSessionData.getSelectClientByClick();
		// ==== Setting header ====
		titlePageLabel.setText("Gestion des comptes de " + client.getPrenom() + " " + client.getNom());
		titlePageLabel.setLocation(10, 3);


		JButton btnBack_Back = new JButton("Quitter");
		btnBack_Back.setBounds(842, 6, 117, 29);
		header.add(btnBack_Back);
		btnBack_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// :( SHOULD BE IN A CONTROLER
				CurrentSessionData.getSelectClientComptesListPage().dispose();
				// Create client list frame object
				ListeClientsForm listClientPage = new ListeClientsForm();

				// Add client list frame object to session storage
				CurrentSessionData.setConnectedConseillerClientsPage(listClientPage);

				// Display client list frame
				CurrentSessionData.getConnectedConseillerClientsPage().setVisible(true);
			}
		});

		JButton btnOuvrirCompte = new JButton("Ouvrir");
		btnOuvrirCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOuvrirCompte.setBackground(Color.WHITE);
		btnOuvrirCompte.setBounds(594, 160, 132, 45);
		getContentPane().add(btnOuvrirCompte);
		btnOuvrirCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// :( SHOULD BE IN A CONTROLER
				OuvrirCompteForm newOuvrirCompte = new OuvrirCompteForm();
				CurrentSessionData.setOpenComptePage(newOuvrirCompte);
				CurrentSessionData.getOpenComptePage().setVisible(true);
			}
		});


		JButton btnCloturerCompte = new JButton("Cl\u00F4turer");
		btnCloturerCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCloturerCompte.setBackground(Color.WHITE);
		btnCloturerCompte.setBounds(778, 339, 132, 45);
		getContentPane().add(btnCloturerCompte);
		btnCloturerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// :( SHOULD BE IN A CONTROLER
				CurrentSessionData.setCompteToUpdate(group.getSelection().getActionCommand());
				DbUpdateQueries.updateCompteStatusInDb(CurrentSessionData.getCompteToUpdate(), false);
				JOptionPane.showMessageDialog(CurrentSessionData.getSelectClientComptesListPage(),
						"Le compte " + CurrentSessionData.getCompteToUpdate().getId() + " a bien été clôturé.");

				CurrentSessionData.getSelectClientComptesListPage().dispose();
				ListeComptesForm openAccountFrame = new ListeComptesForm();
				CurrentSessionData.setSelectClientComptesListPage(openAccountFrame);
				CurrentSessionData.getSelectClientComptesListPage().setVisible(true);
			}
		});

		JButton btnModifierCompte = new JButton("Modifier");
		btnModifierCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModifierCompte.setBackground(Color.WHITE);
		btnModifierCompte.setBounds(594, 339, 132, 45);
		getContentPane().add(btnModifierCompte);
		btnModifierCompte.setEnabled(false);

		ArrayList<Compte> CompteClient = DbReadQueries.dbReadClientCompteInBdd(client);
		int x = 40;
		int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;

		group = new ButtonGroup();

		for (Compte compte : CompteClient) {
			if (compte.getActif()) {
				JRadioButton rdbtnNewRadioButton = new JRadioButton(
						compte.getId() + " n°" + compte.getNumero() + " - Solde : " + compte.getSolde() + "€");
				rdbtnNewRadioButton.setBounds(x, y, JRadioBtnWidth, JRadioBtnAndJTextFieldHeigth);
				getContentPane().add(rdbtnNewRadioButton);
				rdbtnNewRadioButton.setSelected(true);

				rdbtnNewRadioButton.setActionCommand(compte.getId());
				group.add(rdbtnNewRadioButton);

				y += 50;
			}
		}
		
		
		/* ==============================================
		 * IN PROGRESS (CURRENTLY UNUSED)
		 * ==============================================*/
		JButton btnCrditerUnCompte = new JButton("Cr\u00E9diter");
		btnCrditerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrditerUnCompte.setBackground(Color.WHITE);
		btnCrditerUnCompte.setBounds(778, 160, 132, 45);
		getContentPane().add(btnCrditerUnCompte);
		btnCrditerUnCompte.setEnabled(false);

		JButton btnTransfererDeCompte = new JButton("Transf\u00E9rer");
		btnTransfererDeCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTransfererDeCompte.setBackground(Color.WHITE);
		btnTransfererDeCompte.setBounds(778, 247, 132, 45);
		getContentPane().add(btnTransfererDeCompte);
		btnTransfererDeCompte.setEnabled(false);

		JButton btnDebiterUnCompte = new JButton("D\u00E9biter ");
		btnDebiterUnCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDebiterUnCompte.setBackground(Color.WHITE);
		btnDebiterUnCompte.setBounds(594, 247, 132, 45);
		getContentPane().add(btnDebiterUnCompte);
		btnDebiterUnCompte.setEnabled(false);
	}
}