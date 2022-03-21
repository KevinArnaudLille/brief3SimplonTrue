package Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BaseTemplateForm extends JFrame {
	protected JPanel panel;
	protected JLabel titlePageLabel;
	
	public BaseTemplateForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 20));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(0, 128, 128));
		setAutoRequestFocus(false);
		setUndecorated(false);
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(null);
		setResizable(false);	
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 1000, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		titlePageLabel = new JLabel("");
		titlePageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePageLabel.setForeground(Color.WHITE);
		titlePageLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titlePageLabel.setBounds(10, 6, 965, 29);
		panel.add(titlePageLabel);
	}
}
