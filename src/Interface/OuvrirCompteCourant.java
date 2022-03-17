package Interface;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;

import db.DbReadQueries;
import model.Client;
import model.Conseiller;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Label;

public class OuvrirCompteCourant extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	public OuvrirCompteCourant() {
		
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
			
			textField = new JTextField();
			textField.setBounds(309, 118, 130, 26);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(703, 189, 130, 26);
			getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(309, 189, 130, 26);
			getContentPane().add(textField_2);
			
			JLabel lblNewLabel_1 = new JLabel("Numéro de compte:");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(172, 123, 125, 16);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Nom du client:");
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setBounds(592, 123, 99, 16);
			getContentPane().add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Si différent (tutelle):");
			lblNewLabel_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1.setBounds(561, 192, 130, 21);
			getContentPane().add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Solde initial:");
			lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1_1.setBounds(217, 192, 78, 21);
			getContentPane().add(lblNewLabel_1_1_1_1);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Compte courant");
			rdbtnNewRadioButton.setForeground(Color.WHITE);
			rdbtnNewRadioButton.setBounds(339, 256, 141, 23);
			getContentPane().add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnComptepargne = new JRadioButton("Compte épargne");
			rdbtnComptepargne.setForeground(Color.WHITE);
			rdbtnComptepargne.setBounds(532, 256, 141, 23);
			getContentPane().add(rdbtnComptepargne);
			
			JButton btnNewButton = new JButton("Valider"); 
			btnNewButton.setBounds(437, 401, 117, 29);
			getContentPane().add(btnNewButton);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(309, 316, 130, 26);
			getContentPane().add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(703, 316, 130, 26);
			getContentPane().add(textField_5);
			
			JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Frais de transfert:");
			lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1_1_1.setBounds(186, 319, 125, 21);
			getContentPane().add(lblNewLabel_1_1_1_1_1);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("Solde minimum autorisé:");
			lblNewLabel_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_1_1_2.setBounds(523, 321, 181, 16);
			getContentPane().add(lblNewLabel_1_1_2);
			

	}
}
