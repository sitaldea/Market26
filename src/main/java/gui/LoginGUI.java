package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JOptionPane;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;


	/**
	 * Create the frame.
	 * @param sellerMail 
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.Email"));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(92, 131, 130, 12);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.Password"));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(92, 164, 130, 12);
		contentPane.add(lblPassword);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(244, 129, 217, 18);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(244, 162, 217, 18);
		contentPane.add(passwordFieldPass);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.Login"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				String email = textFieldEmail.getText();
				String pass = new String(passwordFieldPass.getPassword());
				User s = facade.isLogin(email, pass);
				if(s!=null) {
					dispose();
					MainGUIErregistratuta a = new MainGUIErregistratuta(s.getEmail());
					a.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(LoginGUI.this, ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.ErrorQueary"), ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.Error"), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(108, 248, 173, 55);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("RegisterGUI.CancelButton"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(342, 248, 173, 55);
		contentPane.add(btnClose);

	}
}