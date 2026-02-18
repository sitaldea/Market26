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
	private JTextField textField;
	private JTextField textField_1;

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
		lblEmail.setBounds(38, 67, 80, 12);
		contentPane.add(lblEmail);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasahitza.setBounds(38, 140, 67, 12);
		contentPane.add(lblPasahitza);
		
		JLabel lblPasahitzaRep = new JLabel("Errepikatu pasahitza:");
		lblPasahitzaRep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasahitzaRep.setBounds(38, 179, 120, 18);
		contentPane.add(lblPasahitzaRep);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(157, 65, 237, 18);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(157, 138, 237, 18);
		contentPane.add(passwordFieldPass);
		
		passwordFieldPass2 = new JPasswordField();
		passwordFieldPass2.setBounds(157, 180, 237, 18);
		contentPane.add(passwordFieldPass2);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnErregistratu.setBounds(157, 220, 116, 33);
		contentPane.add(btnErregistratu);
		
		JLabel lblTelefonoa = new JLabel("Telefonoa:");
		lblTelefonoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefonoa.setBounds(38, 105, 80, 12);
		contentPane.add(lblTelefonoa);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIzena.setBounds(38, 29, 44, 12);
		contentPane.add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(157, 103, 237, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 27, 237, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}
}
