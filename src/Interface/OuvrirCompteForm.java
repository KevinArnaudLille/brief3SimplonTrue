package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controler.NewClientControler;
import controler.NewCompteControler;
import sessionData.CurrentSessionData;

public class OuvrirCompteForm extends BaseTemplateForm  {

	private JTextField textFieldProprietaire_tutelle;
	private JTextField textFieldNumero;
	private JTextField textFieldSolde;
	private JTextField textFieldFrais_transfert;
	private JTextField textFieldSolde_minimum_autorise;
	private JTextField textFieldPlafond;
	private JTextField textFieldTaux_interet;

	//private JLabel IdReturnMsg;
	private JLabel Proprietaire_tutelleReturnMsg;
	private JLabel NumeroReturnMsg;
	private JLabel SoldeReturnMsg;
	private JLabel Frais_transfertReturnMsg;
	private JLabel Solde_minimum_autoriseReturnMsg;
	private JLabel PlafondReturnMsg;
	private JLabel Taux_interetReturnMsg;

	
	private JButton btnAddCompte_courant;
	private JButton btnAddCompte_epargne;
	
	private JLabel NomReturnMsg;
	private JLabel Nom;

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
	
	//TUTELLE
	textFieldProprietaire_tutelle = new JTextField();
	textFieldProprietaire_tutelle.setColumns(10);
	textFieldProprietaire_tutelle.addFocusListener(new FocusAdapter() {
		/*public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingProprietaire_tutelleTextField();
		}
	});
	textFieldProprietaire_tutelle.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}*/
	});
	/*Proprietaire_tutelleReturnMsg = new JLabel("");
	Proprietaire_tutelleReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	Proprietaire_tutelleReturnMsg.setForeground(new Color(165, 42, 42));
	Proprietaire_tutelleReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(Proprietaire_tutelleReturnMsg);*/
	textFieldProprietaire_tutelle.setBounds(703, 189, 130, 26);
	getContentPane().add(textFieldProprietaire_tutelle);
	JLabel lblProprietaire_tutelle = new JLabel("Si différent (tutelle):");
	lblProprietaire_tutelle.setForeground(Color.WHITE);
	lblProprietaire_tutelle.setBounds(561, 192, 130, 21);
	getContentPane().add(lblProprietaire_tutelle);
	
	//NUMERO DE COMPTE
	JLabel lblNumero = new JLabel("Numéro de compte:");
	lblNumero.setForeground(Color.WHITE);
	lblNumero.setBounds(172, 123, 125, 16);
	getContentPane().add(lblNumero);
	
