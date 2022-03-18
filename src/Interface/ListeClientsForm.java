package Interface;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import db.DbReadQueries;
import model.Client;
import model.Conseiller;
import sessionData.CurrentSessionData;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import checking.CheckClientAdd;
import controler.ConseillerConnectionControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListeClientsForm extends BaseTemplateForm {
	private JTextField txtNomClient;
	private ButtonGroup group;
	private ArrayList<Client> conseillerClients;
	
	public ListeClientsForm() {

		super();

		Conseiller conseiller = CurrentSessionData.getConnectedConseiller();
		this.conseillerClients = DbReadQueries.dbReadClientOfConseiller(conseiller);

		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
				CreationBanqueForm firstFrame = new CreationBanqueForm();
				CurrentSessionData.setHomePage(firstFrame);
				ConseillerConnectionControler.setFrame(firstFrame);
				firstFrame.setVisible(true);
				CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			}
		});
		btnNewButton_2.setBounds(842, 6, 117, 29);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Clients de " + conseiller.getPrenom() + " " + conseiller.getNom());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 6, 830, 29);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Créer un nouveau client");
		btnNewButton.setBounds(729, 184, 176, 49);
		getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OuvrirClientForm openAccountFrame = new OuvrirClientForm();
				CurrentSessionData.setOpenAccountPage(openAccountFrame);
				CheckClientAdd.setFrame(openAccountFrame);
				CurrentSessionData.getOpenAccountPage().setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Ouvrir la session client");
		btnNewButton_1.setBounds(729, 289, 176, 49);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  System.out.println("Le radio bouton sï¿½lectionnï¿½ est: " + 
		                  group.getSelection().getActionCommand());
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
			
			txtNomClient = new JTextField();
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