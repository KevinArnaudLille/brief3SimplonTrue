package Interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import db.DbReadQueries;
import db.DbUpdateQueries;
import model.Client;
import model.Compte;
import sessionData.CurrentSessionData;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListeComptesForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtGestionDesComptes;

	private ButtonGroup group;

	ArrayList<Compte> CompteClient;

	public ListeComptesForm() {

		Client client = CurrentSessionData.getSelectClientByClick();
		this.CompteClient = DbReadQueries.dbReadClientCompteInBdd(client);

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
		txtGestionDesComptes.setText("Gestion des comptes de " + client.getPrenom() + " " + client.getNom());
		txtGestionDesComptes.setBounds(0, 0, 986, 52);
		contentPane.add(txtGestionDesComptes);
		txtGestionDesComptes.setColumns(10);

		JButton btnBack_Back = new JButton("Quitter");
		btnBack_Back.setBounds(832, 11, 144, 35);
		contentPane.add(btnBack_Back);
		btnBack_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentSessionData.getSelectClientComptesListPage().dispose();
			}
		});

		JButton btnOuvrireCompte = new JButton("Ouvrir");
		btnOuvrireCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOuvrireCompte.setBackground(Color.WHITE);
		btnOuvrireCompte.setBounds(594, 160, 132, 45);
		contentPane.add(btnOuvrireCompte);
		btnOuvrireCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OuvrirCompteForm newOuvrirCompte = new OuvrirCompteForm();
				CurrentSessionData.setOpenComptePage(newOuvrirCompte);
				CurrentSessionData.getOpenComptePage().setVisible(true);
			}
		});

		JButton btnCrditerUnCompte = new JButton("Cr\u00E9diter");
		btnCrditerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrditerUnCompte.setBackground(Color.WHITE);
		btnCrditerUnCompte.setBounds(778, 160, 132, 45);
		contentPane.add(btnCrditerUnCompte);

		JButton btnTransfrerDeCompte = new JButton("Transf\u00E9rer");
		btnTransfrerDeCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTransfrerDeCompte.setBackground(Color.WHITE);
		btnTransfrerDeCompte.setBounds(778, 247, 132, 45);
		contentPane.add(btnTransfrerDeCompte);

		JButton btnDbiterUnCompte = new JButton("D\u00E9biter ");
		btnDbiterUnCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDbiterUnCompte.setBackground(Color.WHITE);
		btnDbiterUnCompte.setBounds(594, 247, 132, 45);
		contentPane.add(btnDbiterUnCompte);

		JButton btnClturerCompte = new JButton("Cl\u00F4turer");
		btnClturerCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClturerCompte.setBackground(Color.WHITE);
		btnClturerCompte.setBounds(778, 339, 132, 45);
		contentPane.add(btnClturerCompte);
		btnClturerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		contentPane.add(btnModifierCompte);

		JButton btnListeComptes = new JButton("Liste des Comptes");
		btnListeComptes.setFont(new Font("Arial", Font.BOLD, 25));
		btnListeComptes.setBounds(29, 69, 380, 36);
		contentPane.add(btnListeComptes);
		int x = 40;
		int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;

		group = new ButtonGroup();

		for (Compte compte : this.CompteClient) {
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
	}

	public ArrayList<Compte> getCompteClient() {
		return CompteClient;
	}

	public static void main(String[] args) {

	}
}
