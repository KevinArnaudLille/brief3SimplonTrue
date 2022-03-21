package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ListeComptesForm extends JFrame {
	// CORR - La liste des comptes doit être généré automatiquement avec une boucle for
	// CORR - le texte 'Liste des comptes" ne doit pas être éditable
	// CORR - Le titre de la page doit contenir dynamiquement le nom du client selectionné (selectClientByClick)

	// CORR - Les noms des composants doivent être explicite
	private JPanel contentPane;
	private JTextField txtGestionDesComptes;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField txtComptepargneNnumro;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtListeDesClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeComptesForm frame = new ListeComptesForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		txtGestionDesComptes.setText("Gestion des comptes");
		txtGestionDesComptes.setBounds(0, 0, 986, 52);
		contentPane.add(txtGestionDesComptes);
		txtGestionDesComptes.setColumns(10);
		
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
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(29, 181, 380, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(6, 6, 21, 21);
		panel_2.add(rdbtnNewRadioButton_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(33, 10, 337, 25);
		panel_2.add(textField_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(29, 236, 380, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(6, 6, 21, 21);
		panel_3.add(rdbtnNewRadioButton_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(33, 10, 337, 25);
		panel_3.add(textField_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(29, 291, 380, 45);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
		rdbtnNewRadioButton_4.setBounds(6, 18, 21, 21);
		panel_4.add(rdbtnNewRadioButton_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(33, 10, 337, 25);
		panel_4.add(textField_4);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(29, 346, 380, 45);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
		rdbtnNewRadioButton_5.setBounds(6, 6, 21, 21);
		panel_5.add(rdbtnNewRadioButton_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(33, 10, 337, 25);
		panel_5.add(textField_5);
		
		JButton btnNewButton = new JButton("Ouvrire");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(576, 258, 132, 45);
		contentPane.add(btnNewButton);
		
		JButton btnCrditerUnCompte = new JButton("Cr\u00E9diter");
		btnCrditerUnCompte.setBackground(Color.WHITE);
		btnCrditerUnCompte.setBounds(771, 258, 132, 45);
		contentPane.add(btnCrditerUnCompte);
		
		JButton btnTransfrer = new JButton("Transf\u00E9rer");
		btnTransfrer.setBackground(Color.WHITE);
		btnTransfrer.setBounds(771, 324, 132, 45);
		contentPane.add(btnTransfrer);
		
		JButton btnDbiterUnCompte = new JButton("D\u00E9biter ");
		btnDbiterUnCompte.setBackground(Color.WHITE);
		btnDbiterUnCompte.setBounds(576, 324, 132, 45);
		contentPane.add(btnDbiterUnCompte);
		
		JButton btnClturer = new JButton("Cl\u00F4turer");
		btnClturer.setBackground(Color.WHITE);
		btnClturer.setBounds(771, 391, 132, 45);
		contentPane.add(btnClturer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.WHITE);
		btnModifier.setBounds(576, 391, 132, 45);
		contentPane.add(btnModifier);
		
		JButton btnNewButton_1 = new JButton("Back to liste Costomer");
		btnNewButton_1.setBounds(818, 62, 144, 35);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(29, 401, 380, 45);
		contentPane.add(panel_5_1);
		
		JRadioButton rdbtnNewRadioButton_5_1 = new JRadioButton("");
		rdbtnNewRadioButton_5_1.setBounds(6, 6, 21, 21);
		panel_5_1.add(rdbtnNewRadioButton_5_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(33, 10, 337, 25);
		panel_5_1.add(textField_6);
		
		txtListeDesClients = new JTextField();
		txtListeDesClients.setFont(new Font("Arial", Font.BOLD, 20));
		txtListeDesClients.setText("Liste des Comptes");
		txtListeDesClients.setHorizontalAlignment(SwingConstants.CENTER);
		txtListeDesClients.setBounds(91, 70, 252, 35);
		contentPane.add(txtListeDesClients);
		txtListeDesClients.setColumns(10);
		
	}
	
}
