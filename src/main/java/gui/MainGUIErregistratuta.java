package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainGUIErregistratuta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private JButton btnQuearySale;
	private JButton btnCreateSale;
	private JLabel lblSelectOption;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 * @param email 
	 */
	public MainGUIErregistratuta(String email) {
		this.userMail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 0, 0, 0));

		lblSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.SelectOption"));
		lblSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSelectOption);

		btnCreateSale = new JButton();
		btnCreateSale.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.CreateSale"));
		btnCreateSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new CreateSaleGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnCreateSale);

		btnQuearySale = new JButton();
		btnQuearySale.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.QuerySales"));
		btnQuearySale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new QuerySalesGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnQuearySale);

		setTitle(userMail);

		rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en"));
				paintAgain();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Euskara");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("eus"));
				paintAgain();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("es"));
				paintAgain();
			}
		});
		
		btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErositakoProduktuakIkusi")); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new ErositakoProduktuakIkusiGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		buttonGroup.add(rdbtnNewRadioButton_2);

		panel = new JPanel();
		panel.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_2);
		panel.add(rdbtnNewRadioButton);
		contentPane.add(panel);
	}

	private void paintAgain() {
		lblSelectOption.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.SelectOption"));
		btnCreateSale.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.CreateSale"));
		btnQuearySale.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.QuerySales"));
		btnNewButton.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErositakoProduktuakIkusi"));
		this.setTitle(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.MainTitle")
						+ ": " + userMail);
	}
}
