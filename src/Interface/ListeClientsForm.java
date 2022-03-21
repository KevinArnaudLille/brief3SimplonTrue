

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

		/*getContentPane().setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().setForeground(Color.WHITE);*/


		super();

		Conseiller conseiller = CurrentSessionData.getConnectedConseiller();
		this.conseillerClients = DbReadQueries.dbReadClientOfConseiller(conseiller);

		
		/*getContentPane().setBackground(new Color(0, 128, 128));
		setAutoRequestFocus(false);
		setUndecorated(false);
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 986, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clients de " + conseiller.getPrenom() + " " + conseiller.getNom());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 6, 776, 29);
		panel.add(lblNewLabel);


		JButton btnNewButton = new JButton("Créer un nouveau client");
		btnNewButton.setBackground(new Color(192, 192, 192));

		//JButton btnNewButton = new JButton("Cr�er un nouveau client");
		btnNewButton.setBounds(729, 184, 176, 49);
		getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

		
	/*	JButton btnBtnback = new JButton("Back");
		btnBtnback.setFont(new Font("Arial", Font.BOLD, 20));
		btnBtnback.setBounds(848, 6, 114, 29);
		panel.add(btnBtnback);
		btnBtnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreationBanqueForm openAccountFrame = new CreationBanqueForm();
				CurrentSessionData.setOpenAccountPage(openAccountFrame);
				CheckClientAdd.setFrame(openAccountFrame);
				CurrentSessionData.getOpenAccountPage().setVisible(true);
			}
		});*/
	
		

		/*JButton btnNewButton = new JButton("Cr�er un nouveau client");

		btnNewButton.setBackground(Color.WHITE);

		btnNewButton.setBounds(729, 184, 176, 49);
		getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {*/


		titlePageLabel.setText("Clients de " + conseiller.getPrenom() + " " + conseiller.getNom());

		JButton quitButton = new JButton("Quitter");
		quitButton.addMouseListener(new MouseAdapter() {
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
		quitButton.setBounds(842, 6, 117, 29);
		panel.add(quitButton);
		

		JButton addNewClientButton = new JButton("Cr�er un nouveau client");
		addNewClientButton.setBounds(729, 184, 176, 49);
		getContentPane().add(addNewClientButton);
		addNewClientButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				OuvrirClientForm openAccountFrame = new OuvrirClientForm();
				CurrentSessionData.setOpenAccountPage(openAccountFrame);
				CheckClientAdd.setFrame(openAccountFrame);
				CurrentSessionData.getOpenAccountPage().setVisible(true);
			}
		});
	/*====================== ouvrir la page ListeComptesForm =====================================================*/	
		

		/*JButton btnNewButton_1 = new JButton("Ouvrir la session client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
			}
			
			
		});
		btnNewButton_1.setBounds(729, 289, 176, 49);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {*/
			
			
			
			
			

		JButton openClientSessionsButton = new JButton("Ouvrir la session client");
		openClientSessionsButton.setBounds(729, 289, 176, 49);
		getContentPane().add(openClientSessionsButton);
		openClientSessionsButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				  System.out.println("Le radio bouton sélectionné est: " + 
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
			

			rdbtnNewRadioButton.setActionCommand(client.getId());
			group.add(rdbtnNewRadioButton);

			y += 50;
		}
	}

	protected void main(Object object) {
		// TODO Auto-generated method stub
		
	}



	public ArrayList<Client> getConseillerClients() {
		return conseillerClients;
	}

	public void setConseillerClients(ArrayList<Client> conseillerClients) {
		this.conseillerClients = conseillerClients;
	}
}


