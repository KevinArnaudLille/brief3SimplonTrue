
package Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import db.DbReadQueries;
import model.Client;
import model.Compte;
import model.Conseiller;
import sessionData.CurrentSessionData;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Window;
import javax.swing.SwingConstants;
import checking.CheckClientAdd;
import controler.ConseillerConnectionControler;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListeClientsForm extends BaseTemplateForm {

	// ==== Some variables declared outside constructor to allow Getters and Setters
	// ====
	private ArrayList<Client> conseillerClients;

	public ListeClientsForm() {

		// ==== Call of BaseTemplateForm (parent class) constructor ====
		super();

		// *******************************************************
		// ==== Header ====
		// == Fetching sessions data ==
		Conseiller conseiller = CurrentSessionData.getConnectedConseiller();
		// ==== Setting header ====
		titlePageLabel.setText("Clients de " + conseiller.getPrenom() + " " + conseiller.getNom());
		titlePageLabel.setLocation(10, 3);

		// *******************************************************
		// ==== Frame components ====
		// == Return to Conseiller login page btn ==
		JButton quitButton = new JButton("Quitter");
		quitButton.setBounds(842, 6, 117, 29);
		header.add(quitButton);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// :( SHOULD BE IN A CONTROLER
				CreationBanqueForm firstFrame = new CreationBanqueForm();
				CurrentSessionData.setHomePage(firstFrame);
				CurrentSessionData.getHomePage().setVisible(true);
				CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			}
		});

		// == Add a new Client to Conseiller btn ==
		JButton addNewClientButton = new JButton("Créer un nouveau client");
		addNewClientButton.setBounds(729, 184, 176, 49);
		getContentPane().add(addNewClientButton);
		addNewClientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// :( SHOULD BE IN A CONTROLER
				OuvrirClientForm openAccountFrame = new OuvrirClientForm();
				CurrentSessionData.setOpenClientPage(openAccountFrame);
				CurrentSessionData.getOpenClientPage().setVisible(true);
			}
		});

		// == Clients of Conseiller List ==
		// = Fetching data =
		this.conseillerClients = DbReadQueries.dbReadClientOfConseiller(conseiller);
		// = Group declaration =
		ButtonGroup group = new ButtonGroup();
		// = Setting layout position variables =
		int x = 40;
		int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;

		// = Loop for Clients list generation =
		for (Client client : this.conseillerClients) {
			JRadioButton rdbtnNewRadioButton = new JRadioButton(
					client.getId() + " " + client.getPrenom() + " " + client.getNom());
			rdbtnNewRadioButton.setBounds(x, y, JRadioBtnWidth, JRadioBtnAndJTextFieldHeigth);
			getContentPane().add(rdbtnNewRadioButton);

			// Init a preselected radio btn
			rdbtnNewRadioButton.setSelected(true);

			// Setting the value to return by radio btn selection
			rdbtnNewRadioButton.setActionCommand(client.getId());
			
			// Adding the as-generated radio btn to group
			group.add(rdbtnNewRadioButton);

			// Increment vertical position
			y += 50;
		}

		// == Go to Comptes list of selected Client page btn ==
		JButton addClientSessionsButton = new JButton("Ouvrir la session client");
		addClientSessionsButton.setBounds(729, 289, 176, 49);
		getContentPane().add(addClientSessionsButton);
		addClientSessionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// :( SHOULD BE IN A CONTROLER
				CurrentSessionData.setSelectClientByClick(group.getSelection().getActionCommand());
				ListeComptesForm listCompteFrame = new ListeComptesForm();
				CurrentSessionData.setSelectClientComptesListPage(listCompteFrame);
				CurrentSessionData.getSelectClientComptesListPage().setVisible(true);
				CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			}
		});
	}

	// *******************************************************
	// ==== Setters ====
	public ArrayList<Client> getConseillerClients() {
		return conseillerClients;
	}

	public void setConseillerClients(ArrayList<Client> conseillerClients) {
		this.conseillerClients = conseillerClients;
	}
}