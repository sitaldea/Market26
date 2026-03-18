package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Sale;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErreklamazioakIpiniGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Sale sale;
	private String userMail;
	private JTextField textFieldTitulua;
	private JTextField textFieldDeskripzioa;
	private JLabel lblTitulua;
	private JLabel lblDeskripzioa;
	private JLabel lblAukeratu;
	private JButton btnAukeratu;
	private JButton btnErreklamazioaIpini;
	private JButton btnItxi;


	/**
	 * Create the frame.
	 */
	public ErreklamazioakIpiniGUI(Sale sale, String email) {
		this.sale = sale;
		this.userMail = email;
		setTitle(userMail);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulua = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.Titulua"));
		lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulua.setBounds(74, 52, 135, 14);
		contentPane.add(lblTitulua);
		
		textFieldTitulua = new JTextField();
		textFieldTitulua.setBounds(345, 51, 278, 19);
		contentPane.add(textFieldTitulua);
		textFieldTitulua.setColumns(10);
		
		textFieldDeskripzioa = new JTextField();
		textFieldDeskripzioa.setBounds(345, 95, 278, 112);
		contentPane.add(textFieldDeskripzioa);
		textFieldDeskripzioa.setColumns(10);
		
		JLabel lblAukeratu = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.Aukeratu"));
		lblAukeratu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAukeratu.setBounds(74, 235, 261, 14);
		contentPane.add(lblAukeratu);
		
		JButton btnAukeratu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.botoiAukeratu"));
		btnAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAukeratu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAukeratu.setBounds(345, 227, 174, 31);
		contentPane.add(btnAukeratu);
		
		JButton btnErreklamazioaIpini = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.erreklamazioaIpini"));
		btnErreklamazioaIpini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnErreklamazioaIpini.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnErreklamazioaIpini.setBounds(229, 320, 148, 31);
		contentPane.add(btnErreklamazioaIpini);
		
		JButton btnItxi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.itxi"));
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnItxi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnItxi.setBounds(405, 320, 148, 31);
		contentPane.add(btnItxi);
		
		JLabel lblDeskripzioa = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ErreklamazioakIpiniGUI.deskripzioa"));
		lblDeskripzioa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeskripzioa.setBounds(74, 95, 261, 14);
		contentPane.add(lblDeskripzioa);

	}
}
