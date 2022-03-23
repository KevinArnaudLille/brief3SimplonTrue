package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import checking.CheckClientAdd;
import checking.CheckCompteAdd;
import controler.NewClientControler;
//import controler.NewClientControler;
import controler.NewCompteControler;
//import sessionData.CurrentSessionData;
import sessionData.CurrentSessionData;

public class OuvrirCompteForm extends BaseTemplateForm {

	private JTextField textFieldProprietaire_tutelle;
	private JTextField textFieldSolde;
	private JTextField textFieldFrais_transfert;
	private JTextField textFieldSolde_minimum_autorise;
	private JTextField textFieldPlafond;
	private JTextField textFieldTaux_interet;

	// private JLabel IdReturnMsg;
	private JLabel Proprietaire_tutelleReturnMsg;
	private JLabel NumeroReturnMsg;
	private JLabel SoldeReturnMsg;
	private JLabel Frais_transfertReturnMsg;
	private JLabel Solde_minimum_autoriseReturnMsg;
	private JLabel PlafondReturnMsg;
	private JLabel Taux_interetReturnMsg;
	private JLabel lblFrais_transfert;
	private JLabel lblSolde_minimum_autorise;
	private JLabel lblPlafond;
	private JLabel lblTaux_interet;

	private JRadioButton btnAddCompte_courant;
	private JRadioButton btnAddCompte_epargne;

	private JButton btnValidate;

	private JLabel ClientReturnMsg;
	private JLabel Client;

	private ButtonGroup group;
	private JLabel clientNom;
	private JLabel compteNum;