	textFieldNumero = new JTextField();
	textFieldNumero.setBounds(309, 118, 130, 26);
	getContentPane().add(textFieldNumero);
	textFieldNumero.setColumns(10);
	textFieldNumero.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingNumeroTextField();
		}
	});
	textFieldNumero.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewClientControler.onAddingTextAnywhere();
		}
	});
	NumeroReturnMsg = new JLabel("");
	NumeroReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	NumeroReturnMsg.setForeground(new Color(165, 42, 42));
	NumeroReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(NumeroReturnMsg);
	
	//NOM DU CLIENT
	JLabel Nom = new JLabel("Nom du client:");
	Nom.setForeground(Color.WHITE);
	Nom.setBounds(592, 123, 99, 16);
	getContentPane().add(Nom);
	
	//SOLDE INITIAL
	JLabel lblsoldeInitial = new JLabel("Solde initial:");
	lblsoldeInitial.setForeground(Color.WHITE);
	lblsoldeInitial.setBounds(217, 192, 78, 21);
	getContentPane().add(lblsoldeInitial);
	
	textFieldSolde = new JTextField();
	textFieldSolde.setColumns(10);
	textFieldSolde.setBounds(309, 189, 130, 26);
	getContentPane().add(textFieldSolde);
	
	textFieldSolde.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingSoldeTextField();
		}
	});
	textFieldSolde.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}
	});
	
	SoldeReturnMsg = new JLabel("");
	SoldeReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	SoldeReturnMsg.setForeground(new Color(165, 42, 42));
	SoldeReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(SoldeReturnMsg);
	
	//BOUTON RADIO COMPTE COURANT
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Compte courant");
	rdbtnNewRadioButton.setForeground(Color.WHITE);
	rdbtnNewRadioButton.setBounds(339, 256, 141, 23);
	getContentPane().add(rdbtnNewRadioButton);
	
	//BOUTON RADIO COMPTE EPARGNE
	JRadioButton rdbtnComptepargne = new JRadioButton("Compte épargne");
	rdbtnComptepargne.setForeground(Color.WHITE);
	rdbtnComptepargne.setBounds(532, 256, 141, 23);
	getContentPane().add(rdbtnComptepargne);
	
	//BOUTON VALIDER
	JButton btnNewButton = new JButton("Valider"); 
	btnNewButton.setBounds(437, 401, 117, 29);
	getContentPane().add(btnNewButton);
	
	//FRAIS TRANSFERT
	JLabel lblFrais_transfert = new JLabel("Frais de transfert:");
	lblFrais_transfert.setForeground(Color.WHITE);
	lblFrais_transfert.setBounds(186, 319, 125, 21);
	getContentPane().add(lblFrais_transfert );
	
	textFieldFrais_transfert = new JTextField();
	textFieldFrais_transfert.setColumns(10);
	textFieldFrais_transfert.setBounds(309, 316, 130, 26);
	getContentPane().add(textFieldFrais_transfert);
	
	textFieldFrais_transfert.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingFrais_transfertTextField();
		}
	});
	textFieldFrais_transfert.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}
	});
	
	Frais_transfertReturnMsg = new JLabel("");
	Frais_transfertReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	Frais_transfertReturnMsg.setForeground(new Color(165, 42, 42));
	Frais_transfertReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(Frais_transfertReturnMsg);
	
	//SOLDE MINIMUM AUTORISE
	JLabel lblSolde_minimum_autorise = new JLabel("Solde minimum autorisé:");
	lblSolde_minimum_autorise.setForeground(Color.WHITE);
	lblSolde_minimum_autorise.setBounds(523, 321, 181, 16);
	getContentPane().add(lblSolde_minimum_autorise);
	
	textFieldSolde_minimum_autorise = new JTextField();
	textFieldSolde_minimum_autorise.setColumns(10);
	textFieldSolde_minimum_autorise.setBounds(703, 316, 130, 26);
	getContentPane().add(textFieldSolde_minimum_autorise);
	
	textFieldSolde_minimum_autorise.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingSolde_minimum_autoriseTextField();
		}
	});
	textFieldSolde_minimum_autorise.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}
	});
	
	Solde_minimum_autoriseReturnMsg = new JLabel("");
	Solde_minimum_autoriseReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	Solde_minimum_autoriseReturnMsg.setForeground(new Color(165, 42, 42));
	Solde_minimum_autoriseReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(Solde_minimum_autoriseReturnMsg);
	
	
	//PLAFOND
	JLabel lblPlafond = new JLabel("Plafond:");
	lblPlafond.setForeground(Color.WHITE);
	lblPlafond.setBounds(632, 362, 59, 21);
	getContentPane().add(lblPlafond);
		
	textFieldPlafond = new JTextField();
	textFieldPlafond.setColumns(10);
	textFieldPlafond.setBounds(703, 359, 130, 26);
	getContentPane().add(textFieldPlafond);
		
	textFieldPlafond.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingPlafondTextField();
		}
	});
	textFieldPlafond.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}
	});
		
	PlafondReturnMsg = new JLabel("");
	PlafondReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	PlafondReturnMsg.setForeground(new Color(165, 42, 42));
	PlafondReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(PlafondReturnMsg);
		
		
	//TAUX INTERET
	JLabel lblTaux_interet = new JLabel("Taux d'intérêt:");
	lblTaux_interet.setForeground(Color.WHITE);
	lblTaux_interet.setBounds(186, 362, 125, 21);
	getContentPane().add(lblTaux_interet);
		
	textFieldTaux_interet = new JTextField();
	textFieldTaux_interet.setColumns(10);
	textFieldTaux_interet.setBounds(309, 363, 130, 26);
	getContentPane().add(textFieldTaux_interet);
		
		
	textFieldTaux_interet.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
			NewCompteControler.onLeavingTaux_interetTextField();
		}
	});
	textFieldTaux_interet.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			NewCompteControler.onAddingTextAnywhere();
		}
	});
		
	Taux_interetReturnMsg = new JLabel("");
	Taux_interetReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
	Taux_interetReturnMsg.setForeground(new Color(165, 42, 42));
	Taux_interetReturnMsg.setBounds(825, 64, 151, 31);
	getContentPane().add(Taux_interetReturnMsg);
	
	Nom = new JLabel("");
	Nom.setBounds(703, 123, 130, 16);
	getContentPane().add(Nom);

}

	// addCompteCourantBtn enabler
	public void enableAddCompte_courantBtn() {
		this.btnAddCompte_courant.setEnabled(true);
	}
	
	// addCompteEpargneBtn enabler
	public void enableAddCompte_epargneBtn() {
		this.btnAddCompte_epargne.setEnabled(true);
	}
	
	// Textfields getters and setters
	public String getNom() {
		return this.Nom.getText();
	}
	
	public String getNumero() {
		return this.textFieldNumero.getText();
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
	
	
	public void setNom(String newText) {
		this.Nom.setText(newText);
	}
	
	
	public void setNumero(String newText) {
		this.textFieldNumero.setText(newText);
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
	public void setErrorMsg(String newText) {
		this.NomReturnMsg.setText(newText);
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
			//CurrentSessionData.setOpenAccountForm();
			OuvrirCompteForm testFrame = new OuvrirCompteForm();
			testFrame.setVisible(true);
		}
	
}
