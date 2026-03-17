package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DiruaSartuAteraGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;
	private JComboBox<String> comboBoxKontuak;
	private JLabel lblIzKontuZenb;
	private JTextField textFieldDiruKop;



	/**
	 * Create the frame.
	 */
	public DiruaSartuAteraGUI(String email) {
		this.userMail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzKontuZenb = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("BuyProductGUI.kontu"));
		lblIzKontuZenb.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIzKontuZenb.setBounds(10, 59, 126, 14);
		contentPane.add(lblIzKontuZenb);
		
		JComboBox<String> comboBoxKontuak = new JComboBox<String>();
		comboBoxKontuak.setBounds(186, 57, 215, 20);
		contentPane.add(comboBoxKontuak);
		
		JLabel lblTitle = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Title"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle.setBounds(10, 100, 256, 18);
		contentPane.add(lblTitle);
		
		textFieldDiruKop = new JTextField();
		textFieldDiruKop.setText("0"); 
		textFieldDiruKop.setBounds(231, 100, 86, 20);
		contentPane.add(textFieldDiruKop);
		textFieldDiruKop.setColumns(10);
		
		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Itxi"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(162, 203, 114, 33);
		contentPane.add(btnClose);
		
		JButton btnSartu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Sartu"));
		btnSartu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSartu.setBounds(227, 152, 114, 33);
		contentPane.add(btnSartu);
		
		JButton btnAtera = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Atera")); 
		btnAtera.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtera.setBounds(98, 152, 114, 33);
		contentPane.add(btnAtera);
		
		
		setTitle(userMail);


	}
}
