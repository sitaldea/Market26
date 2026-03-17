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
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
	private JButton btnErositakoProduktuak;
	private JButton btnDirua;
	private JButton btnMugimenduak;
	private JButton btnNeLogOut;
	private JButton btnErreklamazioakIkusi;

	/**
	 * Create the frame.
	 * @param email 
	 */
	public MainGUIErregistratuta(String email) {
		this.userMail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 328);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("238px"),
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("237px"),},
			new RowSpec[] {
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("38px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("37px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("38px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("48px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("32px"),}));

		lblSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.SelectOption"));
		lblSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSelectOption, "2, 2, 3, 1, fill, fill");

		btnCreateSale = new JButton();
		btnCreateSale.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.CreateSale"));
		btnCreateSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new CreateSaleGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnCreateSale, "2, 4, fill, fill");

		btnDirua = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.Dirua"));
		btnDirua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new DiruaSartuAteraGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnDirua, "4, 4, fill, fill");

		btnQuearySale = new JButton();
		btnQuearySale.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.QuerySales"));
		btnQuearySale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new QuerySalesGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnQuearySale, "2, 6, fill, fill");
					
					btnMugimenduak = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.Mugimenduak"));
					btnMugimenduak.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							JFrame a = new MugimenduakIkusiGUI(userMail);
							a.setVisible(true);
						}
					});
					contentPane.add(btnMugimenduak, "4, 6, fill, fill");

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
		
				btnErositakoProduktuak = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErositakoProduktuakIkusi"));
				btnErositakoProduktuak.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFrame a = new ErositakoProduktuakIkusiGUI(userMail);
			a.setVisible(true);
					}
				});
				contentPane.add(btnErositakoProduktuak, "2, 8, fill, fill");
		
		btnErreklamazioakIkusi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErreklamazioakIkusi"));
		btnErreklamazioakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new ErreklamazioakOnartuDeuseztatuGUI(userMail);
				a.setVisible(true);
			}
		});
		contentPane.add(btnErreklamazioakIkusi, "4, 8, fill, fill");
		
		btnNeLogOut = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.SaioaItxi"));
		btnNeLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		contentPane.add(btnNeLogOut, "2, 12, 3, 1, center, fill");
		buttonGroup.add(rdbtnNewRadioButton_2);

		panel = new JPanel();
		panel.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_2);
		panel.add(rdbtnNewRadioButton);
		contentPane.add(panel, "2, 10, 3, 1, fill, fill");

		setTitle(userMail);
	}

	private void paintAgain() {
		lblSelectOption.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.SelectOption"));
		btnCreateSale.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.CreateSale"));
		btnQuearySale.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.QuerySales"));
		btnErositakoProduktuak.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErositakoProduktuakIkusi"));
		btnDirua.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.Dirua"));
		btnMugimenduak.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.Mugimenduak"));
		btnNeLogOut.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.SaioaItxi"));
		btnErreklamazioakIkusi.setText(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUIErregistratuta.ErreklamazioakIkusi"));
		this.setTitle(
				ResourceBundle.getBundle("Etiquetas").getString("MainGUI.MainTitle")
				+ ": " + userMail);
	}
}