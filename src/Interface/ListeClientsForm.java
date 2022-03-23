

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
	private ButtonGroup group;
	private ArrayList<Client> conseillerClients;
	
	
	public ListeClientsForm() {

		super();
		titlePageLabel.setLocation(10, 3);

		Conseiller conseiller = CurrentSessionData.getConnectedConseiller();
		this.conseillerClients = DbReadQueries.dbReadClientOfConseiller(conseiller);

		titlePageLabel.setText("Clients de " + conseiller.getPrenom() + " " + conseiller.getNom());

		JButton quitButton = new JButton("Quitter");
		quitButton.setBounds(842, 6, 117, 29);
		panel.add(quitButton);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreationBanqueForm firstFrame = new CreationBanqueForm();
				CurrentSessionData.setHomePage(firstFrame);
				CurrentSessionData.getHomePage().setVisible(true);
				CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			}
		});
		
		JButton addNewClientButton = new JButton("Créer un nouveau client");
		addNewClientButton.setBounds(729, 184, 176, 49);
		getContentPane().add(addNewClientButton);
		addNewClientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OuvrirClientForm openAccountFrame = new OuvrirClientForm();
				CurrentSessionData.setOpenClientPage(openAccountFrame);
				CurrentSessionData.getOpenClientPage().setVisible(true);
			}
		});
			
		JButton addClientSessionsButton = new JButton("Ouvrir la session client");
		addClientSessionsButton.setBounds(729, 289, 176, 49);
		getContentPane().add(addClientSessionsButton);
		addClientSessionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(group.getSelection().getActionCommand());
				
				CurrentSessionData.setSelectClientByClick(group.getSelection().getActionCommand());
				ListeComptesForm openAccountFrame = new ListeComptesForm();
				CurrentSessionData.setSelectClientComptesListPage(openAccountFrame);
				CurrentSessionData.getSelectClientComptesListPage().setVisible(true);
				CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			}
		});
				  
		int x = 40;
		int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;
		
		group = new ButtonGroup();
		
		for (Client client : this.conseillerClients) {			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(client.getId() + " " + client.getPrenom()+  " " + client.getNom());
			rdbtnNewRadioButton.setBounds(x, y, JRadioBtnWidth, JRadioBtnAndJTextFieldHeigth);
			getContentPane().add(rdbtnNewRadioButton);

			rdbtnNewRadioButton.setSelected(true);
			
			rdbtnNewRadioButton.setActionCommand(client.getId());
			group.add(rdbtnNewRadioButton);

			y += 50;
		}
	}

	public ArrayList<Client> getConseillerClients() {
		return conseillerClients;
	}

	public void setConseillerClients(ArrayList<Client> conseillerClients) {
		this.conseillerClients = conseillerClients;
	}
}


