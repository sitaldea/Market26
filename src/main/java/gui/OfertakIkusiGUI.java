package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;
import domain.Eskaera;
import domain.Oferta;
import domain.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OfertakIkusiGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;
	private JTable table;
	private DefaultTableModel tableModel;

	public OfertakIkusiGUI(String userMail) {
		this.userMail = userMail;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle(userMail);

		String[] columnNames = {
			ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.eskaera"),
			ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.title"),
			ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.description"),
			ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.price"),
			ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.seller")
		};
		
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 865, 380);
		contentPane.add(scrollPane);
		
		JLabel lblTitle = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.title"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(10, 10, 400, 30);
		contentPane.add(lblTitle);

		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.btnClose"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.setBounds(760, 440, 115, 30);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnClose);
		loadOfertas();
	}
	
	private void loadOfertas() {
		try {
			BLFacade facade = MainGUI.getBusinessLogic();
			User user = (User) facade.getUser(userMail);
			
			if (user == null) {
				JOptionPane.showMessageDialog(this, 
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.errorUser"),
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.error"),
					JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			List<Eskaera> eskaerak = user.getEskaerak();
			
			if (eskaerak == null || eskaerak.isEmpty()) {
				JOptionPane.showMessageDialog(this, 
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.noEskaerak"),
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.info"),
					JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			for (Eskaera eskaera : eskaerak) {
				List<Oferta> ofertak = eskaera.getOfertak();
				
				if (ofertak != null && !ofertak.isEmpty()) {
					for (Oferta oferta : ofertak) {
						Object[] row = {
							eskaera.getProductName(),
							oferta.getTitle(),
							oferta.getDescription(),
							String.format("%.2f€", oferta.getPrice()),
							oferta.getUser().getName()
						};
						tableModel.addRow(row);
					}
				}
			}
			
			if (tableModel.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, 
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.noOfertas"),
					ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.info"),
					JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, 
				ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.errorLoading"),
				ResourceBundle.getBundle("Etiquetas").getString("OfertakIkusiGUI.error"),
				JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}