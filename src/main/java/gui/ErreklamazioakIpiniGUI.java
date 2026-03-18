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

public class ErreklamazioakIpiniGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Sale sale;
	private String userMail;
	private JTextField textFieldTitulua;
	private JTextField textFieldDeskripzioa;


	/**
	 * Create the frame.
	 */
	public ErreklamazioakIpiniGUI(Sale sale, String email) {
		this.sale = sale;
		this.userMail = email;
		setTitle(userMail);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulua = new JLabel("New label");
		lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulua.setBounds(74, 52, 135, 14);
		contentPane.add(lblTitulua);
		
		textFieldTitulua = new JTextField();
		textFieldTitulua.setBounds(255, 50, 240, 20);
		contentPane.add(textFieldTitulua);
		textFieldTitulua.setColumns(10);
		
		textFieldDeskripzioa = new JTextField();
		textFieldDeskripzioa.setBounds(255, 95, 240, 61);
		contentPane.add(textFieldDeskripzioa);
		textFieldDeskripzioa.setColumns(10);
		
		JLabel lblAukeratu = new JLabel("New label");
		lblAukeratu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAukeratu.setBounds(74, 189, 171, 14);
		contentPane.add(lblAukeratu);
		
		JButton btnAukeratu = new JButton("New button");
		btnAukeratu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAukeratu.setBounds(255, 181, 107, 31);
		contentPane.add(btnAukeratu);
		
		JButton btnErreklamazioaIpini = new JButton("New button");
		btnErreklamazioaIpini.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnErreklamazioaIpini.setBounds(161, 271, 107, 31);
		contentPane.add(btnErreklamazioaIpini);
		
		JButton btnItxi = new JButton("New button");
		btnItxi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnItxi.setBounds(300, 271, 107, 31);
		contentPane.add(btnItxi);
		
		JLabel lblDeskripzioa = new JLabel("New label");
		lblDeskripzioa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeskripzioa.setBounds(74, 95, 135, 14);
		contentPane.add(lblDeskripzioa);

	}
}
