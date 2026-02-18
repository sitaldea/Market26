package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldPass2;
	private JTextField textTelefonoa;
	private JTextField textIzena;

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
		
		JLabel mensaje = new JLabel("");
		mensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mensaje.setBounds(157, 250, 300, 18);
		contentPane.add(mensaje);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        BLFacade facade = MainGUI.getBusinessLogic();
		        String email = textFieldEmail.getText().trim();
		        String telefonoa = textTelefonoa.getText().trim();
		        String izena = textIzena.getText().trim();
		        String pasword1 = new String(passwordFieldPass.getPassword());
		        String pasword2 = new String(passwordFieldPass2.getPassword());

		        if(email.isEmpty() || telefonoa.isEmpty() || izena.isEmpty() || pasword1.isEmpty() || pasword2.isEmpty()) {
		            mensaje.setForeground(Color.RED);
		            mensaje.setText("Eremu guztiak bete behar dira");
		            return;
		        }

		        User u = facade.getUser(email);
		        if(u != null) {
		            mensaje.setForeground(Color.RED);
		            mensaje.setText("Email hori dagoeneko erregistratuta dago");
		            return;
		        }

		        if(!pasword1.equals(pasword2)) {
		            mensaje.setForeground(Color.RED);
		            mensaje.setText("Pasahitzak ez dira berdinak");
		            return;
		        }

		        facade.addUser(email, pasword1, izena, telefonoa);
		        mensaje.setForeground(new Color(0, 128, 0));
		        mensaje.setText("Erregistroa ondo burutu da");

		        textFieldEmail.setText("");
		        textTelefonoa.setText("");
		        textIzena.setText("");
		        passwordFieldPass.setText("");
		        passwordFieldPass2.setText("");
		    }
		});
		btnErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnErregistratu.setBounds(97, 220, 116, 33);
		contentPane.add(btnErregistratu);
		
		JLabel lblTelefonoa = new JLabel("Telefonoa:");
		lblTelefonoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefonoa.setBounds(38, 105, 80, 12);
		contentPane.add(lblTelefonoa);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIzena.setBounds(38, 29, 44, 12);
		contentPane.add(lblIzena);
		
		textTelefonoa = new JTextField();
		textTelefonoa.setBounds(157, 103, 237, 18);
		contentPane.add(textTelefonoa);
		textTelefonoa.setColumns(10);
		
		textIzena = new JTextField();
		textIzena.setBounds(157, 27, 237, 18);
		contentPane.add(textIzena);
		textIzena.setColumns(10);
		
		JButton btnNewButton = new JButton("Itxi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(250, 220, 128, 33);
		contentPane.add(btnNewButton);

	}
}
