package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.DiruKontua;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        BLFacade facade = MainGUI.getBusinessLogic();
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
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(162, 203, 114, 33);
		contentPane.add(btnClose);
		
		JButton btnSartu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Sartu"));
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String kontuZenb = comboBoxKontuak.getSelectedItem().toString();
				  float diruKopSartu = Float.parseFloat(textFieldDiruKop.getText());
	              double diruKop = facade.getDiruKop(kontuZenb);
	              facade.updateDiruKop(kontuZenb, diruKop + diruKopSartu);
	              JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.SartuMessage"));
			}
		});
		btnSartu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSartu.setBounds(227, 152, 114, 33);
		contentPane.add(btnSartu);
		
		JButton btnAtera = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.Atera")); 
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kontuZenb = comboBoxKontuak.getSelectedItem().toString();
				  float diruKopAtera = Float.parseFloat(textFieldDiruKop.getText());
	              double diruKop = facade.getDiruKop(kontuZenb);
	              if (diruKop < diruKopAtera) {
	            	  JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.EzDagoDiruKopMessage"), "Error",
								JOptionPane.ERROR_MESSAGE);
	              } else {
	            	  facade.updateDiruKop(kontuZenb, diruKop - diruKopAtera);
		              JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("Etiquetas").getString("DiruaSartuAteraGUI.AteraMessage")); 
	              }
			}
		});
		btnAtera.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtera.setBounds(98, 152, 114, 33);
		contentPane.add(btnAtera);
		
		
		setTitle(userMail);
		

		 User user = facade.getUserAccounts(userMail); 
	        if (user != null && user.getKontuak() != null) {
	            for (DiruKontua k : user.getKontuak()) {
	                comboBoxKontuak.addItem(k.getKontuZenb());
	            }
	        }


	}
}
