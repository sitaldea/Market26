package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldPass2;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param sellerMail 
	 */
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(38, 50, 80, 12);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 91, 67, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Errepikatu pasahitza:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(38, 134, 120, 12);
		contentPane.add(lblNewLabel_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(157, 48, 237, 18);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(157, 89, 237, 18);
		contentPane.add(passwordFieldPass);
		
		passwordFieldPass2 = new JPasswordField();
		passwordFieldPass2.setBounds(157, 132, 237, 18);
		contentPane.add(passwordFieldPass2);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnErregistratu.setBounds(157, 188, 116, 33);
		contentPane.add(btnErregistratu);

	}
}
