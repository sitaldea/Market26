package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EskaeraEginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;

	/**
	 * Create the frame.
	 */
	public EskaeraEginGUI(String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.userMail = email;
		this.setTitle(userMail);

	}

}
