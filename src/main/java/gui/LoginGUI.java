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
		setBounds(100, 100, 457, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.Email"));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(46, 52, 130, 12);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.Password"));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(46, 97, 130, 12);
		contentPane.add(lblPassword);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(186, 49, 191, 18);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(186, 94, 191, 18);
		contentPane.add(passwordFieldPass);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.Login"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		btnNewButton.setBounds(144, 168, 156, 49);
		contentPane.add(btnNewButton);

	}
}