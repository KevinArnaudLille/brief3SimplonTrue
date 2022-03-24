package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controler.UpdateCompteControler;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

/* ==============================================
 * IN PROGRESS (CURRENTLY UNUSED)
 * ==============================================*/

public class ModifierCompteForm extends BaseTemplateForm {
	
	private JTextField textFieldFraisDeTransfert;
	private JLabel fraisDeTransfertReturnMsg;
	private JTextField textFieldTauxInteret;
	private JLabel tauxInteretReturnMsg;
	private JButton btnUpdateCompteValidation;
	
	public ModifierCompteForm() {
		super();
		titlePageLabel.setText("Modifier les informations du compte " + "HERE Compte Numero" + " de " + "HERE Client prenom et nom");

		// Frais de Transfert
		if (CurrentSessionData.getCompteToUpdate() instanceof CompteCourant) {
			JLabel lblFraisDeTransfert = new JLabel("Frais de transfert :");
			lblFraisDeTransfert.setForeground(new Color(255, 255, 255));
			lblFraisDeTransfert.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFraisDeTransfert.setBounds(156, 202, 181, 31);
			getContentPane().add(lblFraisDeTransfert);

			textFieldFraisDeTransfert = new JTextField();
			textFieldFraisDeTransfert.setFont(new Font("Arial", Font.PLAIN, 20));
			textFieldFraisDeTransfert.setBounds(331, 202, 279, 31);
			getContentPane().add(textFieldFraisDeTransfert);
			textFieldFraisDeTransfert.setColumns(10);
			textFieldFraisDeTransfert.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					UpdateCompteControler.onAddingTextInFraisDeTransfert();
				}
			});
			
			fraisDeTransfertReturnMsg = new JLabel("");
			fraisDeTransfertReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
			fraisDeTransfertReturnMsg.setForeground(new Color(165, 42, 42));
			fraisDeTransfertReturnMsg.setBounds(620, 202, 317, 31);
			getContentPane().add(fraisDeTransfertReturnMsg);
		}
		
		
		// Taux d'interêt
		if (CurrentSessionData.getCompteToUpdate() instanceof CompteEpargne) {
			JLabel lblTauxInteret = new JLabel("Frais de transfert :");
			lblTauxInteret.setForeground(new Color(255, 255, 255));
			lblTauxInteret.setFont(new Font("Arial", Font.PLAIN, 20));
			lblTauxInteret.setBounds(156, 202, 181, 31);
			getContentPane().add(lblTauxInteret);

			textFieldTauxInteret = new JTextField();
			textFieldTauxInteret.setFont(new Font("Arial", Font.PLAIN, 20));
			textFieldTauxInteret.setBounds(331, 202, 279, 31);
			getContentPane().add(textFieldTauxInteret);
			textFieldTauxInteret.setColumns(10);
			textFieldTauxInteret.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					UpdateCompteControler.onAddingTextInTauxInteret();
				}
			});
			
			tauxInteretReturnMsg = new JLabel("");
			tauxInteretReturnMsg.setFont(new Font("Arial", Font.BOLD, 18));
			tauxInteretReturnMsg.setForeground(new Color(165, 42, 42));
			tauxInteretReturnMsg.setBounds(620, 202, 317, 31);
			getContentPane().add(tauxInteretReturnMsg);
		}
		
		// BUTTONS
		// add client to db
		btnUpdateCompteValidation = new JButton("Modifier le compte");
		btnUpdateCompteValidation.setFont(new Font("Arial", Font.BOLD, 24));
		btnUpdateCompteValidation.setBounds(230, 383, 260, 40);
		getContentPane().add(btnUpdateCompteValidation);
		btnUpdateCompteValidation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// here controller call
			}
		});
		btnUpdateCompteValidation.setEnabled(false);

		// return to previous client list page
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 24));
		btnCancel.setBounds(540, 383, 229, 40);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCompteControler.onCancelBtnClick();
			}
		});
		
	}
	
	
	// addClientBtn enabler
	public void enablebtnUpdateCompteValidation() {
		this.btnUpdateCompteValidation.setEnabled(true);
	}

	public void disablebtnUpdateCompteValidation() {
		this.btnUpdateCompteValidation.setEnabled(false);
	}
	
	
	// Textfields getters and setters
	public JTextField getTextFieldFraisDeTransfert() {
		return textFieldFraisDeTransfert;
	}

	public JLabel getFraisDeTransfertReturnMsg() {
		return fraisDeTransfertReturnMsg;
	}

	public JTextField getTextFieldTauxInteret() {
		return textFieldTauxInteret;
	}

	public JLabel getTauxInteretReturnMsg() {
		return tauxInteretReturnMsg;
	}
	

	public static void main(String[] args) {
		ModifierCompteForm testFrame = new ModifierCompteForm();
		testFrame.enablebtnUpdateCompteValidation();
		testFrame.setVisible(true);
		CurrentSessionData.setUpdateComptePage(testFrame);

	}

}
