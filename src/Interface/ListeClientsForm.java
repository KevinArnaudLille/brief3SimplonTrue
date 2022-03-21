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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListeClientsForm extends JFrame {
	private JTextField txtNomClient;
	private ButtonGroup group;
	private ArrayList<Client> conseillerClients;
	
	public ListeClientsForm() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().setForeground(Color.WHITE);

		Conseiller conseiller = DbReadQueries.dbReadConseillers().get(0);
		this.conseillerClients = DbReadQueries.dbReadClientOfConseiller(conseiller);
		
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

		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		btnNewButton.setBackground(new Color(192, 192, 192));

		//JButton btnNewButton = new JButton("Cr�er un nouveau client");
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
			txtNomClient = new JTextField();
			rdbtnNewRadioButton.setActionCommand(client.getId());
			group.add(rdbtnNewRadioButton);
			
			/*txtNomClient = new JTextField();
			txtNomClient.setText(client.getNom() + " " + client.getPrenom());
			txtNomClient.setBounds(x + JRadioBtnWidth, y, JTextFieldWidth, JRadioBtnAndJTextFieldHeigth);
			getContentPane().add(txtNomClient);
			txtNomClient.setColumns(10);*/
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