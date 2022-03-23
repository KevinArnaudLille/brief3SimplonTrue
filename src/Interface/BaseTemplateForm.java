package Interface;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BaseTemplateForm extends JFrame {
	// ==== Some variables declared outside constructor to allow Getters and Setters ====
	protected JPanel header;
	protected JLabel titlePageLabel;
	
	public BaseTemplateForm() {
		// ==== General frame behavior ====
		// == Programm killed on window close ==
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// == Main frame settings ==
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 20));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(0, 128, 128));
		setAutoRequestFocus(false);
		setUndecorated(false);
		setResizable(false);	
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(null);
		
		// *******************************************************
		// ==== Header settings ====
		header = new JPanel();
		header.setBackground(new Color(0, 0, 128));
		header.setBounds(0, 0, 1000, 40);
		header.setLayout(null);
		getContentPane().add(header);
		
		// *******************************************************
		// ==== Title settings ====
		titlePageLabel = new JLabel("");
		titlePageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePageLabel.setForeground(Color.WHITE);
		titlePageLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titlePageLabel.setBounds(10, 6, 965, 29);
		header.add(titlePageLabel);
	}
}