	public OuvrirCompteForm() {

		super();

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().setForeground(Color.WHITE);
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

		JLabel lblNewLabel = new JLabel("Ajouter un compte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 6, 984, 29);
		panel.add(lblNewLabel);

		// NUMERO DE COMPTE
		JLabel lblNumero = new JLabel("Numéro de compte:");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setBounds(172, 123, 125, 16);
		getContentPane().add(lblNumero);

		// NUMERO DE COMPTE GENERE ALEATOIREMENT
		// Random random = new Random();
		compteNum = new JLabel("" + NewCompteControler.generateNewRandomCompteNumber());
		compteNum.setForeground(Color.WHITE);
		compteNum.setBounds(309, 123, 107, 16);
		getContentPane().add(compteNum);

		// NOM DU CLIENT
		JLabel Client = new JLabel("Nom du client : " + CurrentSessionData.getSelectClientByClick().getPrenom() + " "
				+ CurrentSessionData.getSelectClientByClick().getNom());
		Client.setForeground(Color.WHITE);
		Client.setBounds(592, 123, 241, 16);
		getContentPane().add(Client);

		clientNom = new JLabel();
		clientNom.setBounds(703, 123, 130, 16);
		getContentPane().add(clientNom);

		// SOLDE INITIAL
		JLabel lblsoldeInitial = new JLabel("Solde initial :");
		lblsoldeInitial.setForeground(Color.WHITE);
		lblsoldeInitial.setBounds(97, 192, 78, 21);
		getContentPane().add(lblsoldeInitial);

		textFieldSolde = new JTextField();
		textFieldSolde.setColumns(10);
		textFieldSolde.setBounds(189, 189, 130, 26);
		getContentPane().add(textFieldSolde);
		textFieldSolde.setColumns(10);
		textFieldSolde.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onAddingTextAnywhere();
				NewCompteControler.onTypingSoldeTextField();
			}
		});

		SoldeReturnMsg = new JLabel("");
		SoldeReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		SoldeReturnMsg.setForeground(new Color(165, 42, 42));
		SoldeReturnMsg.setBounds(324, 192, 208, 31);
		getContentPane().add(SoldeReturnMsg);

		// TUTELLE
		JLabel lblProprietaire_tutelle = new JLabel("Si différent (tutelle) :");
		lblProprietaire_tutelle.setForeground(Color.WHITE);
		lblProprietaire_tutelle.setBounds(561, 192, 130, 21);
		getContentPane().add(lblProprietaire_tutelle);

		textFieldProprietaire_tutelle = new JTextField();
		textFieldProprietaire_tutelle.setColumns(10);
		textFieldProprietaire_tutelle.setBounds(675, 189, 130, 26);
		getContentPane().add(textFieldProprietaire_tutelle);
		textFieldProprietaire_tutelle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onAddingTextAnywhere();
				NewCompteControler.onTypingProprietaire_tutelleTextField();
			}
		});
		
		Proprietaire_tutelleReturnMsg = new JLabel("");
		Proprietaire_tutelleReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		Proprietaire_tutelleReturnMsg.setForeground(new Color(165, 42, 42));
		Proprietaire_tutelleReturnMsg.setBounds(811, 189, 165, 31);
		getContentPane().add(Proprietaire_tutelleReturnMsg);

		// BOUTON RADIO COMPTE COURANT
		btnAddCompte_courant = new JRadioButton("Compte courant");
		btnAddCompte_courant.setForeground(Color.BLACK);
		btnAddCompte_courant.setBounds(339, 256, 141, 23);
		getContentPane().add(btnAddCompte_courant);
		btnAddCompte_courant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFrais_transfert.setVisible(true);
				textFieldFrais_transfert.setVisible(true);
				lblSolde_minimum_autorise.setVisible(true);
				textFieldSolde_minimum_autorise.setVisible(true);
				lblPlafond.setVisible(false);
				textFieldPlafond.setVisible(false);
				lblTaux_interet.setVisible(false);
				textFieldTaux_interet.setVisible(false);
			}
		});

		// BOUTON RADIO COMPTE EPARGNE
		btnAddCompte_epargne = new JRadioButton("Compte épargne");
		btnAddCompte_epargne.setForeground(Color.BLACK);
		btnAddCompte_epargne.setBounds(532, 256, 141, 23);
		getContentPane().add(btnAddCompte_epargne);
		btnAddCompte_epargne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFrais_transfert.setVisible(false);
				textFieldFrais_transfert.setVisible(false);
				lblSolde_minimum_autorise.setVisible(false);
				textFieldSolde_minimum_autorise.setVisible(false);
				lblPlafond.setVisible(true);
				textFieldPlafond.setVisible(true);
				lblTaux_interet.setVisible(true);
				textFieldTaux_interet.setVisible(true);
			}
		});

		group = new ButtonGroup();

		group.add(btnAddCompte_courant);
		group.add(btnAddCompte_epargne);

		// BOUTON VALIDER
		btnValidate = new JButton("Valider");
		btnValidate.setBounds(333, 401, 117, 29);
		getContentPane().add(btnValidate);
		btnValidate.setEnabled(false);
		btnValidate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// quand je clique sur "valider" je supprime la page
				NewCompteControler.onAddCompteClicked();
			}
		});

		
		
		// FRAIS TRANSFERT
		lblFrais_transfert = new JLabel("Frais de transfert:");
		lblFrais_transfert.setForeground(Color.WHITE);
		lblFrais_transfert.setBounds(186, 341, 125, 21);
		getContentPane().add(lblFrais_transfert);
		lblFrais_transfert.setVisible(false);

		textFieldFrais_transfert = new JTextField();
		textFieldFrais_transfert.setColumns(10);
		textFieldFrais_transfert.setBounds(309, 338, 130, 26);
		getContentPane().add(textFieldFrais_transfert);
		textFieldFrais_transfert.setVisible(false);
		textFieldFrais_transfert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onTypingFrais_transfertTextField();
				NewCompteControler.onAddingTextAnywhere();
			}
		});

		Frais_transfertReturnMsg = new JLabel("");
		Frais_transfertReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		Frais_transfertReturnMsg.setForeground(new Color(165, 42, 42));
		Frais_transfertReturnMsg.setBounds(286, 373, 151, 31);
		getContentPane().add(Frais_transfertReturnMsg);

		// SOLDE MINIMUM AUTORISE
		lblSolde_minimum_autorise = new JLabel("Solde minimum autorisé:");
		lblSolde_minimum_autorise.setForeground(Color.WHITE);
		lblSolde_minimum_autorise.setBounds(523, 343, 181, 16);
		getContentPane().add(lblSolde_minimum_autorise);
		lblSolde_minimum_autorise.setVisible(false);

		textFieldSolde_minimum_autorise = new JTextField();
		textFieldSolde_minimum_autorise.setColumns(10);
		textFieldSolde_minimum_autorise.setBounds(703, 338, 130, 26);
		getContentPane().add(textFieldSolde_minimum_autorise);
		textFieldSolde_minimum_autorise.setVisible(false);
		textFieldSolde_minimum_autorise.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onTypingSolde_minimum_autoriseTextField();
				NewCompteControler.onAddingTextAnywhere();
			}
		});

		Solde_minimum_autoriseReturnMsg = new JLabel("");
		Solde_minimum_autoriseReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		Solde_minimum_autoriseReturnMsg.setForeground(new Color(165, 42, 42));
		Solde_minimum_autoriseReturnMsg.setBounds(695, 370, 151, 31);
		getContentPane().add(Solde_minimum_autoriseReturnMsg);

		// PLAFOND
		lblPlafond = new JLabel("Plafond:");
		lblPlafond.setForeground(Color.WHITE);
		lblPlafond.setBounds(632, 344, 59, 21);
		getContentPane().add(lblPlafond);
		lblPlafond.setVisible(false);

		textFieldPlafond = new JTextField();
		textFieldPlafond.setColumns(10);
		textFieldPlafond.setBounds(703, 341, 130, 26);
		getContentPane().add(textFieldPlafond);
		textFieldPlafond.setVisible(false);
		textFieldPlafond.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onTypingPlafondTextField();
				NewCompteControler.onAddingTextAnywhere();
			}
		});

		PlafondReturnMsg = new JLabel("");
		PlafondReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		PlafondReturnMsg.setForeground(new Color(165, 42, 42));
		PlafondReturnMsg.setBounds(695, 370, 151, 31);
		getContentPane().add(PlafondReturnMsg);

		// TAUX INTERET
		lblTaux_interet = new JLabel("Taux d'intérêt:");
		lblTaux_interet.setForeground(Color.WHITE);
		lblTaux_interet.setBounds(186, 344, 125, 21);
		getContentPane().add(lblTaux_interet);
		lblTaux_interet.setVisible(false);

		textFieldTaux_interet = new JTextField();
		textFieldTaux_interet.setColumns(10);
		textFieldTaux_interet.setBounds(309, 345, 130, 26);
		getContentPane().add(textFieldTaux_interet);
		textFieldTaux_interet.setVisible(false);
		textFieldTaux_interet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				NewCompteControler.onTypingTaux_interetTextField();
				NewCompteControler.onAddingTextAnywhere();
			}
		});

		Taux_interetReturnMsg = new JLabel("");
		Taux_interetReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
		Taux_interetReturnMsg.setForeground(new Color(165, 42, 42));
		Taux_interetReturnMsg.setBounds(299, 373, 151, 31);
		getContentPane().add(Taux_interetReturnMsg);

		// CANCEL BTN
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(536, 401, 117, 29);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewCompteControler.onCancelClicked();
			}
		});
	}

	// addCompteCourantBtn enabler
	public void enableAddCompte_courantBtn() {
		this.btnAddCompte_courant.setEnabled(true);
	}

	// addCompteEpargneBtn enabler
	public void enableAddCompte_epargneBtn() {
		this.btnAddCompte_epargne.setEnabled(true);
	}

	// addValidateBtn enabler
	public void enableAddClientBtn() {
		this.btnValidate.setEnabled(true);
	}

	// addValidateBtn enabler
	public void disableAddClientBtn() {
		this.btnValidate.setEnabled(false);
	}

	// Textfields getters and setters
	public String getClient() {
		return this.clientNom.getText();
	}

	public String getNumero() {
		return this.compteNum.getText();
	}

	public String getProprietaire_tutelle() {
		return this.textFieldProprietaire_tutelle.getText();
	}

	public String getSolde() {
		return this.textFieldSolde.getText();
	}

	public String getFrais_transfert() {
		return this.textFieldFrais_transfert.getText();
	}

	public String getSolde_minimum_autorise() {
		return this.textFieldSolde_minimum_autorise.getText();
	}

	public String getTaux_interet() {
		return this.textFieldTaux_interet.getText();
	}

	public String getPlafond() {
		return this.textFieldPlafond.getText();
	}

	public void setClient(String newText) {
		this.clientNom.setText(newText);
	}

	public void setNumero(String newText) {
		this.compteNum.setToolTipText(newText);
	}

	public void setProprietaire_tutelle(String newText) {
		this.textFieldProprietaire_tutelle.setText(newText);
	}

	public void setSolde(String newText) {
		this.textFieldSolde.setText(newText);
	}

	public void setFrais_transfert(String newText) {
		this.textFieldFrais_transfert.setText(newText);
	}

	public void setSolde_minimum_autorise(String newText) {
		this.textFieldFrais_transfert.setText(newText);
	}

	public void setTaux_interet(String newText) {
		this.textFieldTaux_interet.setText(newText);
	}

	public void setPlafond(String newText) {
		this.textFieldPlafond.setText(newText);
	}

	// Error msgs setters
	public void setClientErrorMsg(String newText) {
		this.ClientReturnMsg.setText(newText);
	}

	public void setNumeroErrorMsg(String newText) {
		this.NumeroReturnMsg.setText(newText);
	}

	public void setProprietaire_tutelleErrorMsg(String newText) {
		this.Proprietaire_tutelleReturnMsg.setText(newText);
	}

	public void setSoldeErrorMsg(String newText) {
		this.SoldeReturnMsg.setText(newText);
	}

	public void setFrais_transfertErrorMsg(String newText) {
		this.Frais_transfertReturnMsg.setText(newText);
	}

	public void setSolde_minimum_autoriseErrorMsg(String newText) {
		this.Solde_minimum_autoriseReturnMsg.setText(newText);
	}

	public void setTaux_interetErrorMsg(String newText) {
		this.Taux_interetReturnMsg.setText(newText);
	}

	public void setPlafondErrorMsg(String newText) {
		this.PlafondReturnMsg.setText(newText);
	}

	// MAIN FOR TESTING
	public static void main(String[] args) {
		CurrentSessionData.setConnectedConseiller("MPTremblay");
		OuvrirCompteForm testFrame = new OuvrirCompteForm();
		testFrame.setVisible(true);
	}
}
