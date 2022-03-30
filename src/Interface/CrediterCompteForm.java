package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CrediterCompteForm extends JFrame {

	private JPanel contentPane;
	private JTextField CrediterUnCompte;
	private JTextField ClientName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrediterCompteForm frame = new CrediterCompteForm();
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
	public CrediterCompteForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000 , 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CrediterUnCompte = new JTextField();
		CrediterUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		CrediterUnCompte.setFont(new Font("Arial", Font.BOLD, 25));
		CrediterUnCompte.setForeground(Color.WHITE);
		CrediterUnCompte.setText("Cr\u00E9diter un compte");
		CrediterUnCompte.setBackground(new Color(0, 0, 128));
		CrediterUnCompte.setBounds(0, 0, 986, 44);
		contentPane.add(CrediterUnCompte);
		CrediterUnCompte.setColumns(10);
		
		JLabel NomClient = new JLabel("Nom du client :");
		NomClient.setHorizontalAlignment(SwingConstants.CENTER);
		NomClient.setForeground(Color.WHITE);
		NomClient.setFont(new Font("Arial", Font.BOLD, 20));
		NomClient.setBounds(234, 148, 154, 29);
		contentPane.add(NomClient);
		
		ClientName = new JTextField();
		ClientName.setHorizontalAlignment(SwingConstants.CENTER);
		ClientName.setBounds(417, 144, 182, 44);
		contentPane.add(ClientName);
		ClientName.setColumns(10);
		
		JLabel AmountCredited = new JLabel(" Montant cr\u00E9diter :");
		AmountCredited.setForeground(Color.WHITE);
		AmountCredited.setHorizontalAlignment(SwingConstants.CENTER);
		AmountCredited.setFont(new Font("Arial", Font.BOLD, 20));
		AmountCredited.setBounds(236, 246, 187, 29);
		contentPane.add(AmountCredited);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(433, 242, 138, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(417, 354, 178, 44);
		contentPane.add(btnNewButton);
	}
}